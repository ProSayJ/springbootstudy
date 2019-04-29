-- api：
-- 企业主体：
select * from bunuo.company where name = '苏州缘来无界工艺品有限公司'; --  企业区块链地址： a001d9c6a1307085708c38fd67bc8cbb88c89e64319151
-- 企业所有账号(包括子账号+银行账户)
select * from bunuo.bank_account where owner_id = 979; -- 企业子账户id： 504 ；地址： a0015f863c3d4e6623a94057814198fd18aa7ae2a8c170
-- 子账户绑卡记录：
-- `bind_status` tinyint(2) 绑定状态：0-解绑；1-绑定',
-- `status` tinyint(2) NOT NULL COMMENT '状态：0-处理中；1-成功；2-失败',
select * from bunuo.bind_bank_card where sub_account_id = 504;




-- yinuojr_pay:
-- 企业子账户：这里：bank_inter_num 和银行的内部会员号一一对应
select * from yinuojr_pay.pay_account where account_address = 'a001d9c6a1307085708c38fd67bc8cbb88c89e64319151'; -- 银行内部会员号：0064844851
-- 子账户绑卡：
select * from yinuojr_pay.bank_card_bind where pay_account_address = 'a0015f863c3d4e6623a94057814198fd18aa7ae2a8c170';
-- 绑卡记录：
-- `status` '是否绑定成功 0 处理中 1成功 2失败',
-- `bind_type`  '0绑定  1解绑',
select * from yinuojr_pay.bank_card_bind_record where pay_account_address = 'a0015f863c3d4e6623a94057814198fd18aa7ae2a8c170';
select * from yinuojr_pay.bank_card_bind_record where request_no = '320263155408175104' and merchant_id = '12111392';
-- 银行卡信息；
select * from yinuojr_pay.bank_card_info where bank_card_address = 'a001a7bab851697e0d1b71f4130387d57d6dbf49f7e985';
select * from yinuojr_pay.bank_card_info where cnaps_code = '304100011879';
select * from yinuojr_pay.bank_card_info where bank_account_name = '苏州缘来无界工艺品有限公司'





-- yinuojr_tbank：
-- 银行账户：
select * from yinuojr_tbank.tbank_account where mem_ber_code = '0064844851'; -- pay_account的 bank_inter_num
-- 银行卡：
select * from yinuojr_tbank.tbank_bank_card where sub_account = '200201808000011';









核心企业 ： liuwenjiec1
供应商     ：liuwenjied1
select * from yinuojr_user.user where name = 'liuwenjiec1';
select * from company_user where user_id = 422;
select * from company where id = 711;
select * from company where name = '爱文易成文具有限公司'
select * from bank_account where owner_id = 711;
select * from bind_bank_card where sub_account_id = 342;


select * from yinuojr_user.user where name = 'liuwenjied1';
select * from company_user where user_id = 528;
select * from company where id = 964;
select * from company where name = '上海万事达墨水有限公司'
select * from bank_account where owner_id = 964;
select * from bind_bank_card where sub_account_id = 552;


select count(blockchain_address),blockchain_address from cert GROUP BY blockchain_address;
select * from cert where blockchain_address = 'a001977838363bd52838fa5b8b061c784b7dc6005d7d7f';
select * from company where blockchain_address = 'a001977838363bd52838fa5b8b061c784b7dc6005d7d7f';


select * from bind_bank_card where sub_account_id = 752;



select * from bank_account where no like '%0999%';
select * from bind_bank_card where sub_account_id = 590;

select * from company_user w









