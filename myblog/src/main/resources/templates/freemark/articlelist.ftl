<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
    <meta charset="UTF-8">
    <title>文章列表页-Spring Boot集成Jasypt安全框架</title>


    <link rel="icon" type="image/x-icon" href="/static/ico/favicon.ico">
    <link rel="stylesheet" href="/static/editormd/css/editormd.css"/>
    <link href="/static/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet"/>
    <link href="/static/bootstrap-select-1.13.9/css/bootstrap-select.min.css" rel="stylesheet"/>
    <style>
        /*隐藏markdown全窗口预览不会关闭的bug，会导致其他fa选择器同时隐藏*/
        .fa {
            display: none;
        }
    </style>

    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script src="/static/bootstrap-3.3.7/js/bootstrap.js"></script>
    <script src="/static/bootstrap-select-1.13.9/js/bootstrap-select.js"></script>
    <script src="/static/bootstrap-select-1.13.9/js/i18n/defaults-zh_CN.min.js"></script>

    <script src="/static/js/move.js"></script>
    <script src="/static/editormd/src/editormd.js"></script>
</head>
<body>


<div class="container">

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading" align="center">
            <button type="submit" class="btn-default" onclick="create()">
                新建博客-
            </button>

        </div>

        <select name="" id="optionChange" class="selectpicker">
            <option value="">--请选择--</option>
            <#list allTags as tag>
                <option value=${tag.id}>${tag.tagName}</option>
            </#list>
        </select>


        <table class="table table-hover">
            <tr>
                <td>ID</td>
                <td>文章标题</td>
                <td>作者</td>
                <td>文章分类</td>
                <td>创建时间</td>
                <td>更新时间</td>
                <td>操作</td>
            </tr>
            <#list articleList as article>
                <tr>
                    <td>#{article.id}</td>
                    <td>
                        <div style="margin-bottom:5px">
                            <a class="btn btn-inverse" onclick="preview(${article.id})">${article.articleTitle}</a>
                        </div>
                    </td>
                    <td>${article.originalAuthor}</td>
                    <td>${article.articleCategories}</td>
                    <td>${article.publishDate?string('yyyy-MM-dd')}</td>
                    <td>${article.updateDate?string('yyyy-MM-dd')}</td>
                    <td>
                        <div class="btn-group-vertical" role="group" aria-label="">
                            <div class="btn-group" role="group">
                                <button type="button" class="btn btn-default" onclick="edit(${article.id})">编辑
                                </button>
                            </div>
                        </div>
                    </td>
                </tr>
            </#list>


        <#--  <#list articleList as article>
              ${article.articleSummary}
          </#list>-->
        </table>
    </div>
</div>

<script type="text/javascript">
    function create() {
        window.open("/fee/create");
    }

    function preview(id) {
        alert(id);
        window.open("/fee/preview?id=" + id);
    }

    function edit(id) {
        window.open("/fee/editor?id=" + id);
    }

    $(function () {
        $("#optionChange").change(function (data) {
            var tagId = $("#optionChange option:selected").attr("value");
            /*  var url = "/report/city/cityid/" + cityid;
              window.location.href = url;*/
             alert(tagId);
            window.open("/fee/articlelistbytagid?id=" + tagId);
        });
    });

</script>
</body>
</html>