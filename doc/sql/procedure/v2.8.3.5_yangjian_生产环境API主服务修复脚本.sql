-- 修复联系人姓名和联系人手机号
DROP PROCEDURE if exists update_linkName_linkPhome; 
DELIMITER $$  
CREATE procedure update_linkName_linkPhome()
BEGIN 
DECLARE doneFlag INT DEFAULT FALSE; 
DECLARE comId BIGINT(32) 	DEFAULT '-1';
DECLARE userId BIGINT(32) 	DEFAULT '-1';
DECLARE linkmanName VARCHAR(128) DEFAULT '';
DECLARE linkmanPhone VARCHAR(128) DEFAULT '';

DECLARE userInfoCursor CURSOR FOR(select a.com_id as com_id,a.linkman_name as linkman_name,a.linkman_phone as linkman_phone ,b.user_id as user_id from
(select com_id,linkman_name,linkman_phone from `yinuojr_bunuo`.`company_detail` where com_id in (select cus_id from `yinuojr_bunuo`.`company_user` where has_admin = 1)) a
LEFT JOIN (select cus_id,user_id from `yinuojr_bunuo`.`company_user` where has_admin = 1)b on a.com_id = b.cus_id);
DECLARE CONTINUE HANDLER FOR NOT FOUND SET doneFlag = TRUE;

OPEN userInfoCursor;
updateUserInfoLoop: LOOP
FETCH userInfoCursor INTO comId,linkmanName,linkmanPhone,userId;
   if doneFlag THEN 
     LEAVE updateUserInfoLoop;
   end IF;
   UPDATE `yinuojr_user`.`user` set 
           `yinuojr_user`.`user`.true_name = (CASE when `yinuojr_user`.`user`.true_name ='' then linkmanName else `yinuojr_user`.`user`.true_name end),
           `yinuojr_user`.`user`.phone = (CASE when `yinuojr_user`.`user`.phone ='' then linkmanPhone else `yinuojr_user`.`user`.phone end) where `yinuojr_user`.`user`.id = userId;
COMMIT; 
END LOOP updateUserInfoLoop;
CLOSE userInfoCursor;

END $$
DELIMITER ;
CALL update_linkName_linkPhome();
DROP PROCEDURE if exists update_linkName_linkPhome; 