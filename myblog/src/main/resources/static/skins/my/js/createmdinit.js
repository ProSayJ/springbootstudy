//初始化md编辑器
var testEditor;
$(function () {
    testEditor = editormd("my-editormd", { //注意1：这里的就是上面的DIV的id属性值
        width: "150%",
        height: 660,
        syncScrolling: true, //设置双向滚动
        path: "/static/editormd/lib/", //lib目录的路径
        // previewTheme : "dark", //代码块使用dark主题
        codeFold: true,
        emoji: true,
        tocm: true, // Using [TOCM]
        tex: true, // 开启科学公式TeX语言支持，默认关闭
        flowChart: true, // 开启流程图支持，默认关闭
        sequenceDiagram: true, // 开启时序/序列图支持，默认关闭,
        htmlDecode: true, //不过滤标签
        imageUpload: true, //上传图片
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp", "JPG", "JPEG", "GIF", "PNG", "BMP", "WEBP"],
        imageUploadURL: "/file/img-upload",
        onload: function () {
            // console.log('onload', this);
        },
        saveHTMLToTextarea: true, //注意3：这个配置，方便post提交表单
        toolbarIcons: function () {
            return ["bold", "del", "italic", "quote", "|", "h1", "h2", "h3", "h4", "h5", "h6", "|", "list-ul", "list-ol", "hr", "|", "link", "image", "code", "code-block", "table", "datetime", "html-entities", "emoji", "|", "watch", "preview", "fullscreen", "clear", "search", "|", "help", "info"]
        }
    });
});

//提交
var publishBtn = $('#publishBtn');

publishBtn.click(function () {
    var articleContent = $('#my-editormd-html-code');
    var articleContentValues = articleContent.val();
    var html = testEditor.getHTML();


    var articleTitle = $('#articleTitle').val();
    var authorName = $('#authorName').val()
    var articleTag = $("#optionChange option:selected").attr("value");

    if (articleTitle == "" || authorName == "" || articleTag == "") {
        alert("不能为空~~");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/article/publish",
        traditional: true,// 传数组
        data: {
            articleContent: articleContentValues,
            articleHtmlContent: html,
            articleTitle: articleTitle,
            author: authorName,
            articleTags: articleTag
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (data) {
            if (data['status'] == 200) {
                alert("发表博客成功！");
            }
        },
        error: function () {
            alert("发表博客请求失败！")
        }
    })

    //定时器
    /*
    var closeNoticeBox = setTimeout(function () {
        noticeBox.hide();
    },3000);
*/
});