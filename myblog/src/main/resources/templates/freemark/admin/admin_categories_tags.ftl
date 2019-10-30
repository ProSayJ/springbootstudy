<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">

<#include "common/admin_head.ftl">
<#include "common/admin_header.ftl">
<head>
    <style>
        .wrapper {
            max-width: 1024px;
            padding: 0 10px;
            box-sizing: border-box;
            margin: 100px auto
        }

        .page__title {
            margin: 10px 0;
            padding: 0 15px;
            /*color: #5f5f5f;*/
            color: red;
        }

        .page__content {
            margin: 15px 0 40px
        }

        .page__tags .tag {
            margin: 15px
        }

        .tag {
            font-size: 13px;
            display: inline-block;
            padding: 0 15px;
            transition: all .3s;
            line-height: 24px;
            color: #fff;
            cursor: pointer;
            background: #6fa3ef;
            border-radius: 12px;
            margin-left: 10px
        }

        .tag:hover {
            color: #5f5f5f;
            background: #e0e0e0
        }

        .tag--1 {
            background: #ff9800
        }

        .tag--2 {
            background: #46c47c
        }

        .tag--3 {
            background: #eb5055
        }

        .tag--4 {
            background: #db4437
        }

        .tag--5 {
            background: #1b95e0
        }

        .tag--6 {
            background: #fdc200
        }

        .tag--7 {
            background: #4caf50
        }
    </style>
</head>

<body class="main-center" itemscope="" itemtype="http://schema.org/WebPage">


<#--正文区域-->
<#--<#list allTags as tag>
    <div class="col-md-2">
        <article class="panel panel-default hover-shadow hover-grow" itemscope=""
                 itemtype="http://schema.org/BlogPosting">
            <div class="panel-body">
                <div class="article-meta">
                    &lt;#&ndash;<time datetime="" itemprop="datePublished">${img.createDate?string('yyyy-MM-dd')} </time>&ndash;&gt;
                    2019-12-23
                </div>
                <h3 class="article-title" itemprop="name" id="imgId">
                    <div>
                        ${tag.tagName}
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
</#list>-->

<div class="wrapper">
    <div class="page__title">
        <span class="ft__red">#</span>
        共 ${allTags?size} 个标签
    </div>
    <div class="page__content page__tags fn__clear">
        <#list allTags as tag>
            <a rel="tag" data-count="${tag.id}" class="tag tag--${tag_index % 10}"
               href="/articlelistbytagid?id=${tag.id}" target="_blank">
                <span class="name">${tag.tagName}</span>
                (<b>${tag.tagName}</b>)
            </a>
        </#list>
    </div>
</div>

<#include "common/admin_footer.ftl">

</body>


<script src="/static/js/jquery-3.1.1.min.js"></script>


</html>