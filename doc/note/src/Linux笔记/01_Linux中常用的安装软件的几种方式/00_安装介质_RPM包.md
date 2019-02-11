<!-- toc -->
# 00：安装介质_RPM包 

这种软件包就像windows的EXE安装文件一样，各种文件已经编译好，并打了包，哪个文件该放到哪个文件夹，都指定好了，安装非常方便，在图形界面里,你只需要双击就能自动安装。
如果指定Linux安装软件时所需要安装到的目录 为软件包指定安装目录：要加 -relocate 参数；下面的举例是把gaim-1.3.0-1.fc4.i386.rpm指定安装在 /opt/gaim 目录中,如下：

1：``` rpm - i jenkins-2.138.1-1.1.noarch.rpm ``` 安装jenkins-2.138.1-1.1.noarch.rpm包；

2：```rpm - iv jenkins-2.138.1-1.1.noarch.rpm``` 安装jenkins-2.138.1-1.1.noarch.rpm包, 并在安装过程中显示正在安装的文件信息；

3：```rpm - ivh jenkins-2.138.1-1.1.noarch.rpm``` 安装jenkins-2.138.1-1.1.noarch.rpm包,并在安装过程中显示正在安装的文件信息及安装进度



注意：为软件包指定安装目录：要加 -relocate 参数；下面的举例是把lynx-2.8.5-23.i386.rpm 指定安装在 /opt/lynx 目录中：

```
rpm -ivh --prefix=/com/prosayj/server/jenkins-2.138.1-1.1.noarch jenkins-2.138.1-1.1.noarch.rpm 

```
安装jenkins-2.138.1-1.1.noarch.rpm到指定的com/prosayj/server/jenkins-2.138.1-1.1.noarch目录下



## 1.1：如何卸载安装介质是RPM包的软件:

### 1、打开一个SHELL终端;

### 2、确定这个软件的完整名称：

  因为Linux下的软件名都包括版本号，所以卸载前最好先确定这个软件的完整名称。

查找RPM包软件：rpm -qa | grep wget   wget是可以模糊查询的，不要求写全，但是要求不写错

```
[root@localhost jenkins]# rpm -qa | grep wget

wget-1.14-15.el7_4.1.x86_64

```

### 3、找到软件后，显示出来的是软件完整名称，如firefox-1.0.1-1.3.2 执行卸载命令：``` rpm -e wget-1.14-15.el7_4.1.x86_64```



附：安装目录，执行命令查找： rpm -ql jenkins-2.138.1-1.1.noarch

```
[root@localhost jenkins]# rpm -ql jenkins-2.138.1-1.1.noarch
/etc/init.d/jenkins
/etc/logrotate.d/jenkins
/etc/sysconfig/jenkins
/usr/lib/jenkins
/usr/lib/jenkins/jenkins.war
/usr/sbin/rcjenkins
/var/cache/jenkins
/var/lib/jenkins
/var/log/jenkins

```