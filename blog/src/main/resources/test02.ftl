<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Welcome FreeMarker!</title>
    <#--<meta charset="utf-8"></meta>-->
    <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
    <meta http-equiv="x-ua-compatible" content="ie=edge"></meta>


    <!--<link rel="icon" type="image/x-icon" href="/static/ico/favicon.ico">-->
    <#--<link alt="test" rel="icon" type="image/x-icon" th:src="@{/static/ico/favicon.ico}"/>-->
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
<div style="width:900px; margin: 0 auto">
    <h1 style="text-align: center"> 接口说明文档</h1>
    <br/>

    <table class="table table-hover">
        <tr>
            <td>Swagger版本号码：</td>
            <td> ${swaggerInfo.infoVersion}</td>
        </tr>
        <tr>
            <td>Swagger的Host:</td>
            <td> ${swaggerInfo.swaggerHost}</td>
        </tr>
        <tr>
            <td>上下文路径:</td>
            <td> ${swaggerInfo.swaggerBasePath}</td>
        </tr>
        <tr>
            <td>描述：</td>
            <td> ${swaggerInfo.description}</td>
        </tr>
        <tr>
            <td>标题:</td>
            <td> ${swaggerInfo.infoTitle}</td>
        </tr>
        <tr>
            <td>地址:</td>
            <td> ${swaggerInfo.infoTermsOfService}</td>
        </tr>
    </table>

    <#list requestAndResponse as requestAndResponse>
        <table class="table table-hover">
            <tr>
                <td class="success">请求Controller：</td>
                <td class="success">请求url</td>
                <td class="success">请求方式</td>
                <td class="success">请求描述</td>
                <td class="success">请求参数类型是</td>
                <td class="success">请求参数描述</td>
            </tr>
            <tr>
                <td>${requestAndResponse.requestTag}</td>
                <td>${requestAndResponse.requestUrl}</td>
                <td>${requestAndResponse.requestWay}</td>
                <td>${requestAndResponse.requestPostOperationSummary}</td>
                <td>${requestAndResponse.requestParameterType}</td>
                <td>${requestAndResponse.requestParameterDescription}</td>
            </tr>
        </table>


        <div>请求url：</div>
        <pre>${requestAndResponse.requestWay} ${requestAndResponse.requestUrl}</pre>

        <div>请求体参数说明：</div>
        <#if requestAndResponse.requestParameterType=="Object">
            <table class="table table-hover">
                <#--<td rowspan= ${requestAndResponse.entityPropertiesDetail?size}>请求参数明细：</td>-->
                <#--<td> ${requestAndResponse.entityPropertiesDetail?size} 请求参数明细：</td>-->
                <tr>
                    <td>参数对象名称</td>
                    <td>属性名称</td>
                    <td>属性类型</td>
                    <td>属性描述</td>
                    <td>属性是否必填</td>
                </tr>
                <tr>
                    <td rowspan="${requestAndResponse.entityPropertiesDetail?size + 1}" align="center">${requestAndResponse.requestParameterObjectName}</td>
                </tr>

                <#list requestAndResponse.entityPropertiesDetail as entityPropertiesDetail>
                    <tr>
                        <td>${entityPropertiesDetail.propertiesName}</td>
                        <td>${entityPropertiesDetail.propertiesType}</td>
                        <td>${entityPropertiesDetail.propertiesDes}</td>
                        <td>${entityPropertiesDetail.propertiesRequired}</td>
                    </tr>
                </#list>
            </table>
        </#if>


        <#if requestAndResponse.requestParameterType =="baseParam">
            <table class="table table-hover">
                <tr>
                    <td>类型</td>
                    <td>描述</td>
                    <td>是否必填</td>
                    <td>范例</td>
                </tr>
                <tr>
                    <td>${requestAndResponse.requestParameterQueryParameterBaseParamType}</td>
                    <td>${requestAndResponse.requestParameterQueryParameterBaseParamDescription}</td>
                    <td>${requestAndResponse.requestParameterQueryParameterBaseParamTRequire}</td>
                    <td>${requestAndResponse.requestParameterQueryParameterBaseParamtFormat}</td>
                </tr>
            </table>
        </#if>


        <#if requestAndResponse.requestParameterType=="array">
            <table class="table table-hover">
                <#if requestAndResponse.requestParameterArraysValueType == "ref">
                    <tr>
                        <td>请求是数组,并且数组内容是自定义对象：对象名称是</td>
                    </tr>

                    <tr>
                        <td>${requestAndResponse.requestParameterArraysObjectName}</td>
                    </tr>
                <#else>
                    <tr>
                        <td>请求是数组,并且数组内容是基本数据类型：类型是：</td>
                        <td>样例是：</td>
                    </tr>
                    <tr>
                        <td>${requestAndResponse.requestParameterArraysValueType}</td>
                        <td>$${requestAndResponse.requestParameterArraysValueExample}</td>
                    </tr>
                </#if>
            </table>
        </#if>

        <div>请求参数示例：</div>
        <pre>${requestAndResponse.prettyJson}</pre>

    </#list>
</body>
</div>
</html>