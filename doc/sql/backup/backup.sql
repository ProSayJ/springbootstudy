cd /tmp

mysqldump  -uroot -p -B bunuo yinuojr_user yinuojr_certification yinuojr_pay yinuojr_tbank yinuojr_oss yinuojr_auth yinuojr_ops yinuojr_metadata > /tmp/user_tbank.sql


mysql -uroot -pdb79 --socket=/data/mysql/mysql.sock -e "show databases;"|sed "1d"|egrep -v "Database|information_schema|performance_schema"

