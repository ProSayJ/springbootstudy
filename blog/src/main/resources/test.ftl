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
    <style type="text/css">
        .bg {
            background-color: silver;
        }

        tr {
            height: 20px;
            font-size: 12px;
        }

        .specialHeight {
            height: 40px;
        }
    </style>
</head>
<body>
beanEntityDetailsDeals的大小：${beanEntityDetailsDeals?size}
<#--beanEntityDetailsDeals.propertiesDeals的大小：${beanEntityDetailsDeals.propertiesDeals?size}-->
<div style="width:900px; margin: 0 auto">
    <h1 style="text-align: center"> 接口说明文档</h1>
    <br/>

    <table class="table table-hover">
        <tr>
            <td>Swagger版本号码：</td>
            <td> ${swagger}</td>
        </tr>
        <tr>
            <td>Swagger的Host:</td>
            <td> ${host}</td>
        </tr>
        <tr>
            <td>上下文路径:</td>
            <td> ${basePath}</td>
        </tr>
        <tr>
            <td>描述：</td>
            <td> ${info.description}</td>
        </tr>
        <tr>
            <td>版本:</td>
            <td> ${info.version}</td>
        </tr>
        <tr>
            <td>描述:</td>
            <td> ${info.title}</td>
        </tr>
        <tr>
            <td>地址:</td>
            <td> ${info.termsOfService}</td>
        </tr>
    </table>



<#--简单请求和响应参数-->
<#list swaggerReqResEntities as swaggerReqResEntitie>
<table class="table table-hover">
    <tr>
        <td>请求Url:</td>
        <td>${swaggerReqResEntitie.request.requestUrl}</td>
    </tr>

    <tr>
        <td>tags:</td>
        <td>
        <#list swaggerReqResEntitie.request.request.tags as tag>
            ${tag}
            </br>
        </#list>
        </td>
    </tr>

    <tr>
        <td>摘要:</td>
        <td>${swaggerReqResEntitie.request.request.summary}</td>
    </tr>
    <tr>
        <td>描述:</td>
        <td>${swaggerReqResEntitie.request.request.description}</td>
    </tr>
    <tr>
        <td>请求方式:</td>
        <td>${swaggerReqResEntitie.request.request.operationId}</td>
    </tr>

    <tr>
        <td>数据类型:</td>
        <td>
         <#list swaggerReqResEntitie.request.request.consumes as consume>
                 ${consume}</br>
         </#list>
        </td>
    </tr>

    <tr>
        <td>produces:</td>
        <td>
          <#list swaggerReqResEntitie.request.request.produces as produce>
                  ${produce}</br>
          </#list>
        </td>
    </tr>

    <tr>
        <td>请求参数:</td>
        <td>
        <#list swaggerReqResEntitie.request.request.parameters as parameter>
            输入类型：${parameter.in}</br>
            参数名称：${parameter.name}</br>
            参数描述：${parameter.description}</br>
            是否必填：${parameter.required}</br>
            参数对象引用：${parameter.schema.$ref}</br>
        </#list>
        </td>
    </tr>

    <tr>
        <td>响应参数:</td>
        <td>
        <#list swaggerReqResEntitie.response as response1>
            响应码：${response1.responseCode}
            <br/>

            响应码描述：${response1.description}
            <br/>

            schemaType:${response1.schema.type}
            <br/>

            样例：${response1.schema.format}
            </br>

        <#--     或者不是对象是数组-->
            对象引用：${response1.schema.objectRef.$ref}
            </br>
        </#list>
        </td>
    </tr>
</table>
</#list>




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
            <#list beanEntityDetailsDeal.propertiesDeals?keys as key>

                <#list beanEntityDetailsDeal.propertiesDeals[key] as item>
                <font color="blue">属性：</font>${key}
                </br>

                属性描述：${item.description<#--?default("description")-->}
                </br>

                是否必传：${item.require}
                <br/>

                属性类型：${item.type}
                <br/>

                属性格式：${item.format}
                <br/>
                </#list>
                </hr>
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
</div>
</html>