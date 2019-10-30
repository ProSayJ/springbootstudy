<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">

<#include "common/admin_head.ftl">
<#include "common/admin_header.ftl">

<body class="main-center" itemscope="" itemtype="http://schema.org/WebPage">


<h3 class="panel-title mb-1x">
    <a href="https://www.百度/tags/Java/" title="#Java"># 所有文章</a>
    <small class="text-muted">(共 ${articleList?size} articles)</small>
</h3>

<#list articleList as article>
    <div class="col-md-2">
        <article class="panel panel-default hover-shadow hover-grow" itemscope=""
                 itemtype="http://schema.org/BlogPosting">
            <div class="panel-body">
                <div class="article-meta">
                    <time datetime=""
                          itemprop="datePublished">${article.publishDate?string('yyyy-MM-dd')}
                    </time>
                </div>

                <h3 class="article-title" itemprop="name">
                    <a class="article-link"
                       href="http://localhost/admin/article/preview?id=${article.id}">${article.articleTitle}
                    </a>
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


</html>