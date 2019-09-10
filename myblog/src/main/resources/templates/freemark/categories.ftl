<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no,minimal-ui">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no,email=no,adress=no">
    <meta name="theme-color" content="#000000">
    <meta http-equiv="window-target" content="_top">
    <title>ProSay技术博客_分类</title>
    <meta name="description" content="ProSayJ技术博客，专注于 Java，Spring，MyBatis, Dubbo 以及其他分布式技术等">
    <meta property="og:type" content="website">
    <meta property="og:title" content="ProSayJ的技术博客_归档">
    <meta property="og:url" content="https://www.baidu.com">
    <meta property="og:site_name" content="ProSayJ的技术博客_归档">
    <meta property="og:description" content="ProSayJ技术博客，专注于 Java，Spring，MyBatis, Dubbo 以及其他分布式技术等">
    <meta name="twitter:card" content="summary">
    <meta name="twitter:title" content="ProSayJ技术博客_归档">
    <meta name="twitter:description" content="ProSayJ技术博客，专注于 Java，Spring，MyBatis, Dubbo 以及其他分布式技术等">
    <link rel="canonical" href="https://www.baidu.com">

    <link rel="icon" href="/static/skins/my/images/java.ico" type="image/x-icon">
    <link rel="stylesheet" href="/static/skins/my/css/style.css">
    <link rel="stylesheet" href="/static/skins/my/css/code.css">
</head>


<body class="main-center" itemscope="" itemtype="http://schema.org/WebPage">


<header class="header" itemscope="" itemtype="http://schema.org/WPHeader">
    <div class="slimContent">
        <div class="navbar-header">
            <div class="profile-block text-center">
                <a id="avatar" href="https://www.baidu.com/">
                    <img class="img-circle img-rotate" src="/static/skins/my/images/head.jpg" width="400" height="400">
                </a>

                <h2 id="name" class="hidden-xs hidden-sm">ProSayJ</h2>
                <h3 id="title" class="hidden-xs hidden-sm hidden-md">菜鸟程序员</h3>
                <small id="location" class="text-muted hidden-xs hidden-sm">
                    <i class="icon icon-map-marker "></i> BeiJing, China
                </small>
            </div>

            <div class="search" id="search-form-wrap">
                <form class="search-form sidebar-form">
                    <div class="input-group">
                        <input type="text" class="search-form-input form-control" placeholder="搜索">
                        <span class="input-group-btn">
                            <button type="submit" class="search-form-submit btn btn-flat" onclick="return!1">
                                <i class="icon icon-search"></i>
                            </button>
                        </span>
                    </div>
                </form>
            </div>


            <button class="navbar-toggle collapsed" type="button"
                    data-toggle="collapse" data-target="#main-navbar"
                    aria-controls="main-navbar" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <nav id="main-navbar" class="collapse navbar-collapse" itemscope=""
             itemtype="http://schema.org/SiteNavigationElement" role="navigation">
            <ul class="nav navbar-nav main-nav">
                <li class="menu-item menu-item-home">
                    <a href="https://www.tianxiaobo.com/">
                        <i class="icon icon-home-fill"></i>
                        <span class="menu-title">首页</span>
                    </a>
                </li>
                <li class="menu-item menu-item-archives">
                    <a href="https://www.tianxiaobo.com/archives">
                        <i class="icon icon-archives-fill"></i>
                        <span class="menu-title">归档</span>
                    </a>
                </li>
                <li class="menu-item menu-item-categories">
                    <a href="https://www.tianxiaobo.com/categories">
                        <i class="icon icon-folder"></i>
                        <span class="menu-title">分类</span>
                    </a>
                </li>
                <li class="menu-item menu-item-tags">
                    <a href="https://www.tianxiaobo.com/tags">
                        <i class="icon icon-tags"></i>
                        <span class="menu-title">标签</span>
                    </a>
                </li>
                <li class="menu-item menu-item-repository">
                    <a href="https://www.tianxiaobo.com/repository">
                        <i class="icon icon-project"></i>
                        <span class="menu-title">项目</span>
                    </a>
                </li>
                <li class="menu-item menu-item-links">
                    <a href="https://www.tianxiaobo.com/links">
                        <i class="icon icon-friendship"></i>
                        <span class="menu-title">友链</span>
                    </a>
                </li>
                <li class="menu-item menu-item-about">
                    <a href="https://www.tianxiaobo.com/about">
                        <i class="icon icon-cup-fill"></i>
                        <span class="menu-title">关于</span>
                    </a>
                </li>
            </ul>
            <ul class="social-links">
                <li>
                    <a href="https://github.com/code4wt" target="_blank" title=""
                       data-toggle="tooltip" data-placement="top" data-original-title="Github">
                        <i class="icon icon-github"></i>
                    </a>
                </li>
                <li><a href="https://segmentfault.com/u/code4fun" target="_blank" title=""
                       data-toggle="tooltip" data-placement="top" data-original-title="Segmentfault">
                        <i class="icon icon-segmentfault"></i>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<#--页面右边bar-->
<aside class="sidebar" itemscope="" itemtype="http://schema.org/WPSideBar">
    <#--目前来看没有什么用-->
    <div class="slimScrollDiv">
        <#--<div class="slimScrollDiv" style="position: relative; overflow: visible; width: auto; height: 722px;">-->
        <div class="slimScrollBar"
             style="background: rgba(0, 0, 0, 0.2); width: 3px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 189.282px;"></div>
        <div class="slimScrollRail"
             style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div>
    </div>


    <div class="slimContent">
        <#--<div class="slimContent" style="overflow-y:auto; overflow-x:hidden; width:auto; height:922px;">-->
        <div class="widget"><h3 class="widget-title">公告</h3>
            <div class="widget-body">
                <div id="board"><p>您好，您是第<span id="busuanzi_value_site_uv">56990</span>位访客</p>
                    <div class="content"><p>欢迎访问田小波的技术博客</p></div>
                </div>
            </div>
        </div>
        <style>.category-list-child {
                margin-left: 30px !important
            }
        </style>
        <div class="widget"><h3 class="widget-title">分类</h3>
            <div class="widget-body">
                <ul class="category-list">
                    <li class="category-list-item"><a class="category-list-link"
                                                      href="https://www.tianxiaobo.com/categories/foundation-of-java/">
                            Java基础</a><span class="category-list-count">19</span>
                        <ul class="category-list-child">
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/foundation-of-java/java-tittle-tattle/">Java杂谈</a><span
                                        class="category-list-count">1</span></li>
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/foundation-of-java/NIO/">NIO</a><span
                                        class="category-list-count">7</span></li>
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/foundation-of-java/concurrent/">并发</a><span
                                        class="category-list-count">6</span></li>
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/foundation-of-java/collection/">集合框架</a><span
                                        class="category-list-count">5</span></li>
                        </ul>
                    </li>
                    <li class="category-list-item"><a class="category-list-link"
                                                      href="https://www.tianxiaobo.com/categories/java-framework/">
                            Java框架</a><span class="category-list-count">33</span>
                        <ul class="category-list-child">
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/java-framework/dubbo/">Dubbo</a><span
                                        class="category-list-count">9</span></li>
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/java-framework/mybatis/">MyBatis</a><span
                                        class="category-list-count">8</span></li>
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/java-framework/spring/">Spring</a><span
                                        class="category-list-count">16</span></li>
                        </ul>
                    </li>
                    <li class="category-list-item"><a class="category-list-link"
                                                      href="https://www.tianxiaobo.com/categories/middleware/">
                            中间件</a><span class="category-list-count">2</span>
                        <ul class="category-list-child">
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/middleware/zookeeper/">Zookeeper</a><span
                                        class="category-list-count">1</span></li>
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/middleware/%E9%99%90%E6%B5%81%E7%BB%84%E4%BB%B6/">限流组件</a><span
                                        class="category-list-count">1</span></li>
                        </ul>
                    </li>
                    <li class="category-list-item"><a class="category-list-link"
                                                      href="https://www.tianxiaobo.com/categories/basic-algorithm/">
                            基础算法</a><span class="category-list-count">1</span>
                        <ul class="category-list-child">
                            <li class="category-list-item"><a class="category-list-link"
                                                              href="https://www.tianxiaobo.com/categories/basic-algorithm/search/">查找</a><span
                                        class="category-list-count">1</span></li>
                        </ul>
                    </li>
                    <li class="category-list-item"><a class="category-list-link"
                                                      href="https://www.tianxiaobo.com/categories/tittle-tattle/">
                            杂谈</a><span class="category-list-count">2</span></li>
                </ul>
            </div>
            <script src="/static/skins/my/js/hm.js"></script>
            <script src="/static/skins/my/js/jquery.min.js"></script>
            <script>var items = $(".category-list-link");
                items.each(function () {
                    var t = $(this), i = t.parent().parent();
                    if (!i.hasClass("category-list-child")) {
                        var a = $(this).text();
                        $(this).text("ø " + a)
                    }
                })</script>
        </div>

        <div class="widget"><h3 class="widget-title">标签</h3>
            <div class="widget-body">
                <ul class="tag-list">
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/AQS/">AQS</a><span
                                class="tag-list-count">4</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/ArrayList/">ArrayList</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/AtomicInteger/">AtomicInteger</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/Buffer/">Buffer</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/CAS/">CAS</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/Condition/">Condition</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/CountDownLatch/">CountDownLatch</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/CyclicBarrier/">CyclicBarrier</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/Dubbo/">Dubbo</a><span
                                class="tag-list-count">9</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/HTTP/">HTTP</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/HashMap/">HashMap</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/IO%E6%A8%A1%E5%9E%8B/">IO模型</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/JSON/">JSON</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/Java/">Java</a><span
                                class="tag-list-count">49</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/LinkedHashMap/">LinkedHashMap</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/LinkedList/">LinkedList</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/MyBatis/">MyBatis</a><span
                                class="tag-list-count">8</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/NIO/">NIO</a><span
                                class="tag-list-count">7</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/ReentrantLock/">ReentrantLock</a><span
                                class="tag-list-count">2</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/Server/">Server</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/Spring/">Spring</a><span
                                class="tag-list-count">16</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/String/">String</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/Zookeeper/">Zookeeper</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/channel/">channel</a><span
                                class="tag-list-count">2</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/epoll/">epoll</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/filechannel/">filechannel</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/hashCode/">hashCode</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/httpd/">httpd</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/lock/">lock</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/selector/">selector</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/socket/">socket</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/socketchannel/">socketchannel</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E4%B8%AD%E9%97%B4%E4%BB%B6/">中间件</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E5%88%86%E5%B8%83%E5%BC%8F/">分布式</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E5%A4%9A%E8%B7%AF%E5%A4%8D%E7%94%A8/">多路复用</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E5%B9%B6%E5%8F%91/">并发</a><span
                                class="tag-list-count">4</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84/">数据结构</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E6%A1%86%E6%9E%B6/">框架</a><span
                                class="tag-list-count">33</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E7%88%AC%E8%99%AB/">爬虫</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E7%AE%97%E6%B3%95/">算法</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E7%BA%A2%E9%BB%91%E6%A0%91/">红黑树</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E7%BA%BF%E7%A8%8B%E6%B1%A0/">线程池</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E8%A7%A3%E6%9E%90%E5%99%A8/">解析器</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E9%94%81/">锁</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E9%99%90%E6%B5%81/">限流</a><span
                                class="tag-list-count">1</span></li>
                    <li class="tag-list-item"><a class="tag-list-link"
                                                 href="https://www.tianxiaobo.com/tags/%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6/">集合框架</a><span
                                class="tag-list-count">5</span></li>
                </ul>
            </div>
        </div>

        <div class="widget"><h3 class="widget-title">标签云</h3>
            <div class="widget-body tagcloud"><a href="https://www.tianxiaobo.com/tags/AQS/"
                                                 style="font-size:13.22px">AQS</a> <a
                        href="https://www.tianxiaobo.com/tags/ArrayList/" style="font-size:13px">ArrayList</a>
                <a
                        href="https://www.tianxiaobo.com/tags/AtomicInteger/"
                        style="font-size:13px">AtomicInteger</a>
                <a href="https://www.tianxiaobo.com/tags/Buffer/" style="font-size:13px">Buffer</a> <a
                        href="https://www.tianxiaobo.com/tags/CAS/" style="font-size:13px">CAS</a> <a
                        href="https://www.tianxiaobo.com/tags/Condition/" style="font-size:13px">Condition</a>
                <a
                        href="https://www.tianxiaobo.com/tags/CountDownLatch/"
                        style="font-size:13px">CountDownLatch</a> <a
                        href="https://www.tianxiaobo.com/tags/CyclicBarrier/"
                        style="font-size:13px">CyclicBarrier</a> <a
                        href="https://www.tianxiaobo.com/tags/Dubbo/"
                        style="font-size:13.67px">Dubbo</a> <a
                        href="https://www.tianxiaobo.com/tags/HTTP/" style="font-size:13px">HTTP</a> <a
                        href="https://www.tianxiaobo.com/tags/HashMap/" style="font-size:13px">HashMap</a> <a
                        href="https://www.tianxiaobo.com/tags/IO%E6%A8%A1%E5%9E%8B/"
                        style="font-size:13px">IO模型</a>
                <a href="https://www.tianxiaobo.com/tags/JSON/" style="font-size:13px">JSON</a> <a
                        href="https://www.tianxiaobo.com/tags/Java/" style="font-size:14px">Java</a> <a
                        href="https://www.tianxiaobo.com/tags/LinkedHashMap/"
                        style="font-size:13px">LinkedHashMap</a> <a
                        href="https://www.tianxiaobo.com/tags/LinkedList/" style="font-size:13px">LinkedList</a>
                <a
                        href="https://www.tianxiaobo.com/tags/MyBatis/" style="font-size:13.56px">MyBatis</a> <a
                        href="https://www.tianxiaobo.com/tags/NIO/" style="font-size:13.44px">NIO</a> <a
                        href="https://www.tianxiaobo.com/tags/ReentrantLock/"
                        style="font-size:13.11px">ReentrantLock</a>
                <a href="https://www.tianxiaobo.com/tags/Server/" style="font-size:13px">Server</a> <a
                        href="https://www.tianxiaobo.com/tags/Spring/" style="font-size:13.78px">Spring</a> <a
                        href="https://www.tianxiaobo.com/tags/String/" style="font-size:13px">String</a> <a
                        href="https://www.tianxiaobo.com/tags/Zookeeper/" style="font-size:13px">Zookeeper</a>
                <a
                        href="https://www.tianxiaobo.com/tags/channel/" style="font-size:13.11px">channel</a> <a
                        href="https://www.tianxiaobo.com/tags/epoll/" style="font-size:13px">epoll</a> <a
                        href="https://www.tianxiaobo.com/tags/filechannel/"
                        style="font-size:13px">filechannel</a>
                <a href="https://www.tianxiaobo.com/tags/hashCode/" style="font-size:13px">hashCode</a> <a
                        href="https://www.tianxiaobo.com/tags/httpd/" style="font-size:13px">httpd</a> <a
                        href="https://www.tianxiaobo.com/tags/lock/" style="font-size:13px">lock</a> <a
                        href="https://www.tianxiaobo.com/tags/selector/" style="font-size:13px">selector</a> <a
                        href="https://www.tianxiaobo.com/tags/socket/" style="font-size:13px">socket</a> <a
                        href="https://www.tianxiaobo.com/tags/socketchannel/"
                        style="font-size:13px">socketchannel</a> <a
                        href="https://www.tianxiaobo.com/tags/%E4%B8%AD%E9%97%B4%E4%BB%B6/"
                        style="font-size:13px">中间件</a>
                <a href="https://www.tianxiaobo.com/tags/%E5%88%86%E5%B8%83%E5%BC%8F/"
                   style="font-size:13px">分布式</a> <a
                        href="https://www.tianxiaobo.com/tags/%E5%A4%9A%E8%B7%AF%E5%A4%8D%E7%94%A8/"
                        style="font-size:13px">多路复用</a> <a
                        href="https://www.tianxiaobo.com/tags/%E5%B9%B6%E5%8F%91/"
                        style="font-size:13.22px">并发</a>
                <a href="https://www.tianxiaobo.com/tags/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84/"
                   style="font-size:13px">数据结构</a> <a href="https://www.tianxiaobo.com/tags/%E6%A1%86%E6%9E%B6/"
                                                      style="font-size:13.89px">框架</a> <a
                        href="https://www.tianxiaobo.com/tags/%E7%88%AC%E8%99%AB/" style="font-size:13px">爬虫</a>
                <a
                        href="https://www.tianxiaobo.com/tags/%E7%AE%97%E6%B3%95/" style="font-size:13px">算法</a>
                <a
                        href="https://www.tianxiaobo.com/tags/%E7%BA%A2%E9%BB%91%E6%A0%91/"
                        style="font-size:13px">红黑树</a>
                <a href="https://www.tianxiaobo.com/tags/%E7%BA%BF%E7%A8%8B%E6%B1%A0/"
                   style="font-size:13px">线程池</a> <a
                        href="https://www.tianxiaobo.com/tags/%E8%A7%A3%E6%9E%90%E5%99%A8/"
                        style="font-size:13px">解析器</a>
                <a href="https://www.tianxiaobo.com/tags/%E9%94%81/" style="font-size:13px">锁</a> <a
                        href="https://www.tianxiaobo.com/tags/%E9%99%90%E6%B5%81/" style="font-size:13px">限流</a>
                <a
                        href="https://www.tianxiaobo.com/tags/%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6/"
                        style="font-size:13.33px">集合框架</a></div>
        </div>

        <div class="widget"><h3 class="widget-title">归档</h3>
            <div class="widget-body">
                <ul class="archive-list">
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2019/05/">May
                            2019</a><span class="archive-list-count">1</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2019/01/">January
                            2019</a><span class="archive-list-count">1</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/11/">November
                            2018</a><span class="archive-list-count">5</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/10/">October
                            2018</a><span class="archive-list-count">3</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/09/">September
                            2018</a><span class="archive-list-count">1</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/08/">August
                            2018</a><span class="archive-list-count">4</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/07/">July
                            2018</a><span class="archive-list-count">3</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/06/">June
                            2018</a><span class="archive-list-count">12</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/05/">May
                            2018</a><span class="archive-list-count">6</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/04/">April
                            2018</a><span class="archive-list-count">3</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/03/">March
                            2018</a><span class="archive-list-count">4</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/02/">February
                            2018</a><span class="archive-list-count">1</span></li>
                    <li class="archive-list-item"><a class="archive-list-link"
                                                     href="https://www.tianxiaobo.com/archives/2018/01/">January
                            2018</a><span class="archive-list-count">13</span></li>
                </ul>
            </div>
        </div>

        <div class="widget"><h3 class="widget-title">最新文章</h3>
            <div class="widget-body">
                <ul class="recent-post-list list-unstyled no-thumbnail">
                    <li>
                        <div class="item-inner"><p class="item-category"><a class="category-link"
                                                                            href="https://www.tianxiaobo.com/categories/middleware/">中间件</a><i
                                        class="icon icon-angle-right"></i><a class="category-link"
                                                                             href="https://www.tianxiaobo.com/categories/middleware/%E9%99%90%E6%B5%81%E7%BB%84%E4%BB%B6/">限流组件</a>
                            </p>
                            <p class="item-title"><a
                                        href="https://www.tianxiaobo.com/2019/05/18/%E7%AE%80%E6%9E%90%E9%99%90%E6%B5%81%E7%AE%97%E6%B3%95/"
                                        class="title">简析限流算法</a></p>
                            <p class="item-date">
                                <time datetime="2019-05-18T12:30:48.000Z" itemprop="datePublished">2019-05-18
                                </time>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="item-inner"><p class="item-category"><a class="category-link"
                                                                            href="https://www.tianxiaobo.com/categories/java-framework/">Java框架</a><i
                                        class="icon icon-angle-right"></i><a class="category-link"
                                                                             href="https://www.tianxiaobo.com/categories/java-framework/dubbo/">Dubbo</a>
                            </p>
                            <p class="item-title"><a
                                        href="https://www.tianxiaobo.com/2019/01/09/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%9C%8D%E5%8A%A1%E8%B0%83%E7%94%A8%E8%BF%87%E7%A8%8B/"
                                        class="title">Dubbo 源码分析 - 服务调用过程</a></p>
                            <p class="item-date">
                                <time datetime="2019-01-09T00:26:05.000Z" itemprop="datePublished">2019-01-09
                                </time>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="item-inner"><p class="item-category"><a class="category-link"
                                                                            href="https://www.tianxiaobo.com/categories/java-framework/">Java框架</a><i
                                        class="icon icon-angle-right"></i><a class="category-link"
                                                                             href="https://www.tianxiaobo.com/categories/java-framework/dubbo/">Dubbo</a>
                            </p>
                            <p class="item-title"><a
                                        href="https://www.tianxiaobo.com/2018/11/29/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E9%9B%86%E7%BE%A4%E5%AE%B9%E9%94%99%E4%B9%8B-LoadBalance/"
                                        class="title">Dubbo 源码分析 - 集群容错之 LoadBalance</a></p>
                            <p class="item-date">
                                <time datetime="2018-11-29T15:24:03.000Z" itemprop="datePublished">2018-11-29
                                </time>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="item-inner"><p class="item-category"><a class="category-link"
                                                                            href="https://www.tianxiaobo.com/categories/java-framework/">Java框架</a><i
                                        class="icon icon-angle-right"></i><a class="category-link"
                                                                             href="https://www.tianxiaobo.com/categories/java-framework/dubbo/">Dubbo</a>
                            </p>
                            <p class="item-title"><a
                                        href="https://www.tianxiaobo.com/2018/11/24/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E9%9B%86%E7%BE%A4%E5%AE%B9%E9%94%99%E4%B9%8B-Cluster/"
                                        class="title">Dubbo 源码分析 - 集群容错之 Cluster</a></p>
                            <p class="item-date">
                                <time datetime="2018-11-24T15:31:42.000Z" itemprop="datePublished">2018-11-24
                                </time>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="item-inner"><p class="item-category"><a class="category-link"
                                                                            href="https://www.tianxiaobo.com/categories/java-framework/">Java框架</a><i
                                        class="icon icon-angle-right"></i><a class="category-link"
                                                                             href="https://www.tianxiaobo.com/categories/java-framework/dubbo/">Dubbo</a>
                            </p>
                            <p class="item-title"><a
                                        href="https://www.tianxiaobo.com/2018/11/20/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E9%9B%86%E7%BE%A4%E5%AE%B9%E9%94%99%E4%B9%8B-Router/"
                                        class="title">Dubbo 源码分析 - 集群容错之 Router</a></p>
                            <p class="item-date">
                                <time datetime="2018-11-20T12:34:57.000Z" itemprop="datePublished">2018-11-20
                                </time>
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</aside>


<#--正文区域-->
<main class="main" role="main">
    <article class="article article-categories article-type-list" itemscope="">

        <header class="article-header"><h1 itemprop="name" class="hidden-xs">分类</h1>
            <p class="text-muted hidden-xs">共 15 个分类</p>
            <nav role="navigation" id="nav-main" class="okayNav loaded">
                <ul class="okayNav__nav--visible">
                    <li><a href="https://www.tianxiaobo.com/categories">All</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/foundation-of-java/">Java基础</a></li>
                    <li>
                        <a href="https://www.tianxiaobo.com/categories/foundation-of-java/java-tittle-tattle/">Java杂谈</a>
                    </li>
                    <li><a href="https://www.tianxiaobo.com/categories/foundation-of-java/NIO/">NIO</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/foundation-of-java/concurrent/">并发</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/foundation-of-java/collection/">集合框架</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/java-framework/">Java框架</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/java-framework/dubbo/">Dubbo</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/java-framework/mybatis/">MyBatis</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/java-framework/spring/">Spring</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/middleware/">中间件</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/middleware/zookeeper/">Zookeeper</a></li>
                    <li>
                        <a href="https://www.tianxiaobo.com/categories/middleware/%E9%99%90%E6%B5%81%E7%BB%84%E4%BB%B6/">限流组件</a>
                    </li>
                    <li><a href="https://www.tianxiaobo.com/categories/basic-algorithm/">基础算法</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/basic-algorithm/search/">查找</a></li>
                    <li><a href="https://www.tianxiaobo.com/categories/tittle-tattle/">杂谈</a></li>
                </ul>
                <ul class="okayNav__nav--invisible transition-enabled nav-right" style=""></ul>
                <a href="https://www.tianxiaobo.com/categories/#"
                   class="okayNav__menu-toggle okay-invisible"><span></span><span></span><span></span></a>
            </nav>
        </header>

        <div class="article-body">
            <div class="panel panel-default b-no">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title">
                        <a data-toggle="collapse"
                           href="https://www.tianxiaobo.com/categories/#collapseJava%E5%9F%BA%E7%A1%80"
                           aria-expanded="true">
                            <i class="icon icon-folder text-active"></i>
                            <i class="icon icon-folder-open text"></i> Java基础
                        </a>
                        <small class="text-muted">(Total 19 articles)</small>
                    </h3>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title">
                        <a data-toggle="collapse"
                           href="https://www.tianxiaobo.com/categories/#collapseJava%E6%9D%82%E8%B0%88"
                           aria-expanded="true">
                            <i class="icon icon-folder text-active"></i>
                            <i class="icon icon-folder-open text"></i> Java杂谈
                        </a>
                        <small class="text-muted">(Total 1 articles)</small>
                    </h3>
                </div>

                <div id="collapseJava杂谈" class="panel-collapse collapse in" role="tabpanel"
                     aria-labelledby="headingJava杂谈">
                    <div class="panel-body">
                        <div class="collection">
                            <a href="https://www.tianxiaobo.com/2018/01/18/String-hashCode-"
                               class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-18T15:12:51.000Z" itemprop="datePublished">2018-01-18</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> String hashCode 方法为什么选择数字31作为乘子
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">

                <div class="panel-heading" role="tab">
                    <h3 class="panel-title">
                        <a data-toggle="collapse" href="https://www.tianxiaobo.com/categories/#collapseNIO"
                           aria-expanded="true">
                            <i class="icon icon-folder text-active"></i>
                            <i class="icon icon-folder-open text"></i> NIO
                        </a>
                        <small class="text-muted">(Total 7 articles)</small>
                    </h3>
                </div>

                <div id="collapseNIO" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingNIO">
                    <div class="panel-body">
                        <div class="collection">
                            <a href="https://www.tianxiaobo.com/2018/04/04/" class="collection-item" target="_blank"
                               itemprop="url">
                                <time datetime="2018-04-04T12:59:49.000Z" itemprop="datePublished">2018-04-04</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> 基于 Java NIO 实现简单的 HTTP 服务器
                            </a>

                            <a href="https://www.tianxiaobo.com/2018/04/03/Java-NIO" class="collection-item"
                               target="_blank" itemprop="url">
                                <time datetime="2018-04-03T12:33:34.000Z" itemprop="datePublished">2018-04-03</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Java NIO之选择器
                            </a>

                            <a href="https://www.tianxiaobo.com/2018/03/25/Java-NIO" class="collection-item"
                               target="_blank" itemprop="url">
                                <time datetime="2018-03-24T17:23:16.000Z" itemprop="datePublished">2018-03-25</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Java NIO之套接字通道
                            </a>

                            <a href="https://www.tianxiaobo.com/2018/03/24/JAVA-NIO" class="collection-item"
                               target="_blank" itemprop="url">
                                <time datetime="2018-03-23T16:15:09.000Z" itemprop="datePublished">2018-03-24</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> JAVA NIO之文件通道
                            </a>

                            <a href="https://www.tianxiaobo.com/2018/03/04/Java-NIO" class="collection-item"
                               target="_blank" itemprop="url">
                                <time datetime="2018-03-04T06:04:39.000Z" itemprop="datePublished">2018-03-04</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Java NIO之缓冲区
                            </a>

                            <a href="https://www.tianxiaobo.com/2018/03/02/" class="collection-item" target="_blank"
                               itemprop="url">
                                <time datetime="2018-03-02T05:52:35.000Z" itemprop="datePublished">2018-03-02</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> 基于epoll实现简单的web服务器
                            </a>

                            <a href="https://www.tianxiaobo.com/2018/02/08/IO" class="collection-item" target="_blank"
                               itemprop="url">
                                <time datetime="2018-02-08T14:06:13.000Z" itemprop="datePublished">2018-02-08</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> I/O模型简述
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapse%E5%B9%B6%E5%8F%91"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> 并发 </a>
                        <small class="text-muted">(Total 6 articles)</small>
                    </h3>
                </div>
                <div id="collapse并发" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading并发">
                    <div class="panel-body">
                        <div class="collection"><a
                                    href="https://www.tianxiaobo.com/2018/05/15/Java-%E4%B8%AD%E7%9A%84-CAS-%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-05-14T17:06:09.000Z" itemprop="datePublished">2018-05-15</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Java CAS 原理分析</a> <a
                                    href="https://www.tianxiaobo.com/2018/05/10/Java-%E7%BA%BF%E7%A8%8B%E5%90%8C%E6%AD%A5%E7%BB%84%E4%BB%B6-CountDownLatch-%E4%B8%8E-CyclicBarrier-%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-05-10T06:17:22.000Z" itemprop="datePublished">2018-05-10</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Java 线程同步组件 CountDownLatch 与 CyclicBarrier 原理分析</a> <a
                                    href="https://www.tianxiaobo.com/2018/05/07/Java-%E9%87%8D%E5%85%A5%E9%94%81-ReentrantLock-%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-05-07T10:17:10.000Z" itemprop="datePublished">2018-05-07</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Java 重入锁 ReentrantLock 原理分析</a> <a
                                    href="https://www.tianxiaobo.com/2018/05/04/AbstractQueuedSynchronizer-%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90-Condition-%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-05-04T10:33:57.000Z" itemprop="datePublished">2018-05-04</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> AbstractQueuedSynchronizer 原理分析 - Condition 实现原理</a> <a
                                    href="https://www.tianxiaobo.com/2018/05/01/AbstractQueuedSynchronizer-%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90-%E7%8B%AC%E5%8D%A0-%E5%85%B1%E4%BA%AB%E6%A8%A1%E5%BC%8F/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-05-01T07:05:03.000Z" itemprop="datePublished">2018-05-01</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> AbstractQueuedSynchronizer 原理分析 - 独占/共享模式</a> <a
                                    href="https://www.tianxiaobo.com/2018/04/17/Java-%E7%BA%BF%E7%A8%8B%E6%B1%A0%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-04-17T12:55:22.000Z" itemprop="datePublished">2018-04-17</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Java 线程池原理分析</a></div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapse%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> 集合框架 </a>
                        <small class="text-muted">(Total 5 articles)</small>
                    </h3>
                </div>
                <div id="collapse集合框架" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading集合框架">
                    <div class="panel-body">
                        <div class="collection"><a
                                    href="https://www.tianxiaobo.com/2018/01/31/LinkedList-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-JDK-1-8/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-31T00:27:52.000Z" itemprop="datePublished">2018-01-31</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> LinkedList 源码分析(JDK 1.8)</a> <a
                                    href="https://www.tianxiaobo.com/2018/01/28/ArrayList%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-28T06:42:56.000Z" itemprop="datePublished">2018-01-28</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> ArrayList 源码分析</a> <a
                                    href="https://www.tianxiaobo.com/2018/01/24/LinkedHashMap-%E6%BA%90%E7%A0%81%E8%AF%A6%E7%BB%86%E5%88%86%E6%9E%90%EF%BC%88JDK1-8%EF%BC%89/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-24T01:33:41.000Z" itemprop="datePublished">2018-01-24</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> LinkedHashMap 源码详细分析（JDK1.8）</a> <a
                                    href="https://www.tianxiaobo.com/2018/01/18/HashMap-%E6%BA%90%E7%A0%81%E8%AF%A6%E7%BB%86%E5%88%86%E6%9E%90-JDK1-8/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-18T07:13:35.000Z" itemprop="datePublished">2018-01-18</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> HashMap 源码详细分析(JDK1.8)</a> <a
                                    href="https://www.tianxiaobo.com/2018/01/11/TreeMap%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-11T15:29:32.000Z" itemprop="datePublished">2018-01-11</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> TreeMap源码分析</a></div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapseJava%E6%A1%86%E6%9E%B6"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> Java框架 </a>
                        <small class="text-muted">(Total 33 articles)</small>
                    </h3>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapseDubbo"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> Dubbo </a>
                        <small class="text-muted">(Total 9 articles)</small>
                    </h3>
                </div>
                <div id="collapseDubbo" class="panel-collapse collapse in" role="tabpanel"
                     aria-labelledby="headingDubbo">
                    <div class="panel-body">
                        <div class="collection"><a
                                    href="https://www.tianxiaobo.com/2019/01/09/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%9C%8D%E5%8A%A1%E8%B0%83%E7%94%A8%E8%BF%87%E7%A8%8B/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2019-01-09T00:26:05.000Z" itemprop="datePublished">2019-01-09</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - 服务调用过程</a> <a
                                    href="https://www.tianxiaobo.com/2018/11/29/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E9%9B%86%E7%BE%A4%E5%AE%B9%E9%94%99%E4%B9%8B-LoadBalance/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-11-29T15:24:03.000Z" itemprop="datePublished">2018-11-29</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - 集群容错之 LoadBalance</a> <a
                                    href="https://www.tianxiaobo.com/2018/11/24/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E9%9B%86%E7%BE%A4%E5%AE%B9%E9%94%99%E4%B9%8B-Cluster/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-11-24T15:31:42.000Z" itemprop="datePublished">2018-11-24</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - 集群容错之 Cluster</a> <a
                                    href="https://www.tianxiaobo.com/2018/11/20/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E9%9B%86%E7%BE%A4%E5%AE%B9%E9%94%99%E4%B9%8B-Router/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-11-20T12:34:57.000Z" itemprop="datePublished">2018-11-20</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - 集群容错之 Router</a> <a
                                    href="https://www.tianxiaobo.com/2018/11/17/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E9%9B%86%E7%BE%A4%E5%AE%B9%E9%94%99%E4%B9%8BDirectory/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-11-17T15:05:05.000Z" itemprop="datePublished">2018-11-17</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - 集群容错之Directory</a> <a
                                    href="https://www.tianxiaobo.com/2018/11/12/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%9C%8D%E5%8A%A1%E5%BC%95%E7%94%A8/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-11-12T05:43:14.000Z" itemprop="datePublished">2018-11-12</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - 服务引用</a> <a
                                    href="https://www.tianxiaobo.com/2018/10/31/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%9C%8D%E5%8A%A1%E5%AF%BC%E5%87%BA/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-10-31T14:23:57.000Z" itemprop="datePublished">2018-10-31</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - 服务导出</a> <a
                                    href="https://www.tianxiaobo.com/2018/10/13/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E8%87%AA%E9%80%82%E5%BA%94%E6%8B%93%E5%B1%95%E5%8E%9F%E7%90%86/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-10-13T15:34:27.000Z" itemprop="datePublished">2018-10-13</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - 自适应拓展原理</a> <a
                                    href="https://www.tianxiaobo.com/2018/10/01/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-SPI-%E6%9C%BA%E5%88%B6/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-10-01T13:12:47.000Z" itemprop="datePublished">2018-10-01</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Dubbo 源码分析 - SPI 机制</a></div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapseMyBatis"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> MyBatis </a>
                        <small class="text-muted">(Total 8 articles)</small>
                    </h3>
                </div>
                <div id="collapseMyBatis" class="panel-collapse collapse in" role="tabpanel"
                     aria-labelledby="headingMyBatis">
                    <div class="panel-body">
                        <div class="collection"><a
                                    href="https://www.tianxiaobo.com/2018/09/09/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90%E7%B3%BB%E5%88%97%E6%96%87%E7%AB%A0%E5%90%88%E9%9B%86/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-09-09T14:05:15.000Z" itemprop="datePublished">2018-09-09</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> MyBatis 源码分析系列文章合集</a> <a
                                    href="https://www.tianxiaobo.com/2018/08/26/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%8F%92%E4%BB%B6%E6%9C%BA%E5%88%B6/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-08-26T15:01:29.000Z" itemprop="datePublished">2018-08-26</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> MyBatis 源码分析 - 插件机制</a> <a
                                    href="https://www.tianxiaobo.com/2018/08/25/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E7%BC%93%E5%AD%98%E5%8E%9F%E7%90%86/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-08-25T05:51:05.000Z" itemprop="datePublished">2018-08-25</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> MyBatis 源码分析 - 缓存原理</a> <a
                                    href="https://www.tianxiaobo.com/2018/08/19/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E5%86%85%E7%BD%AE%E6%95%B0%E6%8D%AE%E6%BA%90/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-08-19T07:38:21.000Z" itemprop="datePublished">2018-08-19</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> MyBatis 源码分析 - 内置数据源</a> <a
                                    href="https://www.tianxiaobo.com/2018/08/17/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-SQL-%E7%9A%84%E6%89%A7%E8%A1%8C%E8%BF%87%E7%A8%8B/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-08-17T03:47:34.000Z" itemprop="datePublished">2018-08-17</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> MyBatis 源码分析 - SQL 的执行过程</a> <a
                                    href="https://www.tianxiaobo.com/2018/07/30/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%98%A0%E5%B0%84%E6%96%87%E4%BB%B6%E8%A7%A3%E6%9E%90%E8%BF%87%E7%A8%8B/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-07-30T00:06:25.000Z" itemprop="datePublished">2018-07-30</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> MyBatis 源码分析 - 映射文件解析过程</a> <a
                                    href="https://www.tianxiaobo.com/2018/07/20/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E8%A7%A3%E6%9E%90%E8%BF%87%E7%A8%8B/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-07-20T14:08:24.000Z" itemprop="datePublished">2018-07-20</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> MyBatis 源码分析 - 配置文件解析过程</a> <a
                                    href="https://www.tianxiaobo.com/2018/07/16/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90%E7%B3%BB%E5%88%97%E6%96%87%E7%AB%A0%E5%AF%BC%E8%AF%BB/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-07-16T11:33:52.000Z" itemprop="datePublished">2018-07-16</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> MyBatis 源码分析系列文章导读</a></div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapseSpring"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> Spring </a>
                        <small class="text-muted">(Total 16 articles)</small>
                    </h3>
                </div>
                <div id="collapseSpring" class="panel-collapse collapse in" role="tabpanel"
                     aria-labelledby="headingSpring">
                    <div class="panel-body">
                        <div class="collection"><a
                                    href="https://www.tianxiaobo.com/2018/06/30/Spring-MVC-%E5%8E%9F%E7%90%86%E6%8E%A2%E7%A7%98-%E5%AE%B9%E5%99%A8%E7%9A%84%E5%88%9B%E5%BB%BA%E8%BF%87%E7%A8%8B/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-30T15:22:45.000Z" itemprop="datePublished">2018-06-30</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring MVC 原理探秘 - 容器的创建过程</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/29/Spring-MVC-%E5%8E%9F%E7%90%86%E6%8E%A2%E7%A7%98-%E4%B8%80%E4%B8%AA%E8%AF%B7%E6%B1%82%E7%9A%84%E6%97%85%E8%A1%8C%E8%BF%87%E7%A8%8B/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-29T14:32:58.000Z" itemprop="datePublished">2018-06-29</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring MVC 原理探秘 - 一个请求的旅行过程</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/22/Spring-AOP-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%8B%A6%E6%88%AA%E5%99%A8%E9%93%BE%E7%9A%84%E6%89%A7%E8%A1%8C%E8%BF%87%E7%A8%8B/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-22T08:53:33.000Z" itemprop="datePublished">2018-06-22</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring AOP 源码分析 - 拦截器链的执行过程</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/20/Spring-AOP-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E5%88%9B%E5%BB%BA%E4%BB%A3%E7%90%86%E5%AF%B9%E8%B1%A1/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-20T15:39:24.000Z" itemprop="datePublished">2018-06-20</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring AOP 源码分析 - 创建代理对象</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/20/Spring-AOP-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E7%AD%9B%E9%80%89%E5%90%88%E9%80%82%E7%9A%84%E9%80%9A%E7%9F%A5%E5%99%A8/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-19T16:11:36.000Z" itemprop="datePublished">2018-06-20</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring AOP 源码分析 - 筛选合适的通知器</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/17/Spring-AOP-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90%E7%B3%BB%E5%88%97%E6%96%87%E7%AB%A0%E5%AF%BC%E8%AF%BB/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-17T08:38:13.000Z" itemprop="datePublished">2018-06-17</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring AOP 源码分析系列文章导读</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/11/Spring-IOC-%E5%AE%B9%E5%99%A8%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E4%BD%99%E4%B8%8B%E7%9A%84%E5%88%9D%E5%A7%8B%E5%8C%96%E5%B7%A5%E4%BD%9C/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-11T09:18:56.000Z" itemprop="datePublished">2018-06-11</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring IOC 容器源码分析 - 余下的初始化工作</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/11/Spring-IOC-%E5%AE%B9%E5%99%A8%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E5%A1%AB%E5%85%85%E5%B1%9E%E6%80%A7%E5%88%B0-bean-%E5%8E%9F%E5%A7%8B%E5%AF%B9%E8%B1%A1/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-11T02:47:09.000Z" itemprop="datePublished">2018-06-11</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring IOC 容器源码分析 - 填充属性到 bean 原始对象</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/08/Spring-IOC-%E5%AE%B9%E5%99%A8%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E5%BE%AA%E7%8E%AF%E4%BE%9D%E8%B5%96%E7%9A%84%E8%A7%A3%E5%86%B3%E5%8A%9E%E6%B3%95/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-08T00:43:53.000Z" itemprop="datePublished">2018-06-08</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring IOC 容器源码分析 - 循环依赖的解决办法</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/06/Spring-IOC-%E5%AE%B9%E5%99%A8%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E5%88%9B%E5%BB%BA%E5%8E%9F%E5%A7%8B-bean-%E5%AF%B9%E8%B1%A1/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-05T17:01:14.000Z" itemprop="datePublished">2018-06-06</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring IOC 容器源码分析 - 创建原始 bean 对象</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/04/Spring-IOC-%E5%AE%B9%E5%99%A8%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E5%88%9B%E5%BB%BA%E5%8D%95%E4%BE%8B-bean/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-03T16:00:16.000Z" itemprop="datePublished">2018-06-04</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring IOC 容器源码分析 - 创建单例 bean 的过程</a> <a
                                    href="https://www.tianxiaobo.com/2018/06/01/Spring-IOC-%E5%AE%B9%E5%99%A8%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E8%8E%B7%E5%8F%96%E5%8D%95%E4%BE%8B-bean/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-06-01T05:11:31.000Z" itemprop="datePublished">2018-06-01</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring IOC 容器源码分析 - 获取单例 bean</a> <a
                                    href="https://www.tianxiaobo.com/2018/05/30/Spring-IOC-%E5%AE%B9%E5%99%A8%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90%E7%B3%BB%E5%88%97%E6%96%87%E7%AB%A0%E5%AF%BC%E8%AF%BB/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-05-30T00:56:33.000Z" itemprop="datePublished">2018-05-30</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring IOC 容器源码分析系列文章导读</a> <a
                                    href="https://www.tianxiaobo.com/2018/01/19/Spring-bean%E7%9A%84%E7%94%9F%E5%91%BD%E6%B5%81%E7%A8%8B/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-18T16:00:48.000Z" itemprop="datePublished">2018-01-19</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> Spring bean的生命流程</a> <a
                                    href="https://www.tianxiaobo.com/2018/01/18/%E8%87%AA%E5%B7%B1%E5%8A%A8%E6%89%8B%E5%AE%9E%E7%8E%B0%E7%9A%84-Spring-IOC-%E5%92%8C-AOP-%E4%B8%8B%E7%AF%87/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-18T15:56:51.000Z" itemprop="datePublished">2018-01-18</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> 自己动手实现的 Spring IOC 和 AOP - 下篇</a> <a
                                    href="https://www.tianxiaobo.com/2018/01/18/%E8%87%AA%E5%B7%B1%E5%8A%A8%E6%89%8B%E5%AE%9E%E7%8E%B0%E7%9A%84-Spring-IOC-%E5%92%8C-AOP-%E4%B8%8A%E7%AF%87/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-18T15:48:16.000Z" itemprop="datePublished">2018-01-18</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> 自己动手实现的 Spring IOC 和 AOP - 上篇</a></div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapse%E4%B8%AD%E9%97%B4%E4%BB%B6"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> 中间件 </a>
                        <small class="text-muted">(Total 2 articles)</small>
                    </h3>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapseZookeeper"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> Zookeeper </a>
                        <small class="text-muted">(Total 1 articles)</small>
                    </h3>
                </div>
                <div id="collapseZookeeper" class="panel-collapse collapse in" role="tabpanel"
                     aria-labelledby="headingZookeeper">
                    <div class="panel-body">
                        <div class="collection"><a
                                    href="https://www.tianxiaobo.com/2018/01/20/%E5%9F%BA%E4%BA%8E-Zookeeper-%E7%9A%84%E5%88%86%E5%B8%83%E5%BC%8F%E9%94%81%E5%AE%9E%E7%8E%B0/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-20T03:21:02.000Z" itemprop="datePublished">2018-01-20</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> 基于 Zookeeper 的分布式锁实现</a></div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapse%E9%99%90%E6%B5%81%E7%BB%84%E4%BB%B6"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> 限流组件 </a>
                        <small class="text-muted">(Total 1 articles)</small>
                    </h3>
                </div>
                <div id="collapse限流组件" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading限流组件">
                    <div class="panel-body">
                        <div class="collection"><a
                                    href="https://www.tianxiaobo.com/2019/05/18/%E7%AE%80%E6%9E%90%E9%99%90%E6%B5%81%E7%AE%97%E6%B3%95/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2019-05-18T12:30:48.000Z" itemprop="datePublished">2019-05-18</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> 简析限流算法</a></div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapse%E5%9F%BA%E7%A1%80%E7%AE%97%E6%B3%95"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> 基础算法 </a>
                        <small class="text-muted">(Total 1 articles)</small>
                    </h3>
                </div>
            </div>

            <div class="panel panel-default b-no" style="margin-left:20px">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapse%E6%9F%A5%E6%89%BE"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> 查找 </a>
                        <small class="text-muted">(Total 1 articles)</small>
                    </h3>
                </div>
                <div id="collapse查找" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading查找">
                    <div class="panel-body">
                        <div class="collection"><a
                                    href="https://www.tianxiaobo.com/2018/01/11/%E7%BA%A2%E9%BB%91%E6%A0%91%E8%AF%A6%E7%BB%86%E5%88%86%E6%9E%90/"
                                    class="collection-item" target="_blank" itemprop="url">
                                <time datetime="2018-01-11T12:12:51.000Z" itemprop="datePublished">2018-01-11</time>
                                <span>&nbsp;&nbsp;&nbsp;</span> 红黑树详细分析</a></div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default b-no">
                <div class="panel-heading" role="tab">
                    <h3 class="panel-title"><a data-toggle="collapse"
                                               href="https://www.tianxiaobo.com/categories/#collapse%E6%9D%82%E8%B0%88"
                                               aria-expanded="true"><i class="icon icon-folder text-active"></i><i
                                    class="icon icon-folder-open text"></i> 杂谈 </a>
                        <small class="text-muted">(Total 2 articles)</small>
                    </h3>
                </div>
            </div>


            <div id="collapse杂谈" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading杂谈">
                <div class="panel-body">
                    <div class="collection"><a
                                href="https://www.tianxiaobo.com/2018/01/18/%E6%88%91%E7%9A%84%E7%88%AC%E8%99%AB%E6%8A%80%E6%9C%AF%E7%BB%8F%E5%8E%86/"
                                class="collection-item" target="_blank" itemprop="url">
                            <time datetime="2018-01-18T15:12:51.000Z" itemprop="datePublished">2018-01-18</time>
                            <span>&nbsp;&nbsp;&nbsp;</span> 我的爬虫技术经历</a> <a
                                href="https://www.tianxiaobo.com/2018/01/18/%E8%87%AA%E5%B7%B1%E5%8A%A8%E6%89%8B%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AA%E7%AE%80%E5%8D%95%E7%9A%84JSON%E8%A7%A3%E6%9E%90%E5%99%A8/"
                                class="collection-item" target="_blank" itemprop="url">
                            <time datetime="2018-01-18T15:24:49.000Z" itemprop="datePublished">2018-01-18</time>
                            <span>&nbsp;&nbsp;&nbsp;</span> 自己动手实现一个简单的JSON解析器</a></div>
                </div>
            </div>
        </div>
    </article>
</main>
<#--<script src="/static/skins/my/js/busuanzi.pure.mini.js"></script>-->

<footer class="footer" itemscope="" itemtype="http://schema.org/WPFooter">
    <ul class="social-links">
        <li><a href="https://github.com/code4wt" target="_blank" title="" data-toggle="tooltip" data-placement="top"
               data-original-title="Github"><i class="icon icon-github"></i></a></li>
        <li><a href="https://segmentfault.com/u/code4fun" target="_blank" title="" data-toggle="tooltip"
               data-placement="top" data-original-title="Segmentfault"><i class="icon icon-segmentfault"></i></a></li>
    </ul>
    <div class="copyright">© 2018-2019 <a href="https://www.tianxiaobo.com/">tianxiaobo.com</a>
        <div class="publishby">Theme by <a href="https://github.com/cofess/hexo-theme-pure" target="_blank">cofess </a>.
        </div>
    </div>
</footer>

<#--右侧bar滚动栏-->
<#--<script src="./static/skins/my/js/application.js"></script>-->

<script defer="">

</script>


<#--<script src="./static/skins/my/js/plugin.min.js"></script>-->
<#--<script src="./static/skins/my/js/insight.js"></script>-->

</html>