BEGIN
  -- 遍历数据结束标志  
  DECLARE done INT DEFAULT FALSE;
  -- 变量 user_id
  DECLARE userId INT;
  -- 变量 role_code
  DECLARE roleCode VARCHAR(55);
  -- 定义游标
  DECLARE cur CURSOR FOR SELECT user_id,role_code FROM user_role WHERE role_code != 'anybody'; 
  -- 异常处理
  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET Done = 1;
  -- 打开游标
  OPEN cur;
  read_loop: LOOP
    -- 取出来游标数据
    FETCH cur INTO userId,roleCode;
      -- 遍历数据表  
      IF done THEN
        LEAVE read_loop;
      END IF;
         INSERT INTO user_role(`user_id`,`role_code`,`c_t`, `u_t`,`is_deleted`) VALUES(userId,'anybody',unix_timestamp(now()),unix_timestamp(now()),0) 
          ON DUPLICATE KEY UPDATE user_id = userId AND role_code = 'anybody';
      SELECT userId;
  END LOOP;
  CLOSE cur;
END
=============================
BEGIN
DECLARE total BIGINT;
DECLARE indexi BIGINT;
SET indexi=1;

SELECT count(id) INTO total FROM company;

WHILE indexi <= total DO
  INSERT INTO company_tmp (
    `id`,
    `name`,
    `com_type`,
    `blockchain_address`,
    `operator_id`,
    `channel_id`,
    `channel_type`,
    `remark`,
    `status`,
    `enable`,
    `is_deleted`,
    `create_time`,
    `update_time`,
    `authentication`)
  SELECT
    `id`,
    `name`,
    get_com_type(indexi) as com_type,
    `blockchain_address`,
    0,
    0,
    0,
    `remark`,
    `status`,
    `enable`,
    `is_deleted`,
    `create_time`,
    `update_time`,
    `authentication`
  FROM
    company
  WHERE id=indexi;
  
SET indexi=indexi+1;
END WHILE;
RETURN "success";
END
==============================
BEGIN

##声明变量
DECLARE comId BIGINT;
DECLARE operId BIGINT;
DECLARE comType VARCHAR(255);
DECLARE comName VARCHAR(255);
DECLARE done INT DEFAULT FALSE;
DECLARE result VARCHAR(32);

##声明游标
DECLARE it CURSOR FOR SELECT id, `name`,com_type,operator_id FROM company;

##异常处理
DECLARE CONTINUE HANDLER FOR NOT FOUND  SET done = true;

##打开游标
  OPEN it;
    ##遍历company
    myLoop: LOOP
    FETCH NEXT FROM it INTO comId,comName,comType,operId;
      ##平台方
      IF LOCATE('0,',comType) > 0 THEN
        ITERATE myLoop;
      ##运营方
      ELSEIF LOCATE('1,',comType) > 0 THEN
        ITERATE myLoop;
      ##渠道
      ELSEIF LOCATE('3,',comType) > 0 THEN
        ITERATE myLoop;
      ##核心企业
      ELSEIF LOCATE('2,',comType) > 0 THEN
        SELECT vipConfig(comId,comName,2) INTO result;
        SELECT financeConfig(comId,operId,comName,2) INTO result;
      ##资金方
      ELSEIF LOCATE('4,',comType) > 0 THEN
        SELECT vipConfig(comId,comName,4) INTO result;
        SELECT financeConfig(comId,operId,comName,4) INTO result;
      ##供应商
      ELSE
        SELECT vipConfig(comId,comName,5) INTO result;
        SELECT financeConfig(comId,operId,comName,5) INTO result;
      END IF;
      IF done THEN
        LEAVE myLoop;
      END IF;
  END LOOP;
  ##关闭游标
  CLOSE it;
RETURN result;
END
===========
BEGIN
DECLARE fundId BIGINT;
DECLARE configId BIGINT;
DECLARE done INT DEFAULT FALSE;
##声明游标
DECLARE fit CURSOR FOR SELECT id FROM company WHERE LOCATE('4,',com_type) > 0 AND operator_id=operId;
DECLARE CONTINUE HANDLER FOR NOT FOUND  SET done = true;

IF comType = 4 THEN
  INSERT INTO fee_financing_config(
      `opt_id`,
      `fund_id`,
      `type`,
      `settlement_unit`,
      `settlement_cyc`,
      `settlement_time`,
      `is_free`,
      `free_unit`,
      `free_cyc`,
      `create_time`,
      `update_time`,
      `is_delete`,
      `version`
      ) VALUES (
      operId,
      comId,
      1,
      2,
      3,
      25,
      1,
      3,
      10,
      unix_timestamp()*1000,
      unix_timestamp()*1000,
      0,
      1
      );
      
      SELECT LAST_INSERT_ID() INTO configId;
      INSERT INTO fee_financing_config_detail(
      `config_id`,
      `pay_type`,
      `pay_ratio`,
      `charges_type`,
      `create_time`,
      `update_time`,
      `is_delete`
      ) VALUES (
      configId,
      2,
      2000,
      1,
      unix_timestamp()*1000,
      unix_timestamp()*1000,
      0);
ELSE
  ##配置当前运营方下的所有资金方
  OPEN fit;
  ##遍历资金方
  fundLoop: LOOP
    FETCH NEXT FROM fit INTO fundId;

    IF comType=2 THEN
      INSERT INTO fee_financing_config(
      `opt_id`,
      `fund_id`,
      `core_id`,
      `type`,
      `settlement_unit`,
      `settlement_cyc`,
      `settlement_time`,
      `is_free`,
      `free_unit`,
      `free_cyc`,
      `create_time`,
      `update_time`,
      `is_delete`,
      `version`
      ) VALUES (
      operId,
      fundId,
      comId,
      1,
      2,
      3,
      25,
      1,
      3,
      10,
      unix_timestamp()*1000,
      unix_timestamp()*1000,
      0,
      1
      );
      
      SELECT LAST_INSERT_ID() INTO configId;
      INSERT INTO fee_financing_config_detail(
      `config_id`,
      `pay_type`,
      `pay_ratio`,
      `charges_type`,
      `create_time`,
      `update_time`,
      `is_delete`
      ) VALUES (
      configId,
      2,
      2000,
      1,
      unix_timestamp()*1000,
      unix_timestamp()*1000,
      0);
    ELSE
      INSERT INTO fee_financing_config(
      `opt_id`,
      `sup_id`,
      `fund_id`,
      `type`,
      `settlement_unit`,
      `settlement_cyc`,
      `settlement_time`,
      `is_free`,
      `free_unit`,
      `free_cyc`,
      `create_time`,
      `update_time`,
      `is_delete`,
      `version`
      ) VALUES (
      operId,
      comId,
      fundId,
      1,
      2,
      3,
      25,
      1,
      3,
      10,
      unix_timestamp()*1000,
      unix_timestamp()*1000,
      0,
      1
      );
      
      SELECT LAST_INSERT_ID() INTO configId;
      INSERT INTO fee_financing_config_detail(
      `config_id`,
      `pay_type`,
      `pay_ratio`,
      `charges_type`,
      `create_time`,
      `update_time`,
      `is_delete`
      ) VALUES (
      configId,
      5,
      8000,
      1,
      unix_timestamp()*1000,
      unix_timestamp()*1000,
      0);
    END IF;
    IF done THEN
      LEAVE fundLoop;
    END IF;
END LOOP;
##关闭游标
CLOSE fit;
END IF;

RETURN 'success';
END
========================
BEGIN
DECLARE result VARCHAR(32) DEFAULT '';
DECLARE core TINYINT;
DECLARE supplier TINYINT;
DECLARE financial TINYINT;

SELECT has_financial,has_core,has_supplier INTO financial,core,supplier FROM company WHERE company.id=num;

IF core >= 1 THEN
  SET result=CONCAT(result, '2,' );
  END IF;
IF supplier >= 1 THEN
  SET result=CONCAT(result, '5,' );
  END IF;
IF financial >= 1 THEN
  SET result=CONCAT(result, '4,' );
  END IF;
RETURN result;
END
====================================
BEGIN
DECLARE uid BIGINT;
DECLARE cid BIGINT;

SELECT MAX(id) INTO uid FROM `user`;

INSERT INTO `salt`(`salt`, `user_id`) VALUES ('etcmTk', uid);

INSERT INTO `user_role`(`user_id`, `role_code`, `c_t`, `u_t`, `is_deleted`) VALUES (uid, 'p_admin', 1, 1, 0);


SELECT MAX(id) INTO cid FROM company;

INSERT INTO `company_user`(`user_id`, `cus_id`, `c_t`, `u_t`, `is_deleted`, `has_admin`) VALUES (uid, cid, 1521617020936, 1521617020936, 0, 1);

RETURN 'success';
END
====================================
BEGIN
INSERT INTO fee_vip_config(
      `com_id`,
      `com_name`,
      `com_type`,
      `amount`,
      `settlement_unit`,
      `settlement_cyc`,
      `is_free`,
      `free_unit`,
      `free_cyc`,
      `create_time`,
      `update_time`,
      `is_delete`,
      `version`
      ) VALUES (
      comId,
      comName,
      comType,
      30000,
      1,
      2,
      1,
      2,
      3,
      unix_timestamp()*1000,
      unix_timestamp()*1000,
      0,
      1
      );
RETURN 'success';
END





