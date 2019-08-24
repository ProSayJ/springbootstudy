<#--<#include "../../common-template/macro-common_head.ftl">-->
<!DOCTYPE html>
<html>
<head>
    <link rel=stylesheet href="/static/skins/Pinghsu/css/base.css">
</head>


<body class="body--gray" class="fn__flex-1">
<main id="pjax">
    <div class="wrapper--min wrapper">
        <div class="page__title">
            <span class="ft__red">#</span>
            共 ${tags?size} 个标签
        </div>
        <div class="page__content page__tags fn__clear">
            <#list tags as tag>
                <a rel="tag" data-count="${tag.id}" class="tag tag--${tag_index % 10}"
                   href="/articlelistbytagid?id=${tag.id}" target="_blank">
                    <span class="name">${tag.tagName}</span>
                    (<b>${tag.tagName}</b>)
                </a>
            </#list>
        </div>
    </div>
</main>
</body>
</html>
