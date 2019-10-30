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
    <title>ProSay技术博客_关于</title>
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
    <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 882px;">
        <div class="slimContent" style="overflow: hidden; width: auto; height: 882px;">
            <div class="widget"><h3 class="widget-title">个人链接</h3>
                <div class="widget-body">
                    <ul class="link-list lh-2x">
                        <li>Github: <a href="xxx" target="_blank">xxx</a></li>
                        <li>SegmentFault: <a href="xxx" target="_blank">xxx</a></li>
                        <li>cnblog: <a href="xxx" target="_blank">xxx</a></li>
                    </ul>
                </div>
            </div>
            <div class="widget"><h3 class="widget-title">技能</h3>
                <div class="widget-body">
                    <ul class="skill-list lh-2x">
                        <li class="clearfix"><span>Java</span> <span class="pull-right">★★★☆☆</span></li>
                        <li class="clearfix"><span>Spring</span> <span class="pull-right">★★★☆☆</span></li>
                        <li class="clearfix"><span>MyBatis</span> <span class="pull-right">★★★☆☆</span></li>
                        <li class="clearfix"><span>Dubbo</span> <span class="pull-right">★★★☆☆</span></li>
                    </ul>
                </div>
            </div>
            <div class="widget"><h3 class="widget-title">个人标签</h3>
                <div class="widget-body"><span class="label label-default mb">程序员</span> <span
                            class="label label-default mb">喜爱编程</span> <span class="label label-default mb">兴趣广泛</span>
                    <span class="label label-default mb">伪黑莓粉</span></div>
            </div>
            <div class="widget"><h3 class="widget-title">个人作品</h3>
                <div class="widget-body">
                    <ul class="work-list lh-2x">
                        <li class="clearfix"><a
                                    href="https://www.tianxiaobo.com/2018/09/09/MyBatis-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90%E7%B3%BB%E5%89%97%E6%96%87%E7%AB%A0%E5%90%88%E9%9B%86/"
                                    target="_blank" title="《一本小小MyBatis源码分析书》"><span>《一本小小MyBatis源码分析书》</span> <span
                                        class="pull-right text-muted">2018.09</span></a></li>
                    </ul>
                </div>
            </div>
            <div class="widget"><h3 class="widget-title">个人项目</h3>
                <div class="widget-body">
                    <ul class="project-list list-square lh-2x">
                        <li class="public source"><a href="https://github.com/code4wt/toy-spring" target="_blank"
                                                     title="toy-spring - 实现了 IOC 和 AOP"><span
                                        class="repo-icon octicon octicon-repo"></span> <span
                                        class="repo-and-owner css-truncate-target">toy-spring - 实现了 IOC 和 AOP</span></a>
                        </li>
                        <li class="public source"><a href="https://github.com/code4wt/JSONParser" target="_blank"
                                                     title="JSONParser - 简单的 JSON 解析器"><span
                                        class="repo-icon octicon octicon-repo"></span> <span
                                        class="repo-and-owner css-truncate-target">JSONParser - 简单的 JSON 解析器</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="slimScrollBar"
             style="background: rgba(0, 0, 0, 0.2); width: 3px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 882px;"></div>
        <div class="slimScrollRail"
             style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div>
    </div>
</aside>

<#--正文区域-->
<main class="main" role="main">
    <article class="article archives-about article-type-normal" itemscope="">
        <header class="article-header"><h1 itemprop="title">关于</h1>
            <p class="text-muted">神兽护体，永无bug</p></header>
        <div class="article-body"><p>欢迎访问我的博客，我会保持不定期更新。</p>
            <hr>
            <pre class="highlight"><code class="java"><span class="comment">/** * * ━━━━━━神兽出没━━━━━━
* 　　　┏┓　　　┏┓
* 　　┃　　　　　　　┃ + +
* 　　┃　　　━　　　┃ ++ + + +
* 　████━████ ┃    🚂🚂🚂-&lt;-&lt; 欢迎访问 tianxiaobo.com
* 　　┃　　　　　　　┃ +
* 　　┃　　　┻　　　┃ + +
* 　　┃　　　　　　　┃
* 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
* 　　　　┃　　　┃   神兽护体，永无bug
* 　　　　┃　　　┃ +
* 　　　　┃　　　┗━━━┓+
* 　　　　┃　　　　　　　┣┓      📬 联系我：tianxiaobo.com(at)outlook.com
* 　　　　┃　　　　　　　┏┛ + +
* 　　　　┗┓┓┏━┳┓┏┛ +
* 　　　　　┃┫┫　┃┫┫
* 　　　　　┗┻┛　┗┻┛
*/</span>
</code></pre>
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

</html>