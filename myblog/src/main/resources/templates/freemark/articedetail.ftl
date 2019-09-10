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
    <title>ProSay技术预览</title>
    <meta name="description" content="ProSayJ技术博客，专注于 Java，Spring，MyBatis, Dubbo 以及其他分布式技术等">
    <meta property="og:type" content="website">
    <meta property="og:title" content="ProSayJ的技术博客">
    <meta property="og:url" content="https://www.baidu.com">
    <meta property="og:site_name" content="ProSayJ的技术博客">
    <meta property="og:description" content="ProSayJ技术博客，专注于 Java，Spring，MyBatis, Dubbo 以及其他分布式技术等">
    <meta name="twitter:card" content="summary">
    <meta name="twitter:title" content="ProSayJ技术博客">
    <meta name="twitter:description" content="ProSayJ技术博客，专注于 Java，Spring，MyBatis, Dubbo 以及其他分布式技术等">
    <link rel="canonical" href="https://www.baidu.com">

    <link rel="icon" href="/static/skins/my/images/java.ico" type="image/x-icon">
    <link rel="stylesheet" href="/static/skins/my/css/style.css">
    <link rel="stylesheet" href="/static/skins/my/css/code.css">


    <#--预览相关-->
    <link rel="stylesheet" href="/static/editormd/css/editormd.preview.css"/>
    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script src="/static/editormd/lib/marked.min.js"></script>
    <script src="/static/editormd/lib/prettify.min.js"></script>
    <script src="/static/editormd/lib/raphael.min.js"></script>
    <script src="/static/editormd/lib/underscore.min.js"></script>
    <script src="/static/editormd/lib/sequence-diagram.min.js"></script>
    <script src="/static/editormd/lib/flowchart.min.js"></script>
    <script src="/static/editormd/lib/jquery.flowchart.min.js"></script>
    <script src="/static/editormd/src/editormd.js"></script>

</head>


<body class="main-center" itemscope="" itemtype="http://schema.org/WebPage">


<header class="header" itemscope="" itemtype="http://schema.org/WPHeader">
    <#--左侧标签-->
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
    <#--md的文档目录-->
    <div class="markdown-body editormd-preview-container" id="custom-toc-container">#custom-toc-container</div>
</aside>


<#--正文区域-->
<main class="main has-sticky" role="main">
    <#--文章标题和文章概要简介-->
    <div class="article-header"><h1 class="article-title" itemprop="name">排序分类</h1>
        <div class="article-meta"><span class="article-date"><i class="icon icon-calendar-check"></i> <a
                        href="https://www.tianxiaobo.com/2019/05/18/%E7%AE%80%E6%9E%90%E9%99%90%E6%B5%81%E7%AE%97%E6%B3%95/"
                        class="article-date"><time datetime="2019-05-18T12:30:48.000Z" itemprop="datePublished">2019-05-18</time></a></span>
            <span class="article-category"><i class="icon icon-folder"></i> <a class="article-category-link"
                                                                               href="https://www.tianxiaobo.com/categories/middleware/">中间件</a>►<a
                        class="article-category-link"
                        href="https://www.tianxiaobo.com/categories/middleware/%E9%99%90%E6%B5%81%E7%BB%84%E4%BB%B6/">限流组件</a></span>
            <span class="article-tag"><i class="icon icon-tags"></i> <a class="article-tag-link"
                                                                        href="https://www.tianxiaobo.com/tags/%E9%99%90%E6%B5%81/">限流</a></span>
            <span class="article-read hidden-xs"><i class="icon icon-eye-fill" aria-hidden="true"></i> <span
                        id="busuanzi_container_page_pv" style="display: inline;"><span
                            id="busuanzi_value_page_pv">869</span></span></span>
            <span class="post-comment"><i class="icon icon-comment"></i> <a
                        href="https://www.tianxiaobo.com/2019/05/18/%E7%AE%80%E6%9E%90%E9%99%90%E6%B5%81%E7%AE%97%E6%B3%95/#comments"
                        class="article-comment-link">评论</a></span> <span class="post-wordcount hidden-xs"
                                                                         itemprop="wordCount">字数统计: 1,300(字)</span>
            <span class="post-readcount hidden-xs" itemprop="timeRequired">阅读时长: 4(分)</span></div>
    </div>

    <#--文章内容-->
    <div id="test-editormd-view">
        <textarea style="display:none;" name="test-editormd-markdown-doc">###Hello world!</textarea>
    </div>

    <#--主页的页脚-->
    <nav class="bar bar-footer clearfix sticky-bottom" data-stick-bottom=""
         style="position: fixed; width: 1036px; height: 52px; z-index: 42; top: 879px;">
        <div class="bar-inner">
            <ul class="pager pull-left">
                <ul class="pager pull-left">
                    <#--<li class="prev disabled"><a href="javascript:;"><i class="icon icon-angle-left"></i> 上一页(没有了)</a></li>-->
                    <li class="prev disabled">
                        <a href="https://www.tianxiaobo.com/2019/01/09/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%9C%8D%E5%8A%A1%E8%B0%83%E7%94%A8%E8%BF%87%E7%A8%8B/"
                           title="Dubbo 源码分析 - 服务调用过程">
                            <i class="icon icon-angle-left"></i> 上一篇
                        </a>
                    </li>
                    <li class="next">
                        <a href="https://www.tianxiaobo.com/2019/01/09/Dubbo-%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90-%E6%9C%8D%E5%8A%A1%E8%B0%83%E7%94%A8%E8%BF%87%E7%A8%8B/"
                           title="Dubbo 源码分析 - 服务调用过程">
                            下一篇 <i class="icon icon-angle-right"></i>
                        </a>
                    </li>
                </ul>
            </ul>
            <div class="bar-right"></div>
        </div>
    </nav>
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

<script type="text/javascript">
    $(function () {
        var testEditormdView;
        $.post("/article/detail?id=3", function (markdown) {
            testEditormdView = editormd.markdownToHTML("test-editormd-view", {
                markdown: markdown,//+ "\r\n" + $("#append-test").text(),
                htmlDecode: "style,script,iframe",  // you can filter tags decode
                //tocm: true,    // Using [TOCM]
                tocContainer: "#custom-toc-container", // 自定义 ToC 容器层
                emoji: true,
                taskList: true,
                tex: true,  // 默认不解析
                flowChart: true,  // 默认不解析
                sequenceDiagram: true,  // 默认不解析
                theme: (localStorage.theme) ? localStorage.theme : "dark",
                previewTheme: (localStorage.previewTheme) ? localStorage.previewTheme : "dark",
                editorTheme: (localStorage.editorTheme) ? localStorage.editorTheme : "pastel-on-dark",
                path: '/static/editormd/lib/',
            });
        });

        themeSelect("preview-area-theme-select", editormd.previewThemes, "previewTheme", function ($this, theme) {
            alert(theme);
            testEditormdView.getEditor().setTheme(theme);

        });

        function themeSelect(id, themes, lsKey, callback) {
            var select = $("#" + id);
            for (var i = 0, len = themes.length; i < len; i++) {
                var theme = themes[i];
                var selected = (localStorage[lsKey] == theme) ? " selected=\"selected\"" : "";

                select.append("<option value=\"" + theme + "\"" + selected + ">" + theme + "</option>");
            }

            select.bind("change", function () {
                var theme = $(this).val();

                if (theme === "") {
                    alert("theme == \"\"");
                    return false;
                }

                console.log("lsKey =>", lsKey, theme);

                localStorage[lsKey] = theme;
                callback(select, theme);
            });

            return select;
        }

        $("#insert-btn").click(function () {
            testEditormdView.config({
                tocContainer: "#custom-toc-container",
                tocDropdown: false
            });
        });

        $("#menu-btn").click(function () {
            testEditormdView.config({
                tocContainer: "",
                tocDropdown: true,
                tocTitle: "目录 Table of Contents dsfsadfsfdsdf",
            });
        });

        $("#menu2-btn").click(function () {
            alert("ToC Dropdown menu insert to custom container");
            testEditormdView.config({
                tocContainer: "#custom-toc-container",
                tocDropdown: true,
                tocTitle: "目录 Table of Contents dsfsadfsfdsdf",
            });
        });

        $("#default-btn").click(function () {
            alert("default-btn");
            $("#custom-toc-container").html("#custom-toc-container");
            testEditormdView.config({
                tocContainer: "",
                tocm: false,
                tocDropdown: false
            });
        });

        $("#tocm-btn").click(function () {
            alert("tocm-btn");
            $("#custom-toc-container").html("#custom-toc-container");
            testEditormdView.config({
                tocm: true,
                tocContainer: "",
                tocDropdown: false
            });
        });

    });
</script>


<#--<script src="./static/skins/my/js/plugin.min.js"></script>-->
<#--<script src="./static/skins/my/js/insight.js"></script>-->

</html>