<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">

<#include "common/admin_head.ftl">
<#include "common/admin_head_createmd.ftl">
<#include "common/admin_header.ftl">

<body class="main-center" itemscope="" itemtype="http://schema.org/WebPage">
<#--正文区域-->
<main class="main has-sticky" role="main">
    <#--文章列表-->
    <div id="my-editormd">
        <!-- 书写与实时显示的textarea -->
        <textarea id="my-editormd-markdown-doc" name="my-editormd-markdown-doc" style="display:none;"></textarea>
        <!-- 用于后端获取md稳当内容，Java中：request.getParameter("my-editormd-html-code")。 -->
        <textarea id="my-editormd-html-code" name="my-editormd-html-code" style="display:none;"></textarea>
    </div>

</main>
<script src="/static/skins/my/js/createmdinit.js"></script>
<#include "common/admin_footer.ftl">
</body>

</html>