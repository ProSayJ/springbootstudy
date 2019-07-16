<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>ProSayJ | 文章编辑</title>
    <link rel="icon" type="image/x-icon" href="/static/ico/favicon.ico">
    <link rel="stylesheet" href="/static/editormd/css/editormd.css"/>
    <style>
        /*隐藏markdown全窗口预览不会关闭的bug，会导致其他fa选择器同时隐藏*/
        .fa {
            display: none;
        }
    </style>
    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script src="/static/editormd/src/editormd.js"></script>
</head>
<body>
<div id="app">
    <div align="center">
        <button id="publishBtn" type="button" class="btn btn-success">编辑博客</button>
    </div>
    <!--MarkDown的id标志 -->
    <div id="my-editormd">
        <!-- 书写与实时显示的textarea -->
        <textarea id="my-editormd-markdown-doc" name="my-editormd-markdown-doc" style="display:none;"></textarea>
        <!-- 用于后端获取md稳当内容，Java中：request.getParameter("my-editormd-html-code")。 -->
        <textarea id="my-editormd-html-code" name="my-editormd-html-code" style="display:none;"></textarea>
    </div>
</div>
<input type="hidden" value="${editorId}" id="editorId">

</body>
<script>
    //初始化md编辑器
    var testEditor;
    $(function () {
        $.post("/articlefee/detail?id= "+${editorId}, function (md) {
            // console.log(md.toString());
            testEditor = editormd("my-editormd", {
                width: "100%",
                height: 940,

                //theme : "dark",
                // previewTheme : "dark", //代码块使用dark主题
                // editorTheme : "pastel-on-dark",

                path: '/static/editormd/lib/',//lib目录的路径

                markdown: md,

                codeFold: true,

                syncScrolling: true, //设置双向滚动

                saveHTMLToTextarea: true,    // 保存 HTML 到 Textarea
                searchReplace: true,
                //watch : false,                // 关闭实时预览
                htmlDecode: "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启
                //toolbar  : false,             //关闭工具栏
                //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
                emoji: true,
                taskList: true,
                tocm: true,         // Using [TOCM]
                tex: true,                   // 开启科学公式TeX语言支持，默认关闭
                flowChart: true,             // 开启流程图支持，默认关闭
                sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
                //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
                //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
                //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
                //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
                //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
                imageUpload: true, //上传图片
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp", "JPG", "JPEG", "GIF", "PNG", "BMP", "WEBP"],
                imageUploadURL: "/file/img-upload?editorId=" + $(" #editorId ").val(),
                onload: function () {
                    console.log('onload', this);
                    //this.fullscreen();
                    //this.unwatch();
                    //this.watch().fullscreen();

                    //this.setMarkdown("#PHP");
                    //this.width("100%");
                    //this.height(480);
                    //this.resize("100%", 640);
                },
                saveHTMLToTextarea: true, //注意3：这个配置，方便post提交表单
                toolbarIcons: function () {
                    return ["bold", "del", "italic", "quote", "|", "h1", "h2", "h3", "h4", "h5", "h6", "|", "list-ul", "list-ol", "hr", "|", "link", "image", "code", "code-block", "table", "datetime", "html-entities", "emoji", "|", "watch", "preview", "fullscreen", "clear", "search", "|", "help", "info"]
                }

            });
        });
    })
    ;

    //提交
    var publishBtn = $('#publishBtn');


    publishBtn.click(function () {
        var articleContentValues = testEditor.getMarkdown().toString();
        var html = testEditor.getHTML();
        var editorId = $(" #editorId ").val();
        console.log(articleContentValues.toString());
        $.ajax({
            type: "POST",
            url: "/article/update",
            traditional: true,// 传数组
            data: {
                id: editorId,
                articleContent: articleContentValues,
                articleHtmlContent: html
            },
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            success: function (data) {
                if (data['status'] == 200) {
                    alert("更新博客成功！");
                }
            },
            error: function () {
                alert("更新博客请求失败！")
            }
        })

        //定时器
        /*
        var closeNoticeBox = setTimeout(function () {
            noticeBox.hide();
        },3000);
    */
    });
</script>
</html>