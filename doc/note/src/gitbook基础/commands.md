https://github.com/ProSayJ/springbootstudy/blob/master/upup/src/main/java/com/prosayj/springboot/_00_实战Java高并发程序设计/chapter2_java并行程序基础/_01_stop_thread/_01_StopThreadUnsafe.java

# 插件的基本测试：
Info styling
> **[info] For info**
>
> Use this for infomation messages.

Warning styling
> **[warning] For warning**
>
> Use this for warning messages.

Danger styling
> **[danger] For danger**
>
> Use this for danger messages.

Success styling
> **[success] For info**
>
> Use this for success messages.


# 命令

** 安装gitbook：**

先行安装Node.js、GitBook、GitBook Editor、Git版本控制器

node -v //显示v4.5.0 验证是否安装成功；

npm install gitbook -g 命令行安装gitbook；

npm install -g gitbook-cli 安装gitbook的命令行工具；

gitbook -V //显示0.4.2 检测是否成功；

卸载用npm uninstall -g gitbook


这里主要介绍一下 GitBook 的命令行工具 `gitbook-cli` 的一些命令, 首先说明两点:
* `gitbook-cli` 和 `gitbook` 是两个软件
* `gitbook-cli` 会将下载的 gitbook 的不同版本放到 `~/.gitbook`中, 可以通过设置`GITBOOK_DIR`环境变量来指定另外的文件夹



## 列出gitbook所有的命令
```bash
gitbook help
```

## 输出`gitbook-cli`的帮助信息
```bash
gitbook --help
```

## 生成静态网页
```bash
gitbook build
```
## 生成静态网页并运行服务器
```bash
gitbook serve
```

## 生成时指定gitbook的版本, 本地没有会先下载
```bash
gitbook build --gitbook=2.0.1
```

## 列出本地所有的gitbook版本
```bash
gitbook ls
```

## 列出远程可用的gitbook版本
```bash
gitbook ls-remote
```

## 安装对应的gitbook版本
```bash
gitbook fetch 标签/版本号
```

## 更新到gitbook的最新版本
```bash
gitbook update
```

## 卸载对应的gitbook版本
```bash
gitbook uninstall 2.0.1
```

## 指定log的级别
```bash
gitbook build --log=debug
```

## 输出错误信息
```bash
gitbook builid --debug
```
