-- 1:api
-- 1.1：实名相关：
select * from bunuo.company where name like '%吉林省博海睿智信息技术有限公司%' ORDER BY update_time desc ; -- blockchain_account: a001018cc649b0792c76a1c10ffd33f3e42dfb993f1675
select * from bunuo.certificate where code like '%91440300697136927G%' ORDER BY c_t desc;
select * from bunuo.cert where serial_no like '%1034075377%' ORDER BY update_time desc;
select * from yinuojr_user.`user`where name like '%jsup2%' ORDER BY create_time desc;

-- 1.2：子账户和银行卡相关
select * from bunuo.company where name = '吉林省博海睿智信息技术有限公司'; -- 1545
select * from bunuo.bank_account where owner_id = 1545; -- sub_account_id = 1545
select * from bunuo.bind_bank_card where sub_account_id = 874;
select * from bunuo.bind_bank_card_history where sub_account_id = 874;

-- 2：pay
select * from yinuojr_pay.pay_account where account_address = 'a0012b93e16d544596dd5c61a5644c52bad1259b3fb3ac';
-- pay_account_address : a001fc4fee111e5776122158d4a6cc3f9bf5e462f8c930
-- bank_inter_num = 0083235030
select * from yinuojr_pay.bank_card_bind where pay_account_address = 'a001fc4fee111e5776122158d4a6cc3f9bf5e462f8c930';


-- 3:bank
select * from yinuojr_tbank.tbank_account where mem_ber_code = '0083235030';-- sub_acc = 200201904000007
select * from yinuojr_tbank.tbank_bank_card where sub_account = '200201904000007';
