select
a.name as '机构名称',
(select code from yinuojr_bunuo.certificate where com_id = a.com_id and type = 0 ) as '统一社会信用代码',
case a.type
when '0' then '有限责任'
when '1' then '一人有限责任'
when '2' then '其它有限责任'
when '3' then '股份有限公司'
when '5' then '集体所有制'
when '6' then '股份制'
when '7' then '股份合作制'
when '9' then '台、港、澳投资企业'
when '12' then '外商投资企业'
when '13' then '内资非法人企业'
when '14' then '非公司私营企业'
when '16' then '内资非公司企业分支机构'
end as '机构类型',
(select code from yinuojr_bunuo.certificate where com_id = a.com_id and type = 1 ) as '税务登记号',
(select name from yinuojr_metadata.basics_dictionary where id =
(select parent_id from yinuojr_metadata.basics_dictionary where code = a.city and type = 'city' ) and type = 'province') as '所在省',
(select name from yinuojr_metadata.basics_dictionary where code = a.city and type = 'city' ) as '所在城市',
a.corp_name as '法人代表',
'法人代表' as '法人代表证件类型',
a.corp_card_id as '法人代表证件号码',
a.corp_card_date as '证件到期日',
a.linkman_name as '联系人姓名',
a.linkman_phone as '联系人手机号'
from
(select name,com_id,corp_name,corp_card_type,corp_card_id,linkman_name,linkman_phone,type,city,corp_card_date from yinuojr_bunuo.company_detail
where com_id in (select id from yinuojr_bunuo.company where operator_id = 22 and status = 1 and is_deleted = 0 ) order by corp_card_date desc ) a





-- 客户统计
select DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m') as "日期",IFNULL(count(id),0)  as "金融机构" from company where com_type like '%4,%' and `status` = 1 and is_deleted = 0 group by DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m');
select DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m') as "日期",count(id)  as "核心企业" from company where com_type like '%2,%' and `status` = 1 and is_deleted = 0 group by DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m');
select DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m') as "日期",count(id)  as "供应商" from company where  com_type like '%5,%' and `status` = 1 and is_deleted = 0 group by DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m');




-- 某月申请融资比数
select
	DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m'), count(id)
from
	financing_apply
where is_deleted = 0
and finance_status > -1
group by DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m');


-- 某月融资申请金额（元）
select
	DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m'),sum(finance_apply_amount)/100
from
	financing_apply
where is_deleted = 0
and finance_status > -1
group by DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m');


-- 某月审批通过数
select
	DATE_FORMAT(FROM_UNIXTIME(loan_time/1000), '%Y-%m'),count(id)
from
	financing_apply
where is_deleted = 0
and loan_status =1
group by DATE_FORMAT(FROM_UNIXTIME(loan_time/1000), '%Y-%m');

-- 某月审批通过金额（元）
select
	DATE_FORMAT(FROM_UNIXTIME(loan_time/1000), '%Y-%m'),sum(loan_amount)/100
from
	financing_apply
where is_deleted = 0
and loan_status =1
group by DATE_FORMAT(FROM_UNIXTIME(loan_time/1000), '%Y-%m');

-- 某月申请融资企业数
select
	DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m'),sum(distinct apply_id)
from
	financing_apply
where is_deleted = 0
and finance_status > -1
group by DATE_FORMAT(FROM_UNIXTIME(create_time/1000), '%Y-%m');


--  某月融资余额最大值（元）
select
	DATE_FORMAT(collecting_time, '%Y-%m'),max(balance)/100
from
	dc_repayment_balance dc
group by DATE_FORMAT(collecting_time, '%Y-%m');
