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
    <script src="/static/js/jquery1.8.js"></script>
    <script src="/static/plugins/layui/layui.all.js"></script>
</header>

<#--正文区域-->
<main class="main has-sticky" role="main">
    <button id="test1">小小提示层</button>
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
                            <img class="img-thumbnail" src="http://localhost${img.imgDbUrl}" id="test1">
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
</main>

<#include "common/admin_footer.ftl">

</body>


<script>

    // $("#test1").click(function(){
    //  layer.msg("nihao");
    // })
    //***********
    // $('#test1').on('click', function(){
    //   layer.msg('Hello layer');
    // });
    //***********
    $('#test1').on('click', function () {
        layer.alert("jaja");
        layer.open({
            type: 1,
            area: ['1200px', '360px'],
            shadeClose: true, //点击遮罩关闭
            /*content: '\<\div style="padding:20px;">自定义内容\<\/div>'*/
            content: '<img class="img-thumbnail" src="http://localhost\\file\\img-download?id=1" id="test1">'
        });
    });

</script>


</html>