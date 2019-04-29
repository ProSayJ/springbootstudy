#!/bin/bash

source /etc/profile

ip=`/sbin/ifconfig eth0 |grep inet|head -n 1|awk '{print $2}'`

date=`date +%Y%m%d%H%M`
dir=/package/pre_data_backup
sock=/tmp/mysql39221.sock 
passwd="xxxxx"
password="xxxx"
user=root

if [ ! -d $dir ]
then
  mkdir $dir
fi

cd $dir
if [ ! -d $date ]
then
 mkdir $date
fi

mysql -u$user -p$passwd -S $sock 2>&1 -e "show databases;"|sed "1d"|egrep -v "Database|information_schema|performance_schema"> $dir/dbs.txt

d1=$(date +"%Y-%m-%d %H:%M:%S")
d1_t=$(date +%s -d "${d1}")
cd $date
while read line
do
  if [[ "$line" = "$line" ]]
  then
   mysqldump -u$user -p$passwd -S $sock --single-transaction --default-character-set=UTF8 --master-data=2 --set-gtid-purged=OFF --add-drop-database --triggers --routines --events -B $line > ${line}.$date.sql 2>&1  
fi done < $dir/dbs.txt

d2=$(date +"%Y-%m-%d %H:%M:%S")
d2_t=$(date +%s -d "${d2}")

timec=$(( $((${d2_t} - ${d1_t})) /60 ))

if [[ ${timec} -gt 30 ]];then
   echo -e "ERROR:请注意检查备份情况\n\nIP:${ip}\n开始时间:${d1}\n结束时间:${d2}\n备份所用总时间(分):${timec} " | mail -s "预热环境数据库备份异常,请检查" zhangbaoping@bubi.cn wuwenyu@bubi.cn
else
   echo -e "预热环境数据库备份时间:\n\nIP:${ip}\n开始时间:${d1}\n结束时间:${d2}\n备份所用总时间(分):${timec}!" | mail -s "预热环境数据库备份完成,请检查" zhangbaoping@bubi.cn wuwenyu@bubi.cn
fi

cd $dir
tar zcf yinuojr_uat_db_$date.tar.gz $date
rm -rf $date
sshpass -p$password scp -P52113 yinuojr_uat_db_$date.tar.gz root@39.107.59.99:/bubidata/server/pre_data_backup/

printf "%d\n" $?

