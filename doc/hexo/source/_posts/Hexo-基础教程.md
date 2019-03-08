title: Hexo_基础教程
author: ProSayJ
tags:
  - Hexo
categories:
  - 教程
date: 2019-03-03 22:51:00
---
[hexo配置1](https://www.jianshu.com/p/21c94eb7bcd1)

[hexo配置2](https://www.jianshu.com/p/3fe88ef479dd)

[hexo官方配置官方文档](https://hexo.io/zh-cn/docs/plugins.html)

[hexo官方插件库](https://hexo.io/plugins/)

[hexo高级配置](https://www.jianshu.com/p/efbeddc5eb19)

[超完整的配置](https://reuixiy.github.io/technology/computer/computer-aided-art/2017/06/09/hexo-next-optimization.html)


# 安装配置Hexo

## 安装好node.js和git后，可以通过npm来安装Hexo。

```
npm install -g hexo-cli
```

## 初始化目录

```
hexo init <folder>

```

## cd到init的目录执行 npm install 安装编译。


**注：init以后其实已经install过了，也可以不install**



## 初始化项目的目录结构rx：

    .
    ├── _config.yml
    ├── package.json
    ├── scaffolds
    ├── source
    |   ├── _drafts
    |   └── _posts
    └── themes
    

其中:
- **config.yml:**

    博客的配置文件，博客的名称、关键词、作者、语言、博客主题...设置都在里面。
    
- **package.json:**

    应用程序信息，新添加的插件内容也会出现在这里面，我们可以不修改这里的内容。

- **scaffolds:**
  scaffolds就是脚手架的意思，这里放了三个模板文件，分别是新添加博客文章（posts）、新添加博客页（page）和新添加草稿（draft）的目标样式。
  这部分可以修改的内容是，我们可以在模板上添加比如categories等自定义内容。

- **source：**

    source是放置我们博客内容的地方，里面初始只有两个文件夹，一个是drafts（草稿），一个posts（文章），但之后我们通过命令新建tags（标签）还有categories（分类）页后，这里会相应地增加文件夹。

- **themes：**

    放置主题文件包的地方。Hexo会根据这个文件来生成静态页面。
    初始状态下只有landscape一个文件夹，后续我们可以添加自己喜欢的。



 ## Hexo命令：
- hexo init <folder>初始化项目
- hexo n <filename> 新建文章(n--->new)
- hexo s 启动服务器，在本地查看内容(s--->server)
- hexo g 生成静态页面(g--->generate)
- hexo d 部署到网站(d--->deploy)




# 操作：
## 创建“分类”页面
### 新建分类页面：
``` shell
hexo new page categories 
```
我们在source文件夹中的categories文件夹下找到index.md文件，并在它的头部加上type属性。


    title: 文章分类
    date: 2017-05-27 13:47:40
    type: "categories"   #这部分是新添加的


### 给模板添加分类属性：

现在我们打开scarffolds文件夹里的post.md文件，给它的头部加上categories:，
这样我们创建的所有新的文章都会自带这个属性，我们只需要往里填分类，
就可以自动在网站上形成分类了。
    

    title: {{ title }}
    date: {{ date }}
    categories:
    tags:


### 给文章添加分类:

现在我们可以找到一篇文章，然后尝试给它添加分类:

    layout: posts
    title: 写给小白的express学习笔记1： express-static文件静态管理
    date: 2018-06-07 00:38:36
    categories: 学习笔记
    tags: [node.js, express]



## 创建“标签”页面
创建"标签"页的方式和创建“分类”一样。

### 新建“标签”页面:**hexo new page tags**
### 给标签页面添加类型:
我们在source文件夹中的tags文件夹下找到index.md文件，并在它的头部加上type属性。

    title: tags
    date: 2018-08-06 22:48:29
    type: "tags" #新添加的内容



### 给文章添加标签:

有两种写法都可以，第一种是类似数组的写法，把标签放在中括号[]里，用英文逗号隔开.
**第一种：**

    layout: posts
    title: 写给小白的express学习笔记1： express-static文件静态管理
    date: 2018-06-07 00:38:36
    categories: 学习笔记
    tags: [node.js, express]


**第二种：**

    layout: posts
    title: 写给小白的express学习笔记1： express-static文件静态管理
    date: 2018-06-07 00:38:36
    categories: 学习笔记
    tags: 
        - node.js
        - express


# NexT主题

[NexT中文文档](https://github.com/iissnan/hexo-theme-next/blob/master/README.cn.md)

## 安装

``` shell
$ git clone https://github.com/iissnan/hexo-theme-next themes/next 
```

## 设置主题

在**hexo根目录下**的配置文件config.yml里设置主题:

    # Extensions
    ## Plugins: https://hexo.io/plugins/
    ## Themes: https://hexo.io/themes/
    ## theme: landscape
    theme: next

## 菜单栏 menu
原生菜单栏有主页、关于、分类、标签等数个选项，但是在配置文件中是注释掉的状态，这里我们自行修改注释就行。

    menu:
      home: / || home
      # about: /about/ || user
      tags: /tags/ || tags
      categories: /categories/ || th
      archives: /archives/ || archive
      # schedule: /schedule/ || calendar
      # sitemap: /sitemap.xml || sitemap
      # commonweal: /404/ || heartbeat


**注意点：**
- 如果事先没有通过 **hexo new page <pageName>**来创建页面的话，即使在配置文件中取消注释，页面也没法显示。
- 我们也可以添加自己想要添加的页面，不用局限在配置文件里提供的选择里。
- ||后面是fontAwesome里的文件对应的名称。
- menu_icons 记得选enable: true（默认应该是true）

## 配置主题
所有内容都在themes/next文件夹下的config.yml文件里修改。

官方文档里写的是有些配置需要将一部分代码添加到配置文件中，但其实不用，我们逐行看配置文件就会发现，有很多功能都已经放在配置文件里了，只是注释掉了，我们只需要取消注释，把需要的相关信息补全即可使用。


### 侧栏设置
**侧栏设置包括：侧栏位置、侧栏显示与否、文章间距、返回顶部按钮等等**

打开**主题配置文件**找到**sidebar**字段。

``` 
sidebar:
  # Sidebar Position, available value: left | right (only for Pisces | Gemini).
  #position: left
  position: right

  # Sidebar Display, available value (only for Muse | Mist):
  #  - post    expand on posts automatically. Default. 默认行为，在文章页面（拥有目录列表）时显示
  #  - always  expand for all pages automatically.在所有页面中都显示
  #  - hide    expand only when click on the sidebar toggle icon.在所有页面中都隐藏（可以手动展开）
  #  - remove  Totally remove sidebar including sidebar toggle.完全移除
  #display: post
  display: always
  #display: hide
  #display: remove

  # Sidebar offset from top menubar in pixels (only for Pisces | Gemini).文章间距（只对Pisces | Gemini两种风格有效）
  offset: 12

  # Back to top in sidebar (only for Pisces | Gemini). 返回顶部按钮（只对Pisces | Gemini两种风格有效）
  b2t: false

  # Scroll percent label in b2t button.返回顶部按钮的百分比
  scrollpercent: true
```

### 主题风格 schemes

next有四种主题风格：我们把想要选择的取消注释，其他三个保持注释掉的状态即可。

    # Schemes
    #scheme: Muse
    #scheme: Mist
    scheme: Pisces
    #scheme: Gemini


### 底部建站时间和图标修改**footer:**

- 把用户的图标从小人user改成了雪花snowflake-o
- copyright留空，显示成页面author即我的名字
- powered: false把hexo的授权图片取消了
- theme: enable:false 把主题的内容也取消了


### 网站动画效果

    motion:
      enable: true

    motion:
      enable: true
      async: true
      
    # Canvas-nest
    canvas_nest: true

    # three_waves
    three_waves: false

    # canvas_lines
    canvas_lines: false

    # canvas_sphere
    canvas_sphere: false

canvas_nest: true是一个不错的动态图配置：如果想要更改颜色和数量？修改文件：
```
blog/themes/next/source/lib/canvas-nest/canvas-nest.min.js
```
具体修改参见：[README](https://github.com/hustcc/canvas-nest.js/blob/master/README-zh.md)


### 统计文章字数和阅读时间

    # Post wordcount display settings
    # Dependencies: https://github.com/willin/hexo-wordcount
    post_wordcount:
      item_text: true
      wordcount: true  # 文章字数
      min2read: true   # 阅读时间
      totalcount: true  # 总共字数
      separated_meta: true

### 网站标题栏背景颜色
当使用Pisces主题时，网站标题栏背景颜色是黑色的，感觉不好看，可以在 source/css/_schemes/Pisces/_brand.styl 中修改：

    .site-meta {
      padding: 20px 0;
      color: white;
      background: $blue-dodger; //修改为自己喜欢的颜色

      +tablet() {
        box-shadow: 0 0 16px rgba(0,0,0,0.5);
      }
      +mobile() {
        box-shadow: 0 0 16px rgba(0,0,0,0.5);
      }
    }
 
 但是，我们一般不主张这样修改源码的，在 next/source/css/_custom 目录下面专门提供了 custom.styl 供我们自定义样式的，因此也可以在 custom.styl 里面添加：
 
     // Custom styles.
    .site-meta {
      background: $blue; //修改为自己喜欢的颜色
    }
    
    
### 内容板块宽度设置
**默认的宽度觉得有点窄，想改宽一点：**

在source/css/_schemes/Picses/_layout.styl文件末尾添加如下代码：

``` 
// 以下为新增代码:新增内容板块宽度
header{ width: 90% !important; }
header.post-header {
  width: auto !important;
}
.container .main-inner { width: 90%; }
.content-wrap { width: calc(100% - 260px); }

.header {
  +tablet() {
    width: auto !important;
  }
  +mobile() {
    width: auto !important;
  }
}

.container .main-inner {
  +tablet() {
    width: auto !important;
  }
  +mobile() {
    width: auto !important;
  }
}

.content-wrap {
  +tablet() {
    width: 100% !important;
  }
  +mobile() {
    width: 100% !important;
  }
}
```

    
### 添加背景图
在 themes/next/source/css/_custom/custom.styl 中添加如下代码：

    body{
        background:url(/images/bg.jpg);
        background-size:cover;
        background-repeat:no-repeat;
        background-attachment:fixed;
        background-position:center;
    }
    
### 各版块透明度修改

#### 内容板块透明
博客根目录 themes\next\source\css\_schemes\Pisces\_layout.styl 文件 .content-wrap 标签下 background: white修改为：

		background: rgba(255,255,255,0.7); //0.7是透明度
   
        
#### 菜单栏背景
博客根目录 themes\next\source\css\_schemes\Pisces\_layout.styl 文件 .header-inner 标签下 background: white修改为：

		background: rgba(255,255,255,0.7); //0.7是透明度
        
#### 站点概况背景
博客根目录 themes\next\source\css\_schemes\Pisces\_sidebar.styl 文件 .sidebar-inner 标签下 background: white修改为：

		background: rgba(255,255,255,0.7); //0.7是透明度
        
然后修改博客根目录 themes\next\source\css\_schemes\Pisces\_layout.styl 文件 .sidebar 标签下 background: $body-bg-color修改为：

		background: rgba(255,255,255,0.7); //0.7是透明度
        
####  按钮背景
博客根目录 themes\next\source\css\_common\components\post\post-button.styl 同上修改对应位置为 background: transparent;

### read more
进入主题的_config.yml文件，修改配置为true即可：

        # Automatically Excerpt. Not recommend.
        # Please use <!-- more --> in the post to control excerpt accurately.
        auto_excerpt:
          enable: true
          length: 150
          
### Hexo中添加本地图片
把主页配置文件_config.yml 里的post_asset_folder:这个选项设置为true。

```
npm install hexo-asset-image --save
```

以后新建md文件的时候也

### 主题自带样式 FontAwesome

- <i class="fa fa-pencil"></i> 支持 Markdown
<i>Hexo 支持 GitHub Flavored Markdown 的所有功能，甚至可以整合 Octopress 的大多数插件。</i>
-  <i class="fa fa-cloud-upload"></i> 一件部署
<i>只需一条指令即可部署到 GitHub Pages，或其他网站。</i>
- <i class="fa fa-cog"></i> 丰富的插件
<i>Hexo 拥有强大的插件系统，安装插件可以让 Hexo 支持 Jade，CoffeeScript。</i>
- <i class="fa fa-download"></i> 下载
- <i class="fa fa-download fa-lg"></i> 下载变大 33%
- <i class="fa fa-download fa-2x"></i> 下载两倍大
- <i class="fa fa-photo"></i> 图片
- <i class="fa fa-video-camera"></i> 摄像机
- <i class="fa fa-hand-o-right "></i> 右手
- <i class="fa fa-hand-o-left "></i> 左手
- <i class="fa fa-hand-o-up"></i> 上手
- <i class="fa fa-hand-o-down"></i> 下手
- <i class="fa fa-glass"></i> 杯子
- <i class="fa fa-music"></i> 音乐
- <i class="fa fa-search"></i> 查找
- <i class="fa fa-envelope-o"></i> 信封
- <i class="fa fa-heart"></i> 心
- <i class="fa fa-star"></i> 星
- <i class="fa fa-star-o"></i> 心空
- <i class="fa fa-user"></i> 人
- <i class="fa fa-film"></i> 电影
- <i class="fa fa-th-large"></i> 
- <i class="fa fa-th"></i> 
- <i class="fa fa-th-list"></i> 
- <i class="fa fa-check"></i> 对号
- <i class="fa fa-times"></i> false
- <i class="fa fa-search-plus"></i> 查找大
- <i class="fa fa-search-minus"></i> 查找小
- <i class="fa fa-power-off"></i> 关机
- <i class="fa fa-signal"></i> 信号
- <i class="fa fa-gear:before"></i> 电影
- <i class="fa fa-cog"></i> 
- <i class="fa fa-trash-o"></i> 垃圾桶
- <i class="fa fa-home"></i> 房子
- <i class="fa fa-file-o"></i> 文件
- <i class="fa fa-clock-o"></i> 时钟
- <i class="fa fa-road"></i> 路
- <i class="fa fa-download"></i> 下载
- <i class="fa fa-arrow-circle-o-down"></i> 电影
- <i class="fa fa-arrow-circle-o-up"></i> 星
- <i class="fa fa-inbox"></i> 心空
- <i class="fa fa-play-circle-o"></i> 
- <i class="fa fa-rotate-right"></i> 播放
- <i class="fa fa-repeat"></i> 重复
- <i class="fa fa-refresh"></i> 刷新
- <i class="fa fa-list-alt"></i> 列表
- <i class="fa fa-lock"></i> 锁
- <i class="fa fa-flag "></i> 标记
- <i class="fa fa-headphones"></i> 耳机
- <i class="fa fa-volume-off"></i> 声音关
- <i class="fa fa-volume-down"></i> 声音下
- <i class="fa fa-volume-up"></i> 声音大
- <i class="fa fa-qrcode "></i> 二维码
- <i class="fa fa-barcode "></i> 二维码
- <i class="fa fa-tag "></i> tag
- <i class="fa fa-tags "></i> tags
- <i class="fa fa-book "></i> 书
- <i class="fa fa-bookmark "></i> 书签
- <i class="fa fa-print"></i> 11
- <i class="fa fa-camera"></i> 
- <i class="fa fa-font"></i> 
- <i class="fa fa-bold"></i> 
- <i class="fa fa-italic"></i> 
- <i class="fa fa-text-height"></i> 
- <i class="fa fa-text-width"></i> 
- <i class="fa fa-align-left"></i> 
- <i class="fa fa-align-center"></i> 
- <i class="fa fa-align-right"></i> 
- <i class="fa fa-align-justify"></i> 
- <i class="fa fa-list"></i> 
- <i class="fa fa-dedent"></i> 
- <i class="fa fa-outdent"></i> 
- <i class="fa fa-indent"></i> 
- <i class="fa fa-video-camera"></i> 
- <i class="fa fa-picture-o"></i> 
- <i class="fa fa-pencil "></i> 
- <i class="fa fa-map-marker"></i> 
- <i class="fa fa-adjust"></i> 
- <i class="fa fa-tint"></i> 
- <i class="fa fa-edit"></i> 
- <i class="fa fa-pencil-square-o"></i> 
- <i class="fa fa-share-square-o"></i> 
- <i class="fa fa-share"></i> 




``` javaScript
- <i class="fa fa-pencil"></i>
-  <i class="fa fa-cloud-upload"></i> 
- <i class="fa fa-cog"></i> 
- <i class="fa fa-download"></i> 下载
- <i class="fa fa-download fa-lg"></i> 下载变大 33%
- <i class="fa fa-download fa-2x"></i> 下载两倍大
- <i class="fa fa-photo"></i> 图片
- <i class="fa fa-video-camera"></i> 摄像机
- <i class="fa fa-hand-o-right "></i> 右手
- <i class="fa fa-hand-o-left "></i> 左手
- <i class="fa fa-hand-o-up"></i> 上手
- <i class="fa fa-hand-o-down"></i> 下手
- <i class="fa fa-glass"></i> 杯子
- <i class="fa fa-music"></i> 音乐
- <i class="fa fa-search"></i> 查找
- <i class="fa fa-envelope-o"></i> 信封
- <i class="fa fa-heart"></i> 心
- <i class="fa fa-star"></i> 星
- <i class="fa fa-star-o"></i> 心空
- <i class="fa fa-user"></i> 人
- <i class="fa fa-film"></i> 电影
- <i class="fa fa-th-large"></i> 
- <i class="fa fa-th"></i> 
- <i class="fa fa-th-list"></i> 
- <i class="fa fa-check"></i> 对号
- <i class="fa fa-times"></i> false
- <i class="fa fa-search-plus"></i> 查找大
- <i class="fa fa-search-minus"></i> 查找小
- <i class="fa fa-power-off"></i> 关机
- <i class="fa fa-signal"></i> 信号
- <i class="fa fa-gear:before"></i> 电影
- <i class="fa fa-cog"></i> 
- <i class="fa fa-trash-o"></i> 垃圾桶
- <i class="fa fa-home"></i> 房子
- <i class="fa fa-file-o"></i> 文件
- <i class="fa fa-clock-o"></i> 时钟
- <i class="fa fa-road"></i> 路
- <i class="fa fa-download"></i> 下载
- <i class="fa fa-arrow-circle-o-down"></i> 电影
- <i class="fa fa-arrow-circle-o-up"></i> 星
- <i class="fa fa-inbox"></i> 心空
- <i class="fa fa-play-circle-o"></i> 
- <i class="fa fa-rotate-right"></i> 播放
- <i class="fa fa-repeat"></i> 重复
- <i class="fa fa-refresh"></i> 刷新
- <i class="fa fa-list-alt"></i> 列表
- <i class="fa fa-lock"></i> 锁
- <i class="fa fa-flag "></i> 标记
- <i class="fa fa-headphones"></i> 耳机
- <i class="fa fa-volume-off"></i> 声音关
- <i class="fa fa-volume-down"></i> 声音下
- <i class="fa fa-volume-up"></i> 声音大
- <i class="fa fa-qrcode "></i> 二维码
- <i class="fa fa-barcode "></i> 二维码
- <i class="fa fa-tag "></i> tag
- <i class="fa fa-tags "></i> tags
- <i class="fa fa-book "></i> 书
- <i class="fa fa-bookmark "></i> 书签
- <i class="fa fa-print"></i> 11
- <i class="fa fa-camera"></i> 
- <i class="fa fa-font"></i> 
- <i class="fa fa-bold"></i> 
- <i class="fa fa-italic"></i> 
- <i class="fa fa-text-height"></i> 
- <i class="fa fa-text-width"></i> 
- <i class="fa fa-align-left"></i> 
- <i class="fa fa-align-center"></i> 
- <i class="fa fa-align-right"></i> 
- <i class="fa fa-align-justify"></i> 
- <i class="fa fa-list"></i> 
- <i class="fa fa-dedent"></i> 
- <i class="fa fa-outdent"></i> 
- <i class="fa fa-indent"></i> 
- <i class="fa fa-video-camera"></i> 
- <i class="fa fa-picture-o"></i> 
- <i class="fa fa-pencil "></i> 
- <i class="fa fa-map-marker"></i> 
- <i class="fa fa-adjust"></i> 
- <i class="fa fa-tint"></i> 
- <i class="fa fa-edit"></i> 
- <i class="fa fa-pencil-square-o"></i> 
- <i class="fa fa-share-square-o"></i> 
- <i class="fa fa-share"></i> 
```

### 主题自带样式 note 标签
<div class="note default"><p>default</p></div>
<div class="note primary"><p>primary</p></div>
<div class="note success"><p>success</p></div>
<div class="note info"><p>info</p></div>
<div class="note warning"><p>warning</p></div>
<div class="note danger"><p>danger</p></div>
<div class="note danger no-icon"><p>danger no-icon</p></div>

``` javaScript
<div class="note default"><p>default</p></div>
<div class="note primary"><p>primary</p></div>
<div class="note success"><p>success</p></div>
<div class="note info"><p>info</p></div>
<div class="note warning"><p>warning</p></div>
<div class="note danger"><p>danger</p></div>
<div class="note danger no-icon"><p>danger no-icon</p></div>
```

### 主题自带样式 label 标签
**首先可以在主题配置文件中有配置，需要配置下**
~/blog/themes/next/_config.yml
```
# Label tag.
label: true
```

{% label default@default %}
{% label primary@primary %}
{% label success@success %}
{% label info@info %}
{% label warning@warning %}
{% label danger@danger %}

``` javaScript
{% label default@default %}
{% label primary@primary %}
{% label success@success %}
{% label info@info %}
{% label warning@warning %}
{% label danger@danger %}
```
### 主题自带样式 tabs 标签

**配置：**
/blog/themes/next/_config.yml
```
# Tabs tag.
tabs:
  enable: true
  transition:
    tabs: true
    labels: true
  border_radius: 0
```
**然后上面源码中, 2表示一开始在第二个选项卡，非必须，若数值为-1则隐藏选项卡内容。**

{% tabs 选项卡, 2 %}
<!-- tab -->
**这是选项卡 1** 呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈……
<!-- endtab -->
<!-- tab -->
**这是选项卡 2**
<!-- endtab -->
<!-- tab -->
**这是选项卡 3** 哇，你找到我了！φ(≧ω≦*)♪～
<!-- endtab -->
{% endtabs %}

``` javaScript
{% tabs 选项卡, 2 %}
<!-- tab -->
**这是选项卡 1** 呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈呵呵哈哈哈哈哈哈哈哈……
<!-- endtab -->
<!-- tab -->
**这是选项卡 2**
<!-- endtab -->
<!-- tab -->
**这是选项卡 3** 哇，你找到我了！φ(≧ω≦*)♪～
<!-- endtab -->
{% endtabs %}
```

### 主题自带样式 按钮
{% btn https://www.baidu.com, 点击下载百度, download fa-lg fa-fw %}
``` JavaScript
{% btn https://www.baidu.com, 点击下载百度, download fa-lg fa-fw %}
```


## 第三方插件

### Hexo-admin
**Hexo-admin插件允许我们直接在本地页面上修改文章内容。**
- 下载： 
  ``` shell
  npm i hexo-admin --save 
  ```
- 登录 http://localhost:4000/admin 即可看到我们所有的文章内容，并且在可视化界面中操作文章内容

### Next 主题添加站内搜索功能
- 安装 **hexo-generator-searchdb**, 站点根目录执行以下命令。
  
``` shell 
npm install hexo-generator-searchdb --save 
```

- 在**站点配置文件中**配置文件中新增如下配置：

      search:
        path: search.xml
        field: post
        format: html
        limit: 10000


- 在**主题配置文件**, 启用本地搜索功能即可。
 
      # Local search
        local_search:
        enable: true