<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">

<#include "common/admin_head.ftl">
<#include "common/admin_header.ftl">

<body class="main-center" itemscope="" itemtype="http://schema.org/WebPage">

<header>
    <style type="text/css">

        #imgbig img {
            /* display: none;*/
        }

        #imgbig img {
            cursor: pointer;
            transition: all 0.6s;
        }

        /*鼠标悬停放大效果*/
        #imgbig img:hover {
            display: block;
            transform: scale(2.5);
        }


    </style>
</header>

<#--正文区域-->
<#list imgs as img>
    <div class="col-md-2">
        <article class="panel panel-default hover-shadow hover-grow" itemscope=""
                 itemtype="http://schema.org/BlogPosting">
            <div class="panel-body">
                <div class="article-meta">
                    <time datetime=""
                          itemprop="datePublished">${img.createDate?string('yyyy-MM-dd')} </time>
                </div>
                <h3 class="article-title" itemprop="name" id="imgId">
                    <div id="imgbig">
                        <img class="img-thumbnail" src="http://localhost${img.imgDbUrl}">
                    </div>
                </h3>
            </div>
            <div class="panel-footer">
                <a href="https://www.baidu.com" class="label label-default mb">Java</a>
                <a href="https://www..baidu.com" class="label label-default mb">框架</a>
                <a href="https://www.baidu.com" class="label label-default mb">Dubbo</a>
            </div>
        </article>
    </div>
</#list>


<#include "common/admin_footer.ftl">

</body>


<script src="/static/js/jquery-3.1.1.min.js"></script>


</html>