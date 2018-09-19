===============================================================无线网=============================================================================
bubi#07150926


===========================================================区块链查看基本信息===========================================================
http://192.168.10.86:19333/getAccount?address=a001199f8026a2c5829a55c4d2672dc115f19944912d7c
http://192.168.6.46:19333/getAccount?address=a001da7e6a34aaba1e728a99eacb99b9dca5751bb503c1
-- 测试环境查看区块链地址
http://192.168.5.68:19333/getAccount?address=a0019b9a6b48a6c5bfe432ec441c4a09e473c8a6ad8251


============================================================开发环境地址：===========================================================================
API：192.168.6.74 					用户名：root 密码：bubi    /bubidata/server/data/yinuojr-api/logs
实名：192.168.6.71 					用户名：root 密码：bubi
支付：192.168.6.72 					用户名：root 密码：bubi
支付前置：192.168.6.46 				用户名：root 密码：bubi
RA：192.168.6.67   					用户名：root 密码：bubi
存证：192.168.6.69 					用户名：root 密码：bubi
签章：192.168.6.70 					用户名：root 密码：bubi
前端：192.168.6.60 					用户名：root 密码：bubi
RA：192.168.6.67 					用户名：root 密码：bubi
消息服务：192.168.6.111/6.112	用户名：root 密码：bubi



===========================================================测试环境地址================================================================
数据库：192.168.5.95 		用户名：bubi 密码：bubi
API服务器 ：192.169.4.91    dev  dev@2018




===========================================================预热环境地址===========================
数据库：
123.56.130.205  39221  test abc123

===========================================================生产环境地址===========================
数据库：
112.74.244.106   3306  select 123abc



===========================================================打印机ip地址===========================
192.168.1.8




============================================================idea项目参数配置=====================================
##BunuoApplication
-Dspring.security.enable=false
-Dspring.security.entry-point=true
-Dlogging.level.root=INFO
-Dspring.datasource.url=jdbc:mysql://127.0.0.1:3306/bunuo_new?useUnicode=true&amp;characterEncoding=UTF-8&amp;connectTimeout=60000&amp;socketTimeoutsocket=60000
-Dspring.datasource.password=root
-Dspring.redis.host=127.0.0.1
-Dspring.redis.password=
-Denv=dev1
-Dfile.store.path=D:/var/bunuo/file/
-Dpay.host=http://192.168.6.72:25009
-Dpay.clientId=12111392
-Dsettlement.host=http://192.168.6.73:21009
-Dauthentication.host=http://192.168.6.71:27009
-Deureka.client.enabled=true
-Deureka.client.service-url.defaultZone=http://127.0.0.1:11001/eureka
-Deureka.instance.lease-renewal-interval-in-seconds=5
-Deureka.instance.lease-expiration-duration-in-seconds=15
-Dspring.zipkin.enabled=false
-Dfee.host=yinuojr-expenses
-Ddata.host=yinuojr-metadata
-Dblockchain.account-pool.file-path=D:/workspace/idea_workspace/sponsorAccountPool.poolFile


# 调用链监控
-Dspring.zipkin.enabled=false
====测试支付地址
-Dpay.host=http://192.168.6.35:25009

##DiscoveryApplication
-Dserver.port=11001
-Deureka.client.service-url.defaultZone=http://127.0.0.1:11001/eureka
-Deureka.instance.use-whitelist=false
-Deureka.client.register-with-eureka=false
-Deureka.client.fetch-registry=false

##GatewayApplication
-Deureka.client.service-url.defaultZone=http://127.0.0.1:11001/eureka
-Denv=dev
-Deureka.instance.lease-renewal-interval-in-seconds=5
-Deureka.instance.lease-expiration-duration-in-seconds=15

##AuthApplication
-Deureka.client.service-url.defaultZone=http://127.0.0.1:11001/eureka
-Denv=dev1
-Dspring.datasource.bunuo.url=jdbc:mysql://localhost:3306/bunuo?useUnicode=true&amp;characterEncoding=UTF-8&amp;connectTimeout=60000&amp;socketTimeout=60000
-Dspring.datasource.bunuo.username=root
-Dspring.datasource.bunuo.password=root
-Dspring.datasource.base.url=jdbc:mysql://localhost:3306/yinuojr_auth?useUnicode=true&amp;characterEncoding=UTF-8&amp;connectTimeout=60000&amp;socketTimeout=60000
-Dspring.datasource.base.username=root
-Dspring.datasource.base.password=root
-Deureka.instance.lease-renewal-interval-in-seconds=5
-Deureka.instance.lease-expiration-duration-in-seconds=15
-Doauth2.enable=false
-Dspring.redis.host=127.0.0.1
-Dspring.redis.password=

===============================================================签名列表=============================================================================
私钥--->公钥--->地址


===============================================================项目地址=============================================================================
==wiki
http://192.168.5.21:8090/dashboard.action 
用户名: yangjian  密码：123456

==gitlib：
http://192.168.1.11/groups/bunuo
用户名：yangjian 密码：yangjian1990

==jenkins：
http://192.168.5.20:9000/
不用登陆即可查看自动话部署的项目


==前端资源设置：
登陆以后：
http://localhost:82/#/app/access-access
http://localhost:82/#/app/access-accessBindAPI

==swagger接口
http://localhost/service/swagger-ui.html

==druid sql监控
http://localhost/service/druid/index.html 
admin
admin

==bubi底层sdk
http://192.168.1.11/platform/access-sdk

==企业邮箱
yangjian@bubi.cn
Yangjian1990

==FTP
ftp://192.168.1.11/software

==Google邮箱：
Google邮箱： ProSayJ@gmail.com  yangjian1990   关联账号：15665662468@163.com

==配置中心
http://portal.apollo.bubi.cn/ wusonghui  wusonghui

== 钱包
prosayj   yangjian1990

地址：buQkbHjyGRDWLj3dqptLbtnDVyqEY2aKqps8
私钥：
privbxMQ84nuBDAx5uoFdNZKxaA3CDjrgHmSoW1MLUZLEqEbaL6otGtS


地址：buQgm4dmkB5k3hzD36p22kDkDQ2DEo8PsWDJ
私钥：
privbsmUFHsnseU9SHbvc7vWSJiqNLWNv1sVixYDtiDwk21EFNSkTjAA


https://www.mediawiki.org/wiki/MediaWiki
用户名：prosayj
密码：yangjian1990

查看电池损耗：
	powercfg /batteryreport /output "C:\battery_report.html"

























======================================================关于壹诺业务中的上下游关系========================================================================
现在的company_supplier表中：
本来上下游关系这张表中记录的是企业之间的贸易关系的上下游关系。贸易关系中：供货商我们称之为下游企业，收货方为上游企业。
	也就是说核心企业是最上游的企业。
控制台邀请的企业包括：平台方、运营方、渠道方、资金方、核心企业、供应商，被邀的企业(目标企业)都是作为上游企业存储的，邀请的企业作为下游企业存储。

资金方邀请核心企业、邀请上游企业注册、平台方邀请运营方、运营方邀请渠道方、运营方邀请资金方、运营方邀请核心企业、企业创建分公司，
默认被邀请的企业都作为邀请的企业的上游企业。

华夏银行的解绑卡规则是：子账户绑定跨行的银行卡返回的数据是实时的，子账户绑定同行的银行卡返回的结果是异步的。


================================================================专业术语=====================================================
内部子账户号；
跨行收款账号；
经办复核：
授信类型：
无授信：
保贴授信：
RA的中文名字：证书注册审批系统：RA (Register Authority)
	
证书相关概念：
	ukey：是硬件key
	PIN码：证书的硬件密码
	ukey内可以写入多个软证书，每个软证书都有唯一的标识，叫DN码

			

=============================================================Linux常用的命令=================================================
查看日志：
tail -fn500 all.log

查看进程：
ps -ef|grep java


=============================================================Redis常用的命令=================================================
redis需要清除部分缓存，进入redis的bin目录执行以下命令：
./redis-cli -a （redis密码） keys "all*:*" | xargs ./redis-cli -a （redis密码）del
例如：
./redis-cli -a bubi keys "all*:*" | xargs ./redis-cli -a bubi del





==============================================================            ======================================================================
==============================================================基本的sql语句======================================================================
==============================================================			  ======================================================================
==============================基本的sql语句修改================================
drop database if exists DBName;
create database DBName;
use DBName;
-- change bunuo_new.bank_account.date to bubi_pay.pay_account.bank_inter_num 
UPDATE `bunuo`.`bank_account` a INNER JOIN `bubi_pay`.`pay_account` b ON a.blockchain_address = b.pay_account_address
 SET a.`no` = b.bank_inter_num;

UPDATE `user` set process = 2;

UPDATE `user` a INNER JOIN  (select DISTINCT user_id as id from user_cert) b on a.id = b.id set a.process = 3;

UPDATE `user` e INNER JOIN ( select c.user_id from user_cert c INNER JOIN  (
	SELECT DISTINCT a.cert_id from sec_cert_privilege a INNER JOIN cert b on  a.cert_id = b.id) d on c.cert_id  = d.cert_id ) f 
     on e.id = f.user_id set e.process = 4;

UPDATE `user` a INNER JOIN company_user b on a.id = b.user_id and b.has_admin = 1 set a.process = 4;

UPDATE  cert_online_apply a 
	INNER JOIN company b on a.company_id = b.id set a.channel_id = b.channel_company_id,a.operator_id = b.operator_company_id;


-- 新增字段
alter table invite_info add invite_com_id bigint(32) NOT NULL COMMENT '被邀请的企业id' AFTER invite_id;
alter table invite_info add invite_com_name varchar(255) NOT NULL COMMENT '被邀请的企业名称' AFTER company_name;

-- 修改表字段名称
ALTER TABLE invite CHANGE c_t `create_time` bigint(32);
ALTER TABLE invite CHANGE u_t update_time bigint(32) ;
ALTER TABLE invite CHANGE expiry_t expiry_time bigint(32);
-- 修改表字段注释
ALTER TABLE invite MODIFY column expiry_time bigint(32) comment '过期时间';
ALTER TABLE invite MODIFY column update_time bigint(32) comment '更新时间';
ALTER TABLE invite MODIFY column create_time bigint(32) comment '创建时间';

-- 修改表注释
ALTER TABLE invite comment '邀请码';

-- 删除
 ALTER TABLE table_name DROP field_name;


-- 初始化 invite_info 表的invite_com_id和invite_com_name字段
UPDATE(
	select company.id,company.name,b.inv_info_idfrom(
		select company_user.cus_id as company_id,a.user_id,a.inv_info_id from (
			select  user_invite_info.user_id,user_invite_info.inv_info_id from 
				user_invite_info INNER JOIN invite_info on invite_info.id = user_invite_info.inv_info_id) a INNER JOIN 
				company_user on a.user_id = company_user.user_id) b INNER JOIN company on company.id = b.company_id) c INNER JOIN 
invite_info on invite_info.id = c.inv_info_id set invite_info.invite_com_id=c.id ,invite_info.invite_com_name = c.name;

-- mysql 获取当前时间戳
select unix_timestamp(now());

-- mysql 和 oralce的分页查询：
-- pageNo:查询的页码 pageSize：页大小 totalPage:总条数
-- mysql分页查询:
	select * from user limit (pageNo-1)*pageSize,pageSize;
SELECT * FROM table LIMIT 5,10;	// 检索记录行 6-15
SELECT * FROM table LIMIT 3,6;	//是从第4条开始，取出之后的6条数据 。

-- oracle分页查询： 
	select * from (select t.*,rownum as rownu from stu where rownu <= (pageNo*pageSize + 1) t) where t.rownu > (pageNo-1)*pageSize;



==============================================================实名相关的信息修改========================================
壹诺金融：bunuo_new:
用户实名涉及的表：
select * from company where name like '%吴中区甪直绘粉美甲店%';-- a001caf0be1cf2219b2e9088216a250928808429316e7a
select * from certificate where `code` = '92320506MA1NWFU301';
select * from cert where serial_no = '1006475695';
布诺实名服务：bubi_authentication
select * from company where name like '%吴中区甪直绘粉美甲店%';
select * from certificate where owner_id = 161;
select * from cfca_public_key where owner_id = 161;
select * from principal where owner_id = 161;

delete from certificate where owner_id = (select id from company where name like '%吴中区甪直绘粉美甲店%');
delete from cfca_public_key where owner_id = (select id from company where name like '%吴中区甪直绘粉美甲店%');
delete from principal where owner_id = (select id from company where name like '%吴中区甪直绘粉美甲店%');
delete from company where name like '%吴中区甪直绘粉美甲店%';

支付生成子账号失败：bubi_pay:
-- 生成子账号失败
select * from pay_account where account_address = 'a0013d9a5eaaa34e8772073935e9ad9c6fce8512239471';
select * from pay_account_record where account_address = 'a0013d9a5eaaa34e8772073935e9ad9c6fce8512239471';




||===================================API用户基础数据筛选==============================================||
||																								    ||
||==========================登陆密码：abc123456；支付密码：1qaz2wsx	 	============================||
||==========================资金方:北京同仁堂药材参茸投资集团有限公司		============================||
||==========================	jbank1 									============================||
||==========================	jbemp1									============================||
||==========================核心企业：深圳市华星光电半导体显示技术有限公司	============================||
||==========================	jcore1									============================||
||==========================	jcemp1									============================||
||==========================供应商：吉林省博海睿智信息技术有限公司			============================||
||==========================	jsup1									============================||
||==========================	jsemp1									============================||
||==================================================================================================||
登陆密码：abc123456；支付密码：1qaz2wsx
运营方： 苏州缘来无界工艺品有限公司 ： 91320508346386385N
	yjyyf1
资金方:北京同仁堂药材参茸投资集团有限公司: 911100005858054799
资金方:安徽旺来无纺布有限公司   91340881674230080U 
	jbank1 	1010977251
	jbemp1	1010987360
   

核心企业： 深圳市华星光电半导体显示技术有限公司: 911103021011283297
	jcore1	1019436791
	jcemp1	1019436796
一级供应商： 吉林省博海睿智信息技术有限公司: 91440300697136927G
	jsup1	1034070522
	jsemp1
二级供应商： 吴中区甪直绘粉美甲店: 92320506MA1NWFU301


飞天资金方 91510000711884444F
飞天核心企业 91510000711885555F


select * from user where id in(
		select user_id from company_user where cus_id = (
				select id from company where name like '%桐君堂药业有限公司%'));
-- 1：企业实体
select * from company where id = (
		select cus_id FROM company_user where user_Id = (
				select id from user where name = 'jcore1'));
-- 2：查银行卡
select * from bank_account where owner_id = (
		select id from company where id = (
				select cus_id FROM company_user where user_Id = (
						select id from user where name = 'jcore1')));
-- 3：查看企业的子账户绑定的银行卡
select * from bind_bank_card where sub_account_id in (
	select id from bank_account where owner_id = (
		select id from company where id = (
				select cus_id FROM company_user where user_Id = (
						select id from user where name = 'abc123'))) and type = 0);
-- 4：查询企业证件号信息
select * from certificate where com_id = (
		select id from company where id = (
				select cus_id FROM company_user where user_Id = (
						select id from user where name = 'jcore1')));
-- 5：查证书
select * from cert where id in (
			select cert_id from user_cert where user_id in (
						select user_id from company_user where cus_id = (
									select id from company where id = (
												select cus_id FROM company_user where user_Id = (
															select id from user where name = 'jcore1')))));
-- 6：查询企业下的员工
select * from user where id in(
		select user_id from company_user where cus_id = (
				select id from company where id = (
						select cus_id FROM company_user where user_Id = (
								select id from user where name = 'jcore1'))));
-- 7：查询用户企业关联关系
select * FROM company_user where user_Id in(
		select user_id from company_user where cus_id = (
			select id from company where id = (
				select cus_id FROM company_user where user_Id = (
					select id from user where name = 'jcore1'))));
-- 8：用户证书
select * from user_cert where user_id in(
		select user_id from company_user where cus_id = (
				select id from company where id = (
						select cus_id FROM company_user where user_Id = (
								select id from user where name = 'jcore1'))));
-- 9：用户支付密码
select * from user_pay where user_id in(
		select user_id from company_user where cus_id = (
				select id from company where id = (
						select cus_id FROM company_user where user_Id = (
								select id from user where name = 'jcore1'))));
-- 10：用户密码盐值
select * from salt where user_id in(
		select user_id from company_user where cus_id = (
				select id from company where id = (
						select cus_id FROM company_user where user_Id = (
								select id from user where name = 'jcore1'))));

-- 11：company_supplier 查询企业之间的关联关系：

-- 12：invite
-- 13: invite_info
-- 14：user_invite_info
-- 14: user_role
-- 15:

alter table bank_account add `purpose` tinyint(2) NOT NULL DEFAULT '-1' COMMENT '银行卡用途：0-"充值&提现"； 1-"提现"； 2-"充值"；3-"暂不绑定"' AFTER business_scope;


================================用户权限涉及的6张表==========================================
00-privilege：前端资源保存记录表；
01-resource：后端资源表(后端所有接口资源)；
02-role：角色表；
03-privilege_resource:前端资源和后台资源关系表；
04-role_privilege：角色和前端资源的关系表；
05-role_resource:角色和后端接口资源的关系表；

添加银行卡测试数据：
 1：华夏银行cnaps:304100000768
 2：非华夏银行cnaps：105100001077


吴中区甪直绘粉美甲店 92320506MA1NWFU301
苏州缘来无界工艺品有限公司	91320508346386385N

阿里云服务器远程登陆密码： 168316
IP地址：
root Yangjian1990


subline激活码：
ZYNGA INC.
50 User License
EA7E-811825
927BA117 84C9300F 4A0CCBC4 34A56B44
985E4562 59F2B63B CCCFF92F 0E646B83
0FD6487D 1507AE29 9CC4F9F5 0A6F32E3
0343D868 C18E2CD5 27641A71 25475648
309705B3 E468DDC4 1B766A18 7952D28C
E627DDBA 960A2153 69A2D98A C87C0607
45DC6049 8C04EC29 D18DFA40 442C680B

1342224D 44D90641 33A3B9F2 46AADB8F




1：充值的银行卡列表筛选
2：子账户页面充值按钮显示/弹框
3：重新绑定银行卡状态回显
4：添加银行卡账户类型是否可选


===feesupport接口
===需要开发或者改造的接口
万安：
1、创建运营方、渠道、资金方、企业时，去掉通知方式
2、增加通知方式接口
3、根据（运营方、供应商）查询其所有核心企业
4、根据（运营方、供应商）查询其所有资金方
5、根据（运营方）查询其所有供应商
6、根据（运营方、渠道）查询其所有供应商
7、根据（运营方、资金方）查询其所有供应商
8、根据（运营方、核心企业）查询其所有供应商

建勇：
1、运营方为渠道、核心、资金方添加会员费配置、融资服务费配置，需由客户模块封装参数，调用费用模块接口进行添加。
2、运营方为供应商添加会员费配置、融资服务费缴纳配置，需要客户模块封装参数，调用费用模块接口进行添加。
3、平台方邀请运营方进驻平台，添加默认分成配置时，需要客户模块进行参数封装，调用费用模块，进行创建。
目的是客户关系需要记录企业实名的步骤：包括但不仅限于：创建企业->费用配置->发送邀请码

费用需要提供给我们的接口：
1、通过企业id查询是否有费用配置；
2、	

田驰：
6月29号共识的三个接口
== 
bumo币：
https://bumo.io/
https://keypair.bumo.io/

账户地址:
buQnKZXtPM7Yctih6ANjLqTNHw7dc9bF5zD5

私钥:
privbUhp7mLBiaGzaCV7dpCvcfn75sq3hMSDXDoPMdtCQvXn8TVfuiEi


1：支持费用模块的企业模块接口开发，自测中
2：消息通知模块对接MQ：开发中
3：暂定企业间邀请费用配置待办事宜表由账户中心管理，费用模块配置完成费用修改待办事宜状态：表设计中
4：绑卡条件校验逻辑修改：完成
5：解绑证书：接口开发自测完成
6：运营方下企业列表相关接口需要改造(基于v2.8.2新UI图)的接口:未开始


对接yinuojr-notice步骤：
1、注入NoticeClient
2、调用发送短信样例：
	发送邀请码：
           List<String> phones = new ArrayList<>(1);
            phones.add(phone);
            InviteSmsItem smsItem = new InviteSmsItem();
            smsItem.setCode(inviteCode);
            smsItem.setCompany(sendCompanyName);
            noticeClient.sendSms(loginPlatformType, SmsTypeEnum.REGISTER, phones, JSONObject.toJSONString(smsItem));
3、调用发送邮件样例：
            发送邀请码：
           InviteMailItem mailItem = new InviteMailItem();
            mailItem.setInviteCode(inviteCode);
            mailItem.setSendCompanyName(sendCompanyName);
            noticeClient.sendEmail(loginPlatformType, MailTypeEnum.HEAD_REGISTER, new String[]{email}, JSONObject.toJSONString(mailItem), null);

http://bestcbooks.com/B001PTGR52/

//TODO:企业邀请步骤优化


消费：
@ConsumerByPush(
instanceName = "instanceName2",topic = "scf_msimple_expenses",tags = "company_aurh_pass_tags",group = "expense_comsumer_group")

发送：
 // 消息通知MQ开始记会员费
 Map<String, Object> sendParams = new HashMap<>(2);
sendParams.put(BaseConstants.COMPANY_iD, comId);
sendParams.put(BaseConstants.START_DATE, new Date());
String content = JSON.toJSONString(sendParams);

Message messageInfo = new Message();
messageInfo.setMessageKey(String.valueOf(UUID.randomUUID()));
messageInfo.setContent(content);
messageInfo.setMessageFormat(MessageFormat.JSON);
messageInfo.setMessageType(MessageType.MESSAGE);
messageInfo.setSign(usercontractservice);
messageInfo.setTopic(scf_msimple_expenses);
messageInfo.setTags(company_aurh_pass_tags);

Boolean result = producer.syncSend(messageInfo);




华夏银行：
	绑定出金类型的卡无论是跨行还是同行必须要到柜台面面签

fee单机版：
@FeignClient(name = "fee", url = "${fee.host}/expenses", configuration = FeignConfig.class)
集群版：
@FeignClient(name = "${fee.host}", configuration = FeignConfig.class)

DROP PROCEDURE if exists del_user_data; 
DELIMITER $$  -- 声明存储过程的结束符
CREATE procedure  del_user_data(in user_name VARCHAR(128),OUT result VARCHAR(128)) 
BEGIN -- 开始存储过程  
		DECLARE doneFlag INT DEFAULT FALSE; 
		DECLARE companyIdTemp 					BIGINT(32) 	DEFAULT '-1'; -- 企业id临时变量;

		DECLARE companyId								BIGINT(32) 	DEFAULT '-1'; -- 企业表
		DECLARE bankaccountId						BIGINT(32)  DEFAULT '-1'; -- 银行账户表
		DECLARE userId									BIGINT(32)  DEFAULT '-1'; -- 用户表
		DECLARE bindBankCardId					BIGINT(32)  DEFAULT '-1'; -- 绑定银行账户表
		DECLARE certificateId						BIGINT(32)  DEFAULT '-1'; -- 企业证件表
		DECLARE certId									BIGINT(32)  DEFAULT '-1'; -- 企业证书表

		DECLARE userPayId								BIGINT(32)  DEFAULT '-1'; -- 用户支付密码表
		DECLARE saltId									BIGINT(32)  DEFAULT '-1'; -- 盐表
		DECLARE userContractId					BIGINT(32)  DEFAULT '-1'; -- 平台协议表
		DECLARE userCertId							BIGINT(32)  DEFAULT '-1'; -- 用户证书关系表
		DECLARE companyUserId						BIGINT(32)  DEFAULT '-1'; -- 用户企业关系表
		




DECLARE delCompanyUserCursor CURSOR FOR(
	select id FROM company_user where user_Id in(
		select user_id from company_user where cus_id = (
				select cus_id FROM company_user where user_Id = (
					select id from user where name = user_name)))
);

DECLARE delUserCertCursor CURSOR FOR(
	select id from user_cert where user_id in(
		select user_id from company_user where cus_id = (
				select id from company where id = (
						select cus_id FROM company_user where user_Id = (
								select id from user where name = user_name))))
);
DECLARE delCompanyCursor CURSOR FOR(
	select id from company where id = (
		select cus_id FROM company_user where user_Id = (
				select id from user where name = user_name))
		
);
DECLARE delUserCursor CURSOR FOR(
	select id from user where id in(
		select user_id from company_user where cus_id = (
					select cus_id FROM company_user where user_Id = (
							select id from user where name = user_name)))	
);
DECLARE delBankAccountCursor CURSOR FOR(
		select id from bank_account where owner_id = (
			select id from company where id = (
				select cus_id FROM company_user where user_Id = (
						select id from user where name = user_name)))
		
);
DECLARE delBindBankCardCursor CURSOR FOR(
		select id from bind_bank_card where sub_account_id in (
			select id from bank_account where owner_id = (
				select id from company where id = (
					select cus_id FROM company_user where user_Id = (
						select id from user where name = user_name))) and type = 0)	
);
DECLARE delCertificateCursor CURSOR FOR(
		select id from certificate where com_id = (
			select id from company where id = (
				select cus_id FROM company_user where user_Id = (
						select id from user where name = user_name)))
);
DECLARE delCertCursor CURSOR FOR(
	select id from cert where id in (
			select cert_id from user_cert where user_id in (
						select user_id from company_user where cus_id = (
									select id from company where id = (
												select cus_id FROM company_user where user_Id = (
															select id from user where name = user_name)))))
);
DECLARE delUserPayCursor CURSOR FOR(
	select id from user_pay where user_id in(
			select user_id from company_user where cus_id = (
					select id from company where id = (
							select cus_id FROM company_user where user_Id = (
									select id from user where name = user_name))))
);
DECLARE delSaltCursor CURSOR FOR(
	select id from salt where user_id in(
		select user_id from company_user where cus_id = (
				select id from company where id = (
						select cus_id FROM company_user where user_Id = (
								select id from user where name = user_name))))
);
DECLARE delUserContractCursor CURSOR FOR(
	select id from user_contract where com_id =(
		select cus_id FROM company_user where user_Id = (
				select id from user where name = user_name))
);


DECLARE CONTINUE HANDLER FOR NOT FOUND SET doneFlag = TRUE; -- 绑定控制变量到游标,游标循环结束自动转true


-- 1:delBindBankCardCursor
OPEN delBindBankCardCursor;
		delBindBankCardLoop: LOOP 
			FETCH NEXT FROM delBindBankCardCursor INTO bindBankCardId;
			if doneFlag THEN
				LEAVE delBindBankCardLoop;
			end IF;
				DELETE FROM bind_bank_card where id = bindBankCardId;
				COMMIT; 
		END LOOP delBindBankCardLoop;
CLOSE delBindBankCardCursor;
SET doneFlag = FALSE;

-- 2:bankaccount
OPEN delBankAccountCursor;
		delBankAccountLoop: LOOP 
			FETCH NEXT FROM delBankAccountCursor INTO bankaccountId;
			if doneFlag THEN
				LEAVE delBankAccountLoop;
			end IF;
				DELETE FROM bank_account where id = bankaccountId;
				COMMIT;
		END LOOP delBankAccountLoop;
CLOSE delBankAccountCursor;
SET doneFlag = FALSE;

-- 3:certificate
OPEN delCertificateCursor;
		delCertificateLoop: LOOP 
			FETCH NEXT FROM delCertificateCursor INTO certificateId;
			if doneFlag THEN
				LEAVE delCertificateLoop;
			end IF;
				DELETE FROM certificate where id = certificateId;
				COMMIT; 
		END LOOP delCertificateLoop;
CLOSE delCertificateCursor;
SET doneFlag = FALSE;


-- 4:cert
OPEN delCertCursor;
		delCertCursorLoop: LOOP 
			FETCH NEXT FROM delCertCursor INTO certId;
			if doneFlag THEN
				LEAVE delCertCursorLoop;
			end IF;
				DELETE FROM cert where id = certId;
				COMMIT;
		END LOOP delCertCursorLoop;
CLOSE delCertCursor;
SET doneFlag = FALSE;

-- 5:UserCert
OPEN delUserCertCursor;
		delUserCertLoop: LOOP 
			FETCH NEXT FROM delUserCertCursor INTO userCertId;
			if doneFlag THEN
				LEAVE delUserCertLoop;
			end IF;
				DELETE FROM user_cert where id = userCertId;
				COMMIT; 
		END LOOP delUserCertLoop;
CLOSE delUserCertCursor;
SET doneFlag = FALSE;

-- 6:userPay
OPEN delUserPayCursor;
		delUserPayCursorLoop: LOOP 
			FETCH NEXT FROM delUserPayCursor INTO userPayId;
			if doneFlag THEN
				LEAVE delUserPayCursorLoop;
			end IF;
				DELETE FROM user_pay where id = userPayId;
				COMMIT; 
		END LOOP delUserPayCursorLoop;
CLOSE delUserPayCursor;
SET doneFlag = FALSE;

-- 7:salt
OPEN delSaltCursor;
		delSaltCursorLoop: LOOP 
			FETCH NEXT FROM delSaltCursor INTO saltId;
			if doneFlag THEN
				LEAVE delSaltCursorLoop;
			end IF;
				DELETE FROM salt where id = saltId;
				COMMIT; 
		END LOOP delSaltCursorLoop;
CLOSE delSaltCursor;
SET doneFlag = FALSE;

-- 8:userContract
OPEN delUserContractCursor;
		delUserContractLoop: LOOP 
			FETCH NEXT FROM delUserContractCursor INTO userContractId;
			if doneFlag THEN
				LEAVE delUserContractLoop;
			end IF;
				DELETE FROM user_contract where id = userContractId;
				COMMIT; 
		END LOOP delUserContractLoop;
CLOSE delUserContractCursor;
SET doneFlag = FALSE;

-- 9:company
OPEN delCompanyCursor;
		delCompanyLoop: LOOP 
			FETCH NEXT FROM delCompanyCursor INTO companyId;
			if doneFlag THEN
				LEAVE delCompanyLoop;
			end IF;
				set companyIdTemp = companyId;
				DELETE FROM company where id = companyId;
		END LOOP delCompanyLoop;
CLOSE delCompanyCursor;
SET doneFlag = FALSE;

-- 10 companyUser
OPEN delCompanyUserCursor;
		delCompanyUserLoop: LOOP 
			FETCH NEXT FROM delCompanyUserCursor INTO companyUserId;
			if doneFlag THEN
				LEAVE delCompanyUserLoop;
			end IF;
				DELETE FROM company_user where id = companyUserId;
				COMMIT;
		END LOOP delCompanyUserLoop;
CLOSE delCompanyUserCursor;
SET doneFlag = FALSE;

-- 11:user
OPEN delUserCursor;
		delUserLoop: LOOP 
			FETCH NEXT FROM delUserCursor INTO userId;
			if doneFlag THEN
				LEAVE delUserLoop;
			end IF;
				DELETE FROM user where id = userId;
				COMMIT;
		END LOOP delUserLoop;
CLOSE delUserCursor;


set result =  companyIdTemp;
END $$ -- 结束结束符
DELIMITER;
-- 调用
set @name = 'yjsupp1';
CALL del_user_data(@name,@result);
select @result;
DROP PROCEDURE if exists del_user_data; 









CREATE TABLE `bank_account_returned_default` (

`id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',

`company_id` bigint NOT NULL COMMENT '企业id',

`type` tinyint(2) NOT NULL COMMENT '账户类型：0-虚账户；1-实体账户，默认回款账户可以是子账户或者实体账户',

`regulatory_id` varchar(255) NOT NULL COMMENT '监管账户商户号id',

`bankaccount_id` bigint NOT NULL COMMENT '银行账户id',

`create_time` bigint NOT NULL COMMENT '创建时间',

`update_time` bigint NOT NULL COMMENT '更新时间',

`is_deleted` tinyint(2) NOT NULL COMMENT '是否删除：0 未删除；1已删除',

PRIMARY KEY (`id`) 

)

COMMENT='默认回款账户表'
;

alter table bank_account add regulatory_id varchar(255) NOT NULL COMMENT '监管户的商户号' AFTER ext;



/service/bank/account/card/getbindbankcard4subaccount  == >/service/bank/account/card/query/bindbankcard4subaccount


https://blog.csdn.net/clj198606061111/article/details/52200928
https://blog.csdn.net/IOpfan/article/details/71107686
https://www.cnblogs.com/tyhj-zxp/p/7605879.html


 <distributionManagement>
        <repository>
            <id>nexus</id>
            <name>releases</name>
            <url>http://192.168.6.81:8081/repository/maven-releases</url>
            <uniqueVersion>true</uniqueVersion>
        </repository>
        <snapshotRepository>
            <id>nexus</id>
            <name>snapshots</name>
            <url>http://192.168.6.81:8081/repository/maven-snapshots</url>
        </snapshotRepository>
    </distributionManagement>

    安装成功后有两个默认账号admin、anonymous，其中admin具有全部权限默认密码admin123；anonymous作为匿名用户，只具有查看权限。 
