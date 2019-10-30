<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">

<#include "common/admin_head.ftl">
<#include "common/admin_head_previewmd.ftl">
<#include "common/admin_header.ftl">


<body class="main-center" itemscope="" itemtype="http://schema.org/WebPage">
<#--正文区域-->
<main class="main has-sticky" role="main">
    <div id="test-editormd-view">
        <textarea style="display:none;" name="test-editormd-markdown-doc">###Hello world!</textarea>
    </div>
</main>

<#include "common/admin_footer.ftl">
<script src="/static/skins/my/js/previewmdinit.js"></script>


<input type="hidden" id="articleId" name="name" value="${previewId}">
<script type="text/javascript">
    $(function () {
        // alert($(" #articleId ").val());
        var testEditormdView;
        $.post("/article/detail?id=" + $(" #articleId ").val(), function (markdown) {
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

</body>

</html>