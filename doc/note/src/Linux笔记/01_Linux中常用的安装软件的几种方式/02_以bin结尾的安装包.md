## 02_以bin结尾的安装包
这种包类似于RPM包，安装也比较简单：

** 1、打开一个SHELL，即终端 **

2、用CD 命令进入源代码压缩包所在的目录

3、给文件加上可执行属性：chmod +x ******.bin（中间是字母x，小写）

4、执行命令：./******.bin(realplayer for linux就是这样的安装包)

3.1：如何卸载bin结尾介质安装的软件：
把安装时选择的安装目录删除就OK

执行安装过程中可以指定安装目录，类似于Windows下安装。

 

 

 

 

注意：特例：

我在安装rz\sz的tar.gz的包的时候；出现了以下情况：

``` shell
[root@localhost lrzsz-0.12.20]# ./config --prefix=/com/prosayj/server/
-bash: ./config: No such file or directory
[root@localhost lrzsz-0.12.20]# 

```
一般情况下，多看看目录下的readme和INSTALL文件，里面会告诉你怎么安装软件。

这里我目前知道可能有两种情况：
1、目录下没有configure，但有configure.am或configure.in时，需要用autoconf命令来生成configure。代码如下：
$cd (软件名)-(版本号)
$autoconf

2、此软件或库安装方式不是按以下套路来安装,
$cd (软件名)-(版本号)
``` shell
$./configure
$make
$sudo make install
```
就需要认真阅读文件夹下的相关文件readme等等，按里面写的方式来安装！

3、autoconf 需要另行安装，是 gnu 的一个子模块