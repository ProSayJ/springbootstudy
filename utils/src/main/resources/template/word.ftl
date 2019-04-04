<%@ page contentType="application/msword" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>tool</title>
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
<div style="width:800px; margin: 0 auto">
    <h1 style="text-align: center"> 接口说明文档</h1>
    <br/>
    <#list swaggers as t>
        <h1>${t.getInfo().getTitle()}</h1>
        <br/>
        <h2>1 接口基本信息</h2>
        <table border="1" cellspacing="0" cellpadding="0" width="100%">
            <tr>
                <td>接口描述</td>
                <td colspan="4">${t.getInfo()!""}</td>
            </tr>
            <tr>
                <td>根路径</td>
                <td colspan="4">${t.getBasePath()!""}</td>
            </tr>
            <tr>
                <td>版本</td>
                <td colspan="4">${t.getInfo().getVersion()!""}</td>
            </tr>
            <tr>
                <td>HOST</td>
                <td colspan="4">${t.getHost()}!""</td>
            </tr>

        </table>
        <br/>

        <#macro propertyShow properties parentIndex>
            <#if properties??&&(properties?size>0)>
                <#list properties?keys as pName >
                    <#assign property=properties[pName]>
                    <tr align="center">
                        <#if parentIndex == "">
                            <td>${pName_index + 1}</td>
                        <#else>
                            <td>${parentIndex}.${pName_index + 1}</td>

                        </#if>
                        <td>${pName}</td>
                        <#assign type=property.getType()>
                        <#if type == "Object"||type == "object" >
                            <td>${property.getType()}</td>
                            <td>${property.getRequired()?c}</td>
                            <td>${property.getDescription()!""}</td>
                            <#assign index=pName_index + 1>
                            <#assign incresIndex=index?string.number>

                            <#--<@propertyShow properties=property.getProperties() parentIndex=incresIndex />-->

                        <#elseif type == "array">
                            <#assign items=property.getItems()>
                            <#if items.getType() == "ref">
                                <#assign ref=items.get$ref()?replace("#/definitions/","")>
                                <td>${property.getType()}[<a href="#${ref}">${ref}</a>]</td>
                                <td>${property.getRequired()?c}</td>
                                <td>${property.getDescription()!""}</td>
                            <#elseif items.getType() == "object">
                                <#assign index=pName_index + 1>
                                <#assign incresIndex=index?string.number>
                                <@propertyShow properties=items..getProperties() parentIndex=incresIndex />
                            <#else>
                                <td>${property.getType()}[${items.getType()}]</td>
                                <td>${property.getRequired()?c}</td>
                                <td>${property.getDescription()!""}</td>
                            </#if>
                        <#elseif type == "ref">
                            <#assign ref=property.get$ref()?replace("#/definitions/","")>
                            <td><a href="#${ref}">${ref}</a></td>
                            <td>${property.getRequired()?c}</td>
                            <td>${property.getDescription()!""}</td>
                        <#else>
                            <td>${property.getType()}</td>
                            <td>${property.getRequired()?c}</td>
                            <td>${property.getDescription()!""}</td>
                        </#if>
                    </tr>
                </#list>
            </#if>
        </#macro>

        <#macro baseParameterShow parameters type parentIndex pathIndex methodIndex jIndex desc>
            <#list parameters as parameter >
                <#if parameter.getIn() == type>
                    <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex} ${desc}</font></h5>
                    <br/>
                    <table border="1" cellspacing="0" cellpadding="0" width="100%">
                        <tr class="bg" align="center">
                            <td width="10%">序号</td>
                            <td width="20%">参数名</td>
                            <td width="20%">数据类型</td>
                            <td width="20%">是否必填</td>
                            <td width="30%">说明</td>
                        </tr>
                        <#assign index=1>
                        <#list parameters as parameter >
                            <#if parameter.getIn() == type>
                                <tr align="center">
                                    <td>${index}</td>
                                    <td>${parameter.getName()}</td>
                                    <td>${parameter.getType()}</td>
                                    <td>${parameter.getRequired()?c}</td>
                                    <td>${parameter.getDescription()!""}</td>
                                </tr>
                                <#assign index=index+1>
                            </#if>
                        </#list>
                    </table>
                    <br/>
                    <#break>
                    <#assign jIndex=jIndex+1>
                </#if>
            </#list>
        </#macro>

        <#macro modelShow model paremtName required desc index>
            <#if model.getProperties()??&&(model.getProperties()?size>0)>
                <tr align="center">
                    <td>${index}</td>
                    <td>${paremtName}</td>
                    <td>object</a></td>
                    <td>${required}</td>
                    <td>${desc}</td>
                </tr>
                <@propertyShow properties=model.getProperties() parentIndex=index?string />
            </#if>
            <#if model.class.simpleName == "ArrayModel">
                <#assign modelProperty=model.getItems()>
                <#assign itemType=modelProperty.getType()>
                <#if itemType == "object">
                    <tr align="center">
                        <td>${index}</td>
                        <td>${paremtName}</td>
                        <td>array[{...}]</td>
                        <td>${required}</td>
                        <td>${desc}</td>
                    </tr>
                    <#assign properties=modelProperty.getProperties()>
                    <@propertyShow properties=properties parentIndex=index?string />
                <#elseif itemType == "ref">
                    <#assign ref=modelProperty.get$ref()?replace("#/definitions/","")>
                    <tr align="center">
                        <td>${index}</td>
                        <td>${paremtName}</td>
                        <td>array[<a href="#${ref}">${ref}</a>]</td>
                        <td>${required}</td>
                        <td>${desc}</td>
                    </tr>
                <#else>
                    <tr align="center">
                        <td>${index}</td>
                        <td>${paremtName}</td>
                        <td>array[${type}]</td>
                        <td>${required}</td>
                        <td>${desc}</td>
                    </tr>
                </#if>
            </#if>
            <#if model.getReference()??>
                <tr align="center">
                    <td>${index}</td>
                    <td>${paremtName}</td>
                    <#assign ref=model.getReference()?replace("#/definitions/","")>
                    <td><a href="#${ref}">${ref}</a></td>
                    <td>${required}</td>
                    <td>${desc}</td>
                </tr>
            </#if>
        </#macro>

        <#macro bodyParameterShow parameters type parentIndex pathIndex methodIndex  jIndex desc>
            <#list parameters as parameter >
                <#if parameter.getIn() == type>
                    <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex} ${desc} </font></h5>
                    <h6><font size="5"> 消息体参数列表的第一行代表的是消息体的结构类型，比如ojbect代表的是{}结构，array代表的是[]接口 </font></h6>
                    <table border="1" cellspacing="0" cellpadding="0" width="100%">
                        <tr class="bg" align="center">
                            <td width="10%">序号</td>
                            <td width="20%">参数名</td>
                            <td width="20%">数据类型</td>
                            <td width="20%">是否必填</td>
                            <td width="30%">说明</td>
                        </tr>
                        <#assign index=1>
                        <#list parameters as parameter >
                            <#if parameter.getIn() == type>
                                <#assign schema=parameter.getSchema()>
                                <@modelShow model=schema paremtName="Body" required=parameter.getRequired()?c desc=parameter.getDescription()!""
                                index=index />
                                <#assign index=index+1>

                            </#if>
                        </#list>
                    </table>
                    <br/>
                    <#break>
                    <#assign jIndex=jIndex+1>
                </#if>
            </#list>
        </#macro>

        <#macro operationBaseShow operation parentIndex path pathIndex method methodIndex>
            <br/>
            <h4><font size="5">${parentIndex}.${pathIndex}.${methodIndex} http方法&nbsp;&nbsp;${method}</font></h4>
            <br/>
            <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.1 接口描述</font></h5>
            <h6><font size="5">&nbsp;&nbsp;${operation.getDescription()!""}</font></h6>
            <br/>
            <#assign jIndex=1>
            <#if operation.getParameters()??&&(operation.getParameters()?size>0)>
                <#assign parameters=operation.getParameters()>

                <#list parameters as parameter >
                    <#if parameter.getIn() == "header">
                        <#assign jIndex=jIndex+1>
                        <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex} 请求头参数</font></h5>
                        <br/>
                        <table border="1" cellspacing="0" cellpadding="0" width="100%">
                            <tr class="bg" align="center">
                                <td width="10%">序号</td>
                                <td width="20%">参数名</td>
                                <td width="20%">数据类型</td>
                                <td width="20%">是否必填</td>
                                <td width="30%">说明</td>
                            </tr>
                            <#assign index=1>
                            <#list parameters as parameter >
                                <#if parameter.getIn() == "header">
                                    <tr align="center">
                                        <td>${index}</td>
                                        <td>${parameter.getName()}</td>
                                        <td>${parameter.getType()}</td>
                                        <td>${parameter.getRequired()?c}</td>
                                        <td>${parameter.getDescription()!""}</td>
                                    </tr>
                                    <#assign index=index+1>
                                </#if>
                            </#list>
                        </table>
                        <br/>
                        <#break>
                    </#if>
                </#list>

                <#list parameters as parameter >
                    <#if parameter.getIn() == "path">
                        <#assign jIndex=jIndex+1>
                        <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex} path参数</font></h5>
                        <br/>
                        <table border="1" cellspacing="0" cellpadding="0" width="100%">
                            <tr class="bg" align="center">
                                <td width="10%">序号</td>
                                <td width="20%">参数名</td>
                                <td width="20%">数据类型</td>
                                <td width="20%">是否必填</td>
                                <td width="30%">说明</td>
                            </tr>
                            <#assign index=1>
                            <#list parameters as parameter >
                                <#if parameter.getIn() == "path">
                                    <tr align="center">
                                        <td>${index}</td>
                                        <td>${parameter.getName()}</td>
                                        <td>${parameter.getType()}</td>
                                        <td>${parameter.getRequired()?c}</td>
                                        <td>${parameter.getDescription()!""}</td>
                                    </tr>
                                    <#assign index=index+1>
                                </#if>
                            </#list>
                        </table>
                        <br/>
                        <#break>
                    </#if>
                </#list>

                <#list parameters as parameter >
                    <#if parameter.getIn() == "query">
                        <#assign jIndex=jIndex+1>
                        <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex} query参数</font></h5>
                        <br/>
                        <table border="1" cellspacing="0" cellpadding="0" width="100%">
                            <tr class="bg" align="center">
                                <td width="10%">序号</td>
                                <td width="20%">参数名</td>
                                <td width="20%">数据类型</td>
                                <td width="20%">是否必填</td>
                                <td width="30%">说明</td>
                            </tr>
                            <#assign index=1>
                            <#list parameters as parameter >
                                <#if parameter.getIn() == "query">
                                    <tr align="center">
                                        <td>${index}</td>
                                        <td>${parameter.getName()}</td>
                                        <td>${parameter.getType()}</td>
                                        <td>${parameter.getRequired()?c}</td>
                                        <td>${parameter.getDescription()!""}</td>
                                    </tr>
                                    <#assign index=index+1>
                                </#if>
                            </#list>
                        </table>
                        <br/>
                        <#break>
                    </#if>
                </#list>
                <#list parameters as parameter >
                    <#if parameter.getIn() == "formData">
                        <#assign jIndex=jIndex+1>
                        <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex} formData参数</font></h5>
                        <br/>
                        <table border="1" cellspacing="0" cellpadding="0" width="100%">
                            <tr class="bg" align="center">
                                <td width="10%">序号</td>
                                <td width="20%">参数名</td>
                                <td width="20%">数据类型</td>
                                <td width="20%">是否必填</td>
                                <td width="30%">说明</td>
                            </tr>
                            <#assign index=1>
                            <#list parameters as parameter >
                                <#if parameter.getIn() == "formData">
                                    <tr align="center">
                                        <td>${index}</td>
                                        <td>${parameter.getName()}</td>
                                        <td>${parameter.getType()}</td>
                                        <td>${parameter.getRequired()?c}</td>
                                        <td>${parameter.getDescription()!""}</td>
                                    </tr>
                                    <#assign index=index+1>
                                </#if>
                            </#list>
                        </table>
                        <br/>
                        <#break>
                    </#if>
                </#list>
                <#list parameters as parameter >
                    <#if parameter.getIn() == "body">
                        <#assign jIndex=jIndex+1>
                        <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex} 请求消息体 </font></h5>
                        <h6><font size="4"> 消息体参数列表的第一行代表的是消息体的结构类型，比如ojbect代表的是{}结构，array代表的是[]接口 </font></h6>
                        <table border="1" cellspacing="0" cellpadding="0" width="100%">
                            <tr class="bg" align="center">
                                <td width="10%">序号</td>
                                <td width="20%">参数名</td>
                                <td width="20%">数据类型</td>
                                <td width="20%">是否必填</td>
                                <td width="30%">说明</td>
                            </tr>
                            <#assign index=1>
                            <#list parameters as parameter >
                                <#if parameter.getIn() == "body">
                                    <#assign schema=parameter.getSchema()>
                                    <@modelShow model=schema paremtName="Body" required=parameter.getRequired()?c desc=parameter.getDescription()!""
                                    index=index />
                                    <#assign index=index+1>

                                </#if>
                            </#list>
                        </table>
                        <br/>
                        <#break>
                    </#if>
                </#list>
            </#if>
            <br/>
            <#if operation.getResponses()??&&(operation.getResponses()?size>0)>
                <#assign responses=operation.getResponses()>
                <#list responses?keys as statusCode>
                    <#assign jIndex=jIndex+1>
                    <#assign response=responses[statusCode]>
                    <#assign index=1>
                    <h5><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex} ${statusCode} 响应消息
                            ${response.getDescription()!""}</font></h5>
                    <br/>
                    <#assign jiedianIndex=0>
                    <#if response.getHeaders()??&&(response.getHeaders()?size>0)>
                        <#assign jiedianIndex=jiedianIndex+1>
                        <#assign headers=response.getHeaders()>
                        <h6><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex}.${jiedianIndex}
                                响应头参数</font>
                        </h6>
                        <br/>
                        <table border="1" cellspacing="0" cellpadding="0" width="100%">
                            <tr class="bg" align="center">
                                <td width="10%">序号</td>
                                <td width="20%">参数名</td>
                                <td width="20%">数据类型</td>
                                <td width="20%">是否必填</td>
                                <td width="30%">说明</td>
                            </tr>
                            <#list headers?keys as header>
                                <tr align="center">
                                    <td>${header_index + 1}</td>
                                    <td>${header}</td>
                                    <td>${headers[header].getType()!"string"}</td>
                                    <td>${headers[header].getRequired()?c}</td>
                                    <td>${headers[header].getDescription()!""}</td>
                                </tr>
                            </#list>
                        </table>
                        <br/>
                    </#if>
                    <#if response.getResponseSchema()??>
                        <#assign jiedianIndex=jiedianIndex+1>
                        <#assign model=response.getResponseSchema()>
                        <h6><font size="5">${parentIndex}.${pathIndex}.${methodIndex}.${jIndex}.${jiedianIndex} 响应消息体
                                消息体参数列表的第一行代表的是消息体的结构类型，比如ojbect代表的是{}结构，array代表的是[]接口</font></h6>
                        <table border="1" cellspacing="0" cellpadding="0" width="100%">
                            <tr class="bg" align="center">
                                <td width="10%">序号</td>
                                <td width="20%">参数名</td>
                                <td width="20%">数据类型</td>
                                <td width="20%">是否必填</td>
                                <td width="30%">说明</td>
                            </tr>
                            <@modelShow model=model paremtName="Body" required=true?c desc=response.getDescription()!"" index=index />
                        </table>
                        <br/>
                    </#if>
                </#list>
            </#if>
        </#macro>

        <h2>2 公共结构体</h2>
        <br/>
        <#if t.getDefinitions()??&&(t.getDefinitions()?size>0)>
            <#assign definitions=t.getDefinitions()>
            <#assign index=1>
            <#list definitions?keys as name >
                <#assign definition=definitions[name]>
                <h3><a name="${name}"><font size="5">2.${index} ${name} ${definition.getDescription()!""}</font></a>
                </h3>
                <table border="1" cellspacing="0" cellpadding="0" width="100%">
                    <tr class="bg" align="center">
                        <td width="10%">序号</td>
                        <td width="20%">参数名</td>
                        <td width="20%">数据类型</td>
                        <td width="20%">是否必填</td>
                        <td width="30%">说明</td>
                    </tr>
                    <#if definition.getProperties()??&&(definition.getProperties()?size>0)>
                        <#assign properties=definition.getProperties()>
                        <@propertyShow properties=properties parentIndex="" />
                    </#if>
                    <#if definition.getReference()??>
                        <tr align="center">
                            <td>1</td>
                            <td>${name}</td>
                            <#assign ref=definition.getReference()?replace("#/definitions/","")>
                            <td><a href="#${ref}">${ref}</a></td>
                            <td>false</td>
                            <td>${definition.getDescription()!""}</td>
                        </tr>
                    </#if>
                </table>
                <br/>
                <#assign index=index+1>
            </#list>
        </#if>
        <br/>

        <h2>3.接口详细描述</h2>
        <br/>
        <#if t.getPaths()??&&(t.getPaths()?size>0)>
            <#assign paths=t.getPaths()>
            <#list paths?keys as path >
                <h3><font size="5">3.${path_index+1} ${path}</font></h3>
                <br/>
                <#assign methodIndex=1>
                <#assign resource=paths[path]>
                <#if resource.getDelete()??>
                    <#assign operation=resource.getDelete()>
                    <@operationBaseShow operation=operation parentIndex=3 path=path pathIndex=path_index+1  method="delete" methodIndex=methodIndex />
                    <#assign methodIndex=methodIndex+1>
                </#if>
                <#if resource.getGet()??>
                    <#assign operation=resource.getGet()>
                    <@operationBaseShow operation=operation parentIndex=3 path=path pathIndex=path_index+1 method="get" methodIndex=methodIndex />
                    <#assign methodIndex=methodIndex+1>
                </#if>
                <#if resource.getHead()??>
                    <#assign operation=resource.getHead()>
                    <@operationBaseShow operation=operation parentIndex=3 path=path pathIndex=path_index+1 method="head" methodIndex=methodIndex />
                    <#assign methodIndex=methodIndex+1>
                </#if>
                <#if resource.getOptions()??>
                    <#assign operation=resource.getOptions()>
                    <@operationBaseShow operation=operation parentIndex=3 path=path pathIndex=path_index+1 method="options" methodIndex=methodIndex />
                    <#assign methodIndex=methodIndex+1>
                </#if>
                <#if resource.getPatch()??>
                    <#assign operation=resource.getPatch()>
                    <@operationBaseShow operation=operation parentIndex=3 path=path pathIndex=path_index+1 method="patch" methodIndex=methodIndex />
                    <#assign methodIndex=methodIndex+1>
                </#if>
                <#if resource.getPost()??>
                    <#assign operation=resource.getPost()>
                    <@operationBaseShow operation=operation parentIndex=3 path=path pathIndex=path_index+1 method="post" methodIndex=methodIndex />
                    <#assign methodIndex=methodIndex+1>
                </#if>
                <#if resource.getPut()??>
                    <#assign operation=resource.getPut()>
                    <@operationBaseShow operation=operation parentIndex=3 path=path pathIndex=path_index+1 method="put" methodIndex=methodIndex />
                    <#assign methodIndex=methodIndex+1>
                </#if>
            </#list>
        </#if>
    </#list>
</div>
</body>
</html>
