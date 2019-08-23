<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8"/>
    <title>ProSayJ | 博客预览</title>
    <link rel="stylesheet" href="/static/editormd/examples/css/style.css"/>
    <link rel="stylesheet" href="/static/editormd/css/editormd.preview.css"/>
    <link rel="icon" type="image/x-icon" href="/static/ico/favicon.ico">
    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script src="/static/editormd/lib/marked.min.js"></script>
    <script src="/static/editormd/lib/prettify.min.js"></script>
    <script src="/static/editormd/lib/raphael.min.js"></script>
    <script src="/static/editormd/lib/underscore.min.js"></script>
    <script src="/static/editormd/lib/sequence-diagram.min.js"></script>
    <script src="/static/editormd/lib/flowchart.min.js"></script>
    <script src="/static/editormd/lib/jquery.flowchart.min.js"></script>
    <script src="/static/editormd/src/editormd.js"></script>
    <style>
        body {
            padding: 4%;
            background: snow;
        }

        #layout > header, .btns {
            width: auto;
        }

        #sidebar {
            width: 18%;
            height: 100%;
            position: fixed;
            top: 0;
            right: 0;
            overflow: hidden;
            background: #fffffc;
            z-index: 100;
            padding: 18px;
            border: 1px solid #ddd;
            border-top: none;
            border-bottom: none;
        }

        #sidebar:hover {
            overflow: auto;
        }

        #sidebar h1 {
            font-size: 14px;
        }

        #custom-toc-container {
            padding-left: 0;
        }

        #test-editormd-view, #test-editormd-view2 {
            padding-left: 0;
            padding-right: 400px;
            margin: 0;
        }

        #external-frame {
            width: 300px;
            height: 100%;
            position: fixed;
            top: 0;
            left: 0;
            overflow: hidden;
            background: #fff;
            z-index: 100;
            padding: 18px;
            border: 1px solid #ddd;
            border-top: none;
            border-bottom: none;
        }
    </style>
</head>
<body>
<div id="layout">
    <header>
        <h1>Markdown转HTML的显示处理之自定义 ToC 容器</h1>
        <p>即：非编辑情况下的HTML预览</p>
        <p>HTML Preview (markdown to html and custom ToC container)</p>
    </header>
    <select id="preview-area-theme-select">
        <option selected="selected" value="">select preview area themes</option>
    </select>
    <div id="sidebar">
        <h1>Table of Contents</h1>
        <div class="markdown-body editormd-preview-container" id="custom-toc-container">#custom-toc-container</div>
    </div>
    <div id="test-editormd-view">
        <textarea style="display:none;" name="test-editormd-markdown-doc">###Hello world!</textarea>
    </div>
    <div id="test-editormd-view2">
        <textarea id="append-test" style="display:none;"></textarea>
    </div>
</div>

<!--
<script src="js/zepto.min.js"></script>
<script>
    var jQuery = Zepto;  // 为了避免修改flowChart.js和sequence-diagram.js的源码，所以使用Zepto.js时想支持flowChart/sequenceDiagram就得加上这一句
</script>
-->


<input type="hidden" id="articleId" name="name" value="${previewId}">
<script type="text/javascript">
    $(function () {
        var testEditormdView, testEditormdView2;
        $.post("/article/detail?id=" + $(" #articleId ").val(), function (markdown) {
            // console.log(markdown.toString());
            testEditormdView = editormd.markdownToHTML("test-editormd-view", {
                markdown: markdown,//+ "\r\n" + $("#append-test").text(),
                //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
                htmlDecode: "style,script,iframe",  // you can filter tags decode
                //toc             : false,
                tocm: true,    // Using [TOCM]
                tocContainer: "#custom-toc-container", // 自定义 ToC 容器层
                //gfm             : false,
                //tocDropdown     : true,
                // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
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
            themeSelect("preview-area-theme-select", editormd.previewThemes, "previewTheme", function ($this, theme) {
                alert(theme);
                testEditormdView.getEditor().setTheme(theme);

            });
            //console.log("返回一个 jQuery 实例 =>", testEditormdView);

            // 获取Markdown源码
            //console.log(testEditormdView.getMarkdown());

            //alert(testEditormdView.getMarkdown());
        });

        /*
                testEditormdView2 = editormd.markdownToHTML("test-editormd-view2", {
                    htmlDecode: "style,script,iframe",  // you can filter tags decode
                    emoji: true,
                    taskList: true,
                    tex: true,  // 默认不解析
                    flowChart: true,  // 默认不解析
                    sequenceDiagram: true,  // 默认不解析
                });
          */
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
    });
</script>
</body>
</html>