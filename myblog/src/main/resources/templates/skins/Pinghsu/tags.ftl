<#--

    Solo - A small and beautiful blogging system written in Java.
    Copyright (c) 2010-present, b3log.org

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

-->
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
                href="/fee/articlelistbytagid?id=${tag.id}" target="_blank">
                 <span class="name">${tag.tagName}</span>
                 (<b>${tag.tagName}</b>)
             </a>
         </#list>
        </div>
    </div>
</main>
</body>
</html>
