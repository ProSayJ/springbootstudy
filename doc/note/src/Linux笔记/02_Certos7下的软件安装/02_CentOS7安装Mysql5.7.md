# 02_CentOS7安装Mysql5.7

## 1：安装之前先卸载机器中已有的mysql：
### 1.1：卸载yum 方式安装的mysql：

``` sql
yum list installed mysql
[root@localhost src]# yum list installed mysql
Loaded plugins: fastestmirror
Loading mirror speeds from cached hostfile
* base: mirrors.huaweicloud.com
* extras: mirrors.163.com
* updates: mirrors.163.com
Error: No matching Packages to list
[root@localhost src]#
```

yum remove 上面列表里面的mysql名称 ** 我的机器上没有，所以就不卸载了。**

``` sql
rm -rf /var/lib/mysql
rm /etc/my.cnf
```

### 1.2：卸载rpm方式安装的mysql：
    rpm -qa | grep -i mysql
如果有lits则执行： ```rpm -e``` 列表中的文件名称 来删除

清除多余项：

``` whereis mysql ```

``` rm -rf whereis的目录路径 ```

``` sql
[root@localhost src]# rpm -qa | grep -i mysql
[root@localhost src]# whereis mysql
mysql: /usr/lib64/mysql /usr/share/mysql
[root@localhost src]# rm -rf /usr/lib64/mysql/
[root@localhost src]# rm -rf /usr/share/mysql/
[root@localhost src]# whereis mysql
mysql:[root@localhost src]#
```
 

## 2：下载软件包：
``` sql
wget https://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz

[root@localhost src]# wget https://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz
--2018-09-30 02:46:19--  https://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz
Resolving dev.mysql.com (dev.mysql.com)... 137.254.60.11
Connecting to dev.mysql.com (dev.mysql.com)|137.254.60.11|:443... connected.
HTTP request sent, awaiting response... 302 Found
Location: https://cdn.mysql.com//Downloads/MySQL-5.7/mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz [following]
--2018-09-30 02:46:29--  https://cdn.mysql.com//Downloads/MySQL-5.7/mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz
Resolving cdn.mysql.com (cdn.mysql.com)... 23.59.8.165
Connecting to cdn.mysql.com (cdn.mysql.com)|23.59.8.165|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 644399365 (615M) [application/x-tar-gz]
Saving to: ‘mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz’

100%[=============================================================================================================================================================================================>] 644,399,365  966KB/s   in 9m 38s 

2018-09-30 02:56:08 (1.06 MB/s) - ‘mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz’ saved [644399365/644399365]

```

## 3：解压缩
解压缩tar.gz包到指定的目录下，并重命名为：mysql-5.7.23。我这里就解压到** "/com/prosayj/server" **下：

``` sql 
tar -zxvf mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz -C /com/prosayj/src/ && mv mysql-5.7.23-linux-glibc2.12-x86_64 mysql-5.7.23 && mv mysql-5.7.23 /com/prosayj/server/
```

``` sql 
[root@localhost src]# pwd
/com/prosayj/src
[root@localhost src]# tar -zxvf mysql-5.7.23-linux-glibc2.12-x86_64.tar.gz -C /com/prosayj/src/ && mv mysql-5.7.23-linux-glibc2.12-x86_64 mysql-5.7.23 && mv mysql-5.7.23 /com/prosayj/server/
[root@localhost server]# cd /com/prosayj/server/
[root@localhost server]# ll
total 0
drwxr-xr-x. 4 root root  30 Sep 29 06:05 autoconf-2.69
drwxr-xr-x. 4 root root  30 Sep 29 06:08 automake-1.11
drwxr-xr-x. 6 root root  56 Sep 29 06:33 libtool-2.2.6b
drwxr-xr-x. 5 root root  41 Sep 29 07:00 lrzsz-0.12.20
drwxr-xr-x. 4 root root  30 Sep 28 22:34 m4-1.4.18
drwxr-xr-x. 9 root root 129 Sep 29 11:22 mysql-5.7.23
drwxr-xr-x. 5 root root  39 Sep 29 01:18 perl-5.26.1
[root@localhost server]#
```   

## 4：新增用户组分配权限：

### 4.1：注意：以下的这步创建用户分配权限的步骤必须一定要做，不然下面启动的时候会报错,后面启动权限这块有有问题，待研究原因。

### 4.2：可以执行下面的命令，为系统添加mysql用户组和mysql用户(-s /bin/false参数指定mysql用户仅拥有所有权，而没有登录权限):

``` sql
groupadd mysql

useradd -r -g mysql -s /bin/false mysql
```
### 4.3：进入安装mysql软件的目录,修改当前目录拥有者为新建的mysql用户：

``` sql
    cd /com/prosayj/server/mysql-5.7.23/ && chown -R mysql:mysql ./
```
## 5：安装mysql：

``` sql
cd /com/prosayj/server/mysql-5.7.23 && ./bin/mysqld --user=root --basedir=/com/prosayj/server/mysql-5.7.23/ --datadir=/com/prosayj/server/mysql-5.7.23/data --initialize


[root@localhost mysql-5.7.23]# cd /com/prosayj/server/mysql-5.7.23 && ./bin/mysqld --user=root --basedir=/com/prosayj/server/mysql-5.7.23/ --datadir=/com/prosayj/server/mysql-5.7.23/data --initialize
2018-09-30T09:42:54.972227Z 0 [Warning] Ignoring user change to 'root' because the user was set to 'mysql' earlier on the command line

2018-09-30T09:42:54.972291Z 0 [Warning] TIMESTAMP with implicit DEFAULT value is deprecated. Please use --explicit_defaults_for_timestamp server option (see documentation for more details).
2018-09-30T09:42:55.329730Z 0 [Warning] InnoDB: New log files created, LSN=45790
2018-09-30T09:42:55.387290Z 0 [Warning] InnoDB: Creating foreign key constraint system tables.
2018-09-30T09:42:55.452279Z 0 [Warning] No existing UUID has been found, so we assume that this is the first time that this server has been started. Generating a new UUID: 3514bc2e-c495-11e8-8d23-000c29902d58.
2018-09-30T09:42:55.453158Z 0 [Warning] Gtid table is not ready to be used. Table 'mysql.gtid_executed' cannot be opened.
2018-09-30T09:42:55.459187Z 1 [Note] A temporary password is generated for root@localhost: czZs/w&Rj4#i
```

** 记住随机密码："czZs/w&Rj4#i" **

## 6：开启mysql服务：
``` sql
cd /com/prosayj/server/mysql-5.7.23/ && ./support-files/mysql.server start
```
### 6.1：注意：如果开启mysql服务失败，报什么路径找不到之类的如下的错误，那是因为mysql启动时，会读mysql的配置文件/etc/my.cnf，如果没有这个文件，就新增一个。因为里面的初始路径不对：
``` sql
[root@localhost mysql-5.7.23]# cd /com/prosayj/server/mysql-5.7.23/ && ./support-files/mysql.server start
./support-files/mysql.server: line 239: my_print_defaults: command not found
./support-files/mysql.server: line 259: cd: /usr/local/mysql: No such file or directory
Starting MySQL ERROR! Couldn't find MySQL server (/usr/local/mysql/bin/mysqld_safe)
```
### 6.2：需要修改两处配置文件：
(1)修改"/etc/my.cnf"文件的内容如下，如果文件不存在就新增，拷贝下面的内容到文件my.cnf中。
datadir和socket都修改成mysql的安装目录下，增加[client]板块，用于命令行连接mysql数据库。

``` sql
[mysqld]
port=3306
datadir=/com/prosayj/server/mysql-5.7.23/data
socket=/com/prosayj/server/mysql-5.7.23/mysql.sock
user=mysql

max_connections=151

federated

# Disabling symbolic-links is recommended to prevent assorted security risks
symbolic-links=0

# 设置忽略大小写
lower_case_table_names = 1

# 指定编码
character-set-server=utf8

collation-server=utf8_general_ci

# 开启ip绑定注意设置成127.0.0.1则远程不可以连接
bind-address = 0.0.0.0

[mysqld_safe]
log-error=/var/log/mysqld.log
pid-file=/var/run/mysqld/mysqld.pid
# 解决mysqld启动报错问题
# skip-federated
# 支持数据库远程连接
# skip-grant-tables

#指定客户端连接mysql时的socket通信文件路径
[client]
socket=/com/prosayj/server/mysql-5.7.23/mysql.sock

default-character-set=utf8
``` 


(2:)修改 /com/prosayj/server/mysql-5.7.23/support-files/mysql.server的配置文件，指定到安装目录：
``` sql
vi /com/prosayj/server/mysql-5.7.23/support-files/mysql.server
```
截取了重要的需要修改的部分:
``` sql
# Set some defaults
mysqld_pid_file_path=
if test -z "$basedir"
then
basedir=/com/prosayj/server/mysql-5.7.23
bindir=/com/prosayj/server/mysql-5.7.23/bin
if test -z "$datadir"
then
    datadir=/usr/lib/mysql-5.7.23/data
fi
sbindir=/usr/lib/mysql-5.7.23/bin
libexecdir=/usr/lib/mysql-5.7.23/bin
else
bindir="$basedir/bin"
if test -z "$datadir"
then
    datadir="$basedir/data"
fi
sbindir="$basedir/sbin"
libexecdir="$basedir/libexec"
fi
```


### 6.3：尝试启动/停止/重启:
``` sql
cd /com/prosayj/server/mysql-5.7.23/ && ./support-files/mysql.server start

cd /com/prosayj/server/mysql-5.7.23/ && ./support-files/mysql.server stop
```
### 6.4：如果依然启动不了提示内容大概如下：则需要做下面的两步问题排查
``` sql
[root@localhost mysql-5.7.23]# cd /com/prosayj/server/mysql-5.7.23/ && ./support-files/mysql.server start
Starting MySQL. ERROR! The server quit without updating PID file (/com/prosayj/server/mysql-5.7.23/data/localhost.localdomain.pid).
[root@localhost mysql-5.7.23]#
 ```

(1)首先要确认下有没有把mysql的安装路径分配给mysql用户

``` sql
[root@localhost server]# pwd
/com/prosayj/server
[root@localhost server]# ll
total 0
drwxr-xr-x.  4 root  root   30 Sep 29 23:36 autoconf-2.69
drwxr-xr-x.  4 root  root   30 Sep 29 23:58 automake-1.11.1
drwxr-xr-x.  6 root  root   56 Sep 30 01:00 libtool-2.2.6b
drwxr-xr-x.  5 root  root   41 Sep 30 01:06 lrzsz-0.12.20
drwxr-xr-x.  4 root  root   30 Sep 29 23:06 m4-1.4.13
drwxr-xr-x.  4 root  root   30 Sep 29 23:32 m4-1.4.18
drwxr-xr-x. 10 mysql mysql 141 Sep 30 05:50 mysql-5.7.23
drwxr-xr-x.  5 root  root   39 Sep 29 23:22 perl-5.26.1
[root@localhost server]# cd mysql-5.7.23/
[root@localhost mysql-5.7.23]# ll
total 36
drwxr-xr-x.  2 mysql mysql  4096 Sep 30 05:41 bin
-rw-r--r--.  1 mysql mysql 17987 Jun  8 05:56 COPYING
drwxr-x---.  5 mysql mysql   147 Sep 30 05:50 data
drwxr-xr-x.  2 mysql mysql    55 Sep 30 05:41 docs
drwxr-xr-x.  3 mysql mysql  4096 Sep 30 05:41 include
drwxr-xr-x.  5 mysql mysql   230 Sep 30 05:41 lib
drwxr-xr-x.  4 mysql mysql    30 Sep 30 05:41 man
-rw-r--r--.  1 mysql mysql  2478 Jun  8 05:56 README
drwxr-xr-x. 28 mysql mysql  4096 Sep 30 05:41 share
drwxr-xr-x.  2 mysql mysql    90 Sep 30 05:45 support-files
```

 
(2)如果是分配了启动还是这个错误，参考下面的连接：
参考解决方案：[点我点我点我呀](https://www.xiazaiba.com/jiaocheng/10354.html)
``` sql
chown -R root:root /var/data

chmod -R 755 /com/prosayj/server/mysql-5.7.23
```
## 7：启动服务、查看进程、杀掉进程：
启动服务：
``` sql
cd /com/prosayj/server/mysql-5.7.23/ && ./support-files/mysql.server start
```
查看进程，杀掉进程：
``` sql
    ps -el|grep mysqld

    ps -el|grep mysqld
    kill -9 进程号
```
``` sql
[root@localhost mysql-5.7.23]# ps -el|grep mysqld
4 S     0   9178      1  0  80   0 - 28327 do_wai pts/3    00:00:00 mysqld_safe
4 S   987   9429   9178  3  80   0 - 279809 poll_s pts/3   00:00:00 mysqld

kill 9429
 ```   

## 8：将mysql进程放入系统进程中：
``` sql
cp /com/prosayj/server/mysql-5.7.23/support-files/mysql.server /etc/init.d/mysqld
```
## 9:启动、停止、重新启动mysql服务：
``` sql
service mysqld start

service mysqld stop

service mysqld restart
```
## 10：另一种方案
不使用8、9的方案，使用创建软连接的方式把mysql的启动、停止、重启都放到/usr/local/bin下使用：
``` sql
[root@localhost bin]# ll
total 0
lrwxrwxrwx. 1 root root 46 Sep 29 23:38 autoconf -> /com/prosayj/server/autoconf-2.69/bin/autoconf
lrwxrwxrwx. 1 root root 48 Sep 29 23:59 automake -> /com/prosayj/server/automake-1.11.1/bin/automake
lrwxrwxrwx. 1 root root 46 Sep 30 01:01 libtool -> /com/prosayj/server/libtool-2.2.6b/bin/libtool
lrwxrwxrwx. 1 root root 36 Sep 29 23:33 m4 -> /com/prosayj/server/m4-1.4.18/bin/m4
lrwxrwxrwx. 1 root root 40 Sep 29 23:23 perl -> /com/prosayj/server/perl-5.26.1/bin/perl
lrwxrwxrwx. 1 root root 41 Sep 30 01:09 rz -> /com/prosayj/server/lrzsz-0.12.20/bin/lrz
lrwxrwxrwx. 1 root root 41 Sep 30 01:09 sz -> /com/prosayj/server/lrzsz-0.12.20/bin/lsz
[root@localhost bin]# ln -s /com/prosayj/server/mysql-5.7.23/support-files/mysql.server /usr/local/bin/mysqld
[root@localhost bin]# ll
total 0
lrwxrwxrwx. 1 root root 46 Sep 29 23:38 autoconf -> /com/prosayj/server/autoconf-2.69/bin/autoconf
lrwxrwxrwx. 1 root root 48 Sep 29 23:59 automake -> /com/prosayj/server/automake-1.11.1/bin/automake
lrwxrwxrwx. 1 root root 46 Sep 30 01:01 libtool -> /com/prosayj/server/libtool-2.2.6b/bin/libtool
lrwxrwxrwx. 1 root root 36 Sep 29 23:33 m4 -> /com/prosayj/server/m4-1.4.18/bin/m4
lrwxrwxrwx. 1 root root 59 Sep 30 06:02 mysqld -> /com/prosayj/server/mysql-5.7.23/support-files/mysql.server
lrwxrwxrwx. 1 root root 40 Sep 29 23:23 perl -> /com/prosayj/server/perl-5.26.1/bin/perl
lrwxrwxrwx. 1 root root 41 Sep 30 01:09 rz -> /com/prosayj/server/lrzsz-0.12.20/bin/lrz
lrwxrwxrwx. 1 root root 41 Sep 30 01:09 sz -> /com/prosayj/server/lrzsz-0.12.20/bin/lsz
[root@localhost bin]#
```  

## 11：软连接下的启动、停止、重启mysql:
``` sql
mysqld start

mysqld stop

mysqld restart
```
** 这个是个人比较喜欢的方法，启动mysql使用最简洁的命令，暂时不想做成开机自启动项。**

## 12：使用随机密码登录mysql数据库:
先把mysql的命令设置为环境变量:
/etc/profile 中添加 ```export PATH=$PATH:/com/prosayj/server/mysql-5.7.23/bin ```

重新编译下：``` source /etc/profile ```

### 13：登陆mysql,使用第十步生成的随机密码(czZs/w&Rj4#i)登陆
``` sql
[root@localhost mysql-5.7.23]# mysql -uroot -p
Enter password: 
Welcome to the MySQL monitor. Commands end with ; or \g.
Your MySQL connection id is 4
Server version: 5.7.23

Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
ERROR 1820 (HY000): You must reset your password using ALTER USER statement before executing this statement.
mysql> 
``` 

** 注意： 必须修改初始化密码才可以操作数据库！**

## 14:修改初始化密码为root：
``` sql
alter user 'root'@'localhost' identified by 'root';

[root@localhost /]# mysql -uroot -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 2
Server version: 5.7.23

Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> alter user 'root'@'localhost' identified by 'root';
Query OK, 0 rows affected (0.00 sec)

mysql>
```
 

## 15:允许mysql支持远程访问：

先进入mysql,并且使用user数据库,修改root用户的host字段值并刷新权限：

``` sql
[root@localhost /]# mysql -uroot -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 5
Server version: 5.7.23 MySQL Community Server (GPL)

Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use mysql
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> select user,host from user;
+---------------+-----------+
| user          | host      |
+---------------+-----------+
| mysql.session | localhost |
| mysql.sys     | localhost |
| root          | localhost |
+---------------+-----------+
3 rows in set (0.00 sec)

mysql> update user set user.Host='%' where user.User='root';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select user,host from user;
+---------------+-----------+
| user          | host      |
+---------------+-----------+
| root          | %         |
| mysql.session | localhost |
| mysql.sys     | localhost |
+---------------+-----------+
3 rows in set (0.00 sec)

mysql> flush privileges;
Query OK, 0 rows affected (0.00 sec)

mysql> 

```




## 16：查看mysql监听的端口号，并开放防火墙端口：

``` sql
[root@localhost mysql-5.7.23]# netstat -nltp

Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name    
tcp        0      0 0.0.0.0:3306            0.0.0.0:*               LISTEN      12890/mysqld        
tcp        0      0 0.0.0.0:111             0.0.0.0:*               LISTEN      686/rpcbind         
tcp        0      0 192.168.122.1:53        0.0.0.0:*               LISTEN      1441/dnsmasq        
tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      1122/sshd           
tcp        0      0 127.0.0.1:631           0.0.0.0:*               LISTEN      1116/cupsd          
tcp6       0      0 :::111                  :::*                    LISTEN      686/rpcbind         
tcp6       0      0 :::22                   :::*                    LISTEN      1122/sshd           
tcp6       0      0 ::1:631                 :::*                    LISTEN      1116/cupsd          
[root@localhost mysql-5.7.23]# 

[root@localhost mysql-5.7.23]# firewall-cmd --state
running
[root@localhost mysql-5.7.23]# clear
[root@localhost mysql-5.7.23]# firewall-cmd --permanent --add-port=3306/tcp
success
[root@localhost mysql-5.7.23]# firewall-cmd --reload
success
[root@localhost mysql-5.7.23]# firewall-cmd --query-port=3306/tcp
yes
[root@localhost mysql-5.7.23]# 

```

## 17：远程客户端连接mysql：
如果还是连接不上：
修改：``` /etc/my.cnf ``` 在** [mysqld_safe] **下新增：
** skip-grant-tables **
结束。