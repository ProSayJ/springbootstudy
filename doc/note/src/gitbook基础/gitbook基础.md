[超级好的教程](http://gitbook.zhangjikai.com/plugins.html)
[实用插件](https://www.cnblogs.com/zhangjk1993/p/5066771.html)
[Gitbook官网](https://www.gitbook.com/)
[Gitbook文档](https://github.com/GitbookIO/gitbook)
[Gitbook插件官网](https://plugins.gitbook.com/)
[Gitbook简明教程](http://www.chengweiyang.cn/gitbook/customize/book.json.html)

# 安装nodejs

# 安装 GitBook
``` javaScript

npm install -g gitbook-cli 

```

# 初始化gitbook项目
``` js
gitbook init
```

# 预览
``` js
gitbook serve

```

# 生成静态文件
```
gitbook build

```



# Gitbook的基本目录结构：
```
.
├── book.json
├── README.md
├── SUMMARY.md
├── chapter-1/
|   ├── README.md
|   └── something.md
└── chapter-2/
    ├── README.md
    └── something.md

```

# book.json文件主要用来存放配置信息，基本配置如下：


``` json
{
    "title": "文档标题",//
    "author": "ProSayJ",
    "description": "select * from learn",
    "language": "zh-hans",// "en"
    "gitbook": "3.2.3",
    "styles": {
        "website": "/styles/website.css"
    },
    "structure": {
        "readme": "README.md"
    },
    "links": {//在左侧导航栏添加链接信息
        "sidebar": {
            "Home" : "http://www.baidu.com"
        }
    },
    "plugins": [//配置使用的插件
        "-sharing",
        "splitter",
        "expandable-chapters-small",//收起或展开章节目录中的父节点。
        "anchors",

        "github",
        "github-buttons",
        "donate",
        "sharing-plus",
        "anchor-navigation-ex",
        "favicon"
    ],
    //配置插件的属性，默认带有 5 个插件：
    //highlight、search、sharing、font-settings、livereload，
    //如果要去除自带的插件， 可以在插件名称前面加 -。
    "pluginsConfig": {
        "github": {
            "url": "https://github.com/ProSayJ"
        },
        "github-buttons": {
            "buttons": [{
                "user": "ProSayJ",
                "repo": "glory",
                "type": "star",
                "size": "small",
                "count": true
                }
            ]
        },
        "donate": {
            "alipay": "xxx",
            "title": "",
            "button": "赞赏",
            "alipayText": " "
        },
        "sharing": {
            "douban": false,
            "facebook": false,
            "google": false,
            "hatenaBookmark": false,
            "instapaper": false,
            "line": false,
            "linkedin": false,
            "messenger": false,
            "pocket": false,
            "qq": false,
            "qzone": false,
            "stumbleupon": false,
            "twitter": false,
            "viber": false,
            "vk": false,
            "weibo": false,
            "whatsapp": false,
            "all": [
                "google", "facebook", "weibo", "twitter",
                "qq", "qzone", "linkedin", "pocket"
            ]
        },
        "anchor-navigation-ex": {
            "showLevel": false
        },
        "favicon":{
            "shortcut": "/source/images/favicon.jpg",
            "bookmark": "/source/images/favicon.jpg",
            "appleTouch": "/source/images/apple-touch-icon.jpg",
            "appleTouchMore": {
                "120x120": "/source/images/apple-touch-icon.jpg",
                "180x180": "/source/images/apple-touch-icon.jpg"
            }
        }
    }
}

```

# SUMMARY.md 文件

这个文件主要决定 GitBook 的章节目录，它通过 Markdown 中的列表语法来表示文件的父子关系。

# Gitbook配置目录折叠
 在执行gitbook init主目录下增加book.json文件做定制化配置:
 ``` json
 {
    "plugins":[
        "expandable-chapters"
    ]
}
 ```
 
然后在主目录下用命令行执行gitbook install，会生成node_modules文件夹，配置的插件也会自动下载到该目录下。

# 其他插件
除此之外，如果目录内容比较多，左边菜单栏显示不下，也可以使用插件来达到放大菜单栏宽度的目的

插件：在book.json中配置splitter，后续步骤与以上一致


## 在左侧导航栏添加链接信息
``` json

    "links" : {
        "sidebar" : {
            "Home" : "http://zhangjikai.com"
        }
    }
```

## 配置deom文件
``` json
{
  "title": "demo",//标题
  "description": "demo",//文档描述
  "language": "zh",//选择编辑的语言环境
  "plugins": [ //引入需要的插件，前面有-号的为uninstall相应的插件
    "disqus",
    "github",
    "editlink",
    "prism",
    "-highlight",
    "baidu",
    "splitter",//目录过长时可拖动查看
    "sitemap",
    "tbfed-pagefooter",
    "fontsettings",
    "simple-page-toc",
    "links"
  ],
  "styles": {
    "website": "styles/website.css" //引入css文件进行css样式的修改
  },
  "pluginsConfig": {
       "tbfed-pagefooter": {
            "copyright": "",
            "modify_label": "该文件修订时间：",
            "modify_format": "YYYY-MM-DD HH:mm:ss"
        },//显示文件的修改事件，包括一些版权声明
        "fontsettings": {
            "theme": "white",
            "family": "serif",
            "size": 12
        },//显示样式以及文字大小的主题
        "simple-page-toc": {
            "maxDepth": 3,
            "skipFirstH1": true
        },//<!-- toc -->中放置代码注释。生成GitBook以后，此评论会立即插入content
       //使用深度最多为maxdepth的标题。排除文件中的第一个h1级标题。
        "links": {
            "gitbook": false,
            "sharing": {
                "google": false,
                "facebook": false,
                "twitter": false,
                "all": false
        },//默认的一些分享的展示与隐藏，true为展示，false为隐藏
    "disqus": {
      "shortName": "webpack-handbook"//生成评论的插件
    },
    "github": {
      "url": "https://github.com/webChatContact/baas-v2-help"
    },
    "editlink": {
      "base": "https://github.com/webChatContact",
      "label": "编辑本页面"//内容顶部显示 编辑本页 链接。
    },
    "baidu": {
        "token": "a9787f0ab45d5e237bab522431d0a7ec"//使用百度统计。
    },
    "sitemap": {
        "hostname": "http://baidu.com/"//生成站点地图
    }
  }
}
```

``` json


```



你可以执行 gitbook build 命令构建书籍