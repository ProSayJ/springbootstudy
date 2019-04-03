<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
    <title>Welcome FreeMarker!</title>
    <meta charset="utf-8"></meta>
    <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
    <meta http-equiv="x-ua-compatible" content="ie=edge"></meta>


    <!--<link rel="icon" type="image/x-icon" href="/static/ico/favicon.ico">-->
    <link alt="test" rel="icon" type="image/x-icon" th:src="@{/static/ico/favicon.ico}"/>
    <link href="./static/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet"/>
    <link href="./static/bootstrap-3.3.7/css/bootstrap-theme.css" rel="stylesheet"/>

    <script type="text/javascript" src="./static/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="./static/bootstrap-3.3.7/js/bootstrap.js"></script>

</head>
<body>
beanEntityDetailsDeals的大小：${beanEntityDetailsDeals?size}
<#--beanEntityDetailsDeals.propertiesDeals的大小：${beanEntityDetailsDeals.propertiesDeals?size}-->

<#list beanEntityDetailsDeals as beanEntityDetailsDeal>
<table class="table table-hover">

    <tr class="bg-info">
        <td>序号</td>
        <td>${beanEntityDetailsDeal_index+1}</td>
    </tr>
    <tr>
        <td>对象名称:</td>
        <td>${beanEntityDetailsDeal.objectName}</td>
    </tr>
    <tr>
        <td>对象类型:</td>
        <td>${beanEntityDetailsDeal.objectType}</td>
    </tr>

    <tr>
        <td>对象属性集合大小：</td>
        <td>${beanEntityDetailsDeal.propertiesDeals?size}</td>
        <td>
                    <#list beanEntityDetailsDeal.propertiesDeals as item>
                        ${item}</br>
                        111:${item.require}
                        222:${item["require"]}
                        属性名称：${item.propertiesKey}</br>
                        是否必传：${item.require} </br>
                        属性类型：${item.getType?default("type")}</br>
                        属性格式：${item.format?default("format")}</br>
                        属性描述：${item.description?default("description")}</br>
                        <hr>
                    </#list>
        </td>
        <hr>

    <#--
    <td>
        "propertiesDeals":  <#if beanEntityDetailsDeal.propertiesDeals?? && (beanEntityDetailsDeal.propertiesDeals?size > 0)>
                    [
        <#list beanEntityDetailsDeal.propertiesDeals as propertiesDeal>
            ${propertiesDeal?c}
            <#if propertiesDeal_has_next>
                                ,
            </#if>
        </#list>
                    ]
    <#else>[]</#if>

     -->


    <#--
            <td>
                <#if beanEntityDetailsDeal.propertiesDeals?exists >
                    <#list beanEntityDetailsDeal.propertiesDeals as str  >
                        ${str}
                    </#list>
                </#if>
            </td>-->


    <#--
        <#assign resultString>
            <#list beanEntityDetailsDeal.propertiesDeals as PropertiesDetailDeal>
                ${PropertiesDetailDeal.propertiesKey}
                ${PropertiesDetailDeal}
            </#list>
        </#assign>
            ${resultString}

            -->


    </tr>
</table>
</#list>
</body>
</html>