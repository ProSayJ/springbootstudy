{hexo配置1](https://www.jianshu.com/p/21c94eb7bcd1)
{hexo配置2](https://www.jianshu.com/p/3fe88ef479dd)
{hexo官方配置官方文档](https://hexo.io/zh-cn/docs/plugins.html)
{hexo官方插件库](https://hexo.io/plugins/)
# 安装Hexo

## 安装好node.js和git后，可以通过npm来安装Hexo。
```
npm install -g hexo-cli
```
## 初始化目录
```
hexo init <folder>

```
## cd到init的目录执行``` npm install ```安装编译。

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
- ```hexo init <folder>```初始化项目
- ```hexo n <filename>``` 新建文章(n--->new)
- ```hexo s``` 启动服务器，在本地查看内容(s--->server)
- ```hexo g``` 生成静态页面(g--->generate)
- ```hexo d``` 部署到网站(d--->deploy)   

# 操作：
## 创建“分类”页面
- 新建分类页面：``` hexo new page categories ```

    我们在source文件夹中的categories文件夹下找到index.md文件，并在它的头部加上type属性。

```
---
title: 文章分类
date: 2017-05-27 13:47:40
type: "categories"   #这部分是新添加的
---
```
---
- 给模板添加分类属性

    现在我们打开scarffolds文件夹里的post.md文件，给它的头部加上categories:，这样我们创建的所有新的文章都会自带这个属性，我们只需要往里填分类，就可以自动在网站上形成分类了。
```
    title: {{ title }}
    date: {{ date }}
    categories:
    tags:
```

---
- 给文章添加分类:

    现在我们可以找到一篇文章，然后尝试给它添加分类:

```
    layout: posts
    title: 写给小白的express学习笔记1： express-static文件静态管理
    date: 2018-06-07 00:38:36
    categories: 学习笔记
    tags: [node.js, express]
```

## 创建“标签”页面
创建"标签"页的方式和创建“分类”一样。

- 新建“标签”页面:``` hexo new page tags ```
- 给标签页面添加类型:

  我们在source文件夹中的tags文件夹下找到index.md文件，并在它的头部加上type属性。

  ```
    title: tags
    date: 2018-08-06 22:48:29
    type: "tags" #新添加的内容
  ```

---
- 给文章添加标签:
    有两种写法都可以，第一种是类似数组的写法，把标签放在中括号[]里，用英文逗号隔开.

```
    layout: posts
    title: 写给小白的express学习笔记1： express-static文件静态管理
    date: 2018-06-07 00:38:36
    categories: 学习笔记
    tags: [node.js, express]
```

```
    layout: posts
    title: 写给小白的express学习笔记1： express-static文件静态管理
    date: 2018-06-07 00:38:36
    categories: 学习笔记
    tags: 
        - node.js
        - express
```

# NexT主题
[NexT中文文档](https://github.com/iissnan/hexo-theme-next/blob/master/README.cn.md)

## 安装
```$ git clone https://github.com/iissnan/hexo-theme-next themes/next ```

## 设置主题
在**hexo根目录下**的配置文件config.yml里设置主题:

```
# Extensions
## Plugins: https://hexo.io/plugins/
## Themes: https://hexo.io/themes/
## theme: landscape
theme: next
```

## 配置主题
所有内容都在themes/next文件夹下的config.yml文件里修改。

官方文档里写的是有些配置需要将一部分代码添加到配置文件中，但其实不用，我们逐行看配置文件就会发现，有很多功能都已经放在配置文件里了，只是注释掉了，我们只需要取消注释，把需要的相关信息补全即可使用。

### 菜单栏 menu

    原生菜单栏有主页、关于、分类、标签等数个选项，但是在配置文件中是注释掉的状态，这里我们自行修改注释就行。

```
menu:
  home: / || home
  # about: /about/ || user
  tags: /tags/ || tags
  categories: /categories/ || th
  archives: /archives/ || archive
  # schedule: /schedule/ || calendar
  # sitemap: /sitemap.xml || sitemap
  # commonweal: /404/ || heartbeat

```
**注意点：**
- 如果事先没有通过 **hexo new page <pageName>**来创建页面的话，即使在配置文件中取消注释，页面也没法显示。
- 我们也可以添加自己想要添加的页面，不用局限在配置文件里提供的选择里。
- ||后面是fontAwesome里的文件对应的名称。
- menu_icons 记得选enable: true（默认应该是true）

---
### 侧栏设置
**侧栏设置包括：侧栏位置、侧栏显示与否、文章间距、返回顶部按钮等等**

**打开```主题配置文件```找到```sidebar```字段**

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

---


### 主题风格 schemes

next有四种主题风格：我们把想要选择的取消注释，其他三个保持注释掉的状态即可。
```
# Schemes
#scheme: Muse
#scheme: Mist
scheme: Pisces
#scheme: Gemini

```
### 底部建站时间和图标修改```footer:```

- 把用户的图标从小人user改成了雪花snowflake-o
- copyright留空，显示成页面author即我的名字
- powered: false把hexo的授权图片取消了
- theme: enable:false 把主题的内容也取消了


### 网站动画效果

```
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

```

### 统计文章字数和阅读时间
```
# Post wordcount display settings
# Dependencies: https://github.com/willin/hexo-wordcount
post_wordcount:
  item_text: true
  wordcount: true  # 文章字数
  min2read: true   # 阅读时间
  totalcount: true  # 总共字数
  separated_meta: true
```

### 第三方插件

#### Hexo-admin
**Hexo-admin插件允许我们直接在本地页面上修改文章内容。**
- 下载```npm i hexo-admin --save ```
- 登录http://localhost:4000/admin即可看到我们所有的文章内容，并且在可视化界面中操作文章内容

### Next 主题添加站内搜索功能
- 安装 **hexo-generator-searchdb**, 站点根目录执行以下命令。

``` npm install hexo-generator-searchdb --save ```

---
- 在**站点配置文件中**配置文件中新增如下配置：
```
search:
    path: search.xml
    field: post
    format: html
    limit: 10000

```
---
- 在**主题配置文件**, 启用本地搜索功能即可。
```
# Local search
local_search:
    enable: true
```


