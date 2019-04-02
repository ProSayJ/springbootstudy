<html>
<head>
    <title>Welcome FreeMarker!</title>
    <meta charset="utf-8"></meta>
    <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
    <meta http-equiv="x-ua-compatible" content="ie=edge"></meta>
    <link rel="icon" href="https://static.jianshukeji.com/hcode/images/favicon.ico"></link>
    <script src="https://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
</head>
<body>

<#-- 单个属性 替换   -->

<h1>Swagger版本号码： ${swagger}</h1>
<h1>Swagger的Host: ${host}</h1>
<h1>上下文路径: ${basePath}</h1>

<h1>描述:${info.description}</h1>
<h1>版本：${info.version}</h1>
<h1>描述: ${info.title}</h1>
<h1>地址：${info.termsOfService}</h1>


<#--<#list beanEntityDetails as beanEntityDetail>
    <table border="1">
        <tr>
            <td>对象名称:${beanEntityDetail.objectName} </td>
            <td>对象属性：${beanEntityDetail.objectType} </td>
        </tr>
    </table>
</#list>-->

<#list swaggerReqResEntities as swaggerReqResEntitie>
    请求Url: ${swaggerReqResEntitie.request.requestUrl}</br>


    tags:
    <#list swaggerReqResEntitie.request.request.tags as tag>
        ${tag}</br>
    </#list>

    摘要: ${swaggerReqResEntitie.request.request.summary}</br>
    描述: ${swaggerReqResEntitie.request.request.description}</br>
    请求方式: ${swaggerReqResEntitie.request.request.operationId}</br>

    数据类型:
    <#list swaggerReqResEntitie.request.request.consumes as consume>
        ${consume}</br>
    </#list>

    produces:
    <#list swaggerReqResEntitie.request.request.produces as produce>
        ${produce}</br>
    </#list>

    请求参数:</br>
    <#list swaggerReqResEntitie.request.request.parameters as parameter>
        ${parameter.in}</br>
        ${parameter.name}</br>
        ${parameter.description}</br>
        ${parameter.required}</br>
        ${parameter.schema.$ref}</br>
    </#list>
    </br>
    响应参数：</br>
    <#list swaggerReqResEntitie.response as response1>
        响应码：${response1.responseCode}  响应码描述：${response1.description}</br>

        schema:<br/>
        数据类型：${response1.schema.type}  样例：${response1.schema.format}</br>
    <#--或者不是对象是数组-->
        对象引用：${response1.schema.objectRef.$ref}</br>
    </#list>

    <hr/>

<#--数据类型: ${swaggerReqResEntitie.request.request.consumes}</br>-->
<#--produces: ${swaggerReqResEntitie.request.request.produces}</br>-->
<#--<td>相应对象:${swaggerReqResEntitie.response} </td>-->
</#list>


</body>
</html>