package com.prosayj.springboot.utils.parseswagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.prosayj.springboot.constants.Constants;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.models.*;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.parameters.QueryParameter;
import io.swagger.models.parameters.RefParameter;
import io.swagger.models.properties.LongProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.refs.GenericRef;
import io.swagger.parser.SwaggerParser;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class PaserSwaggerJson2Objects {
    public static void main(String[] args) throws IOException {
        Swagger swagger = new SwaggerParser().parse(getSwaggerJosn("api-docs_api.json"));
        HashMap<String, String> swaggerInfo = getSwaggerInfo(swagger);
        List<Map<String, Object>> requestAndResponse = getRequestAndResponse(swagger);
        List<Map<String, List<Map<String, String>>>> entityDetailList = getEntityDetailList(swagger);

        dealrequestAndResponseParams(requestAndResponse, entityDetailList, swagger);

        Map<String, List<Map<String, String>>> swaggerTagsInfo = getSwaggerTagsInfo(swagger);


        System.out.println(requestAndResponse);


/*

        Info info = swagger.getInfo();
        String host = swagger.getHost();
        List<String> produces = swagger.getProduces();
        Path path = swagger.getPath("/functiontree/create");
        Operation post = path.getPost();
        List<String> tags = post.getTags();
        post.getSchemes();
        System.out.println(swagger.toString());
        swagger.getInfo().getTitle();
*/
    }

    public static Map<String, List<Map<String, String>>> getSwaggerTagsInfo(Swagger swagger) {
        Map<String, List<Map<String, String>>> result = new HashMap<>(1);
        List<Map<String, String>> tagList = new ArrayList<>(swagger.getTags().size());

        List<Tag> tags = swagger.getTags();
        tags.forEach(tag -> {
            HashMap<String, String> tagMap = new HashMap<>(2);
            tagMap.put("tagName", tag.getName());
            tagMap.put("tagDescription", tag.getDescription());
            tagList.add(tagMap);
        });

        result.put("tagDetails", tagList);
        return result;


    }

    public static void dealrequestAndResponseParams(List<Map<String, Object>> requestAndResponse, List<Map<String, List<Map<String, String>>>> entityDetailList, Swagger swagger) {
        Map<String, Model> definitions = swagger.getDefinitions();

        requestAndResponse.forEach(data -> {
            String requestParameterType = (String) data.get("requestParameterType");
            if ("Object".equals(requestParameterType)) {
                String parameterObjectName = (String) data.get("requestParameterObjectName");
                entityDetailList.forEach(entityDetailMap -> {
                    entityDetailMap.keySet().forEach(entityName -> {
                        //如果是對象，则添加对象的属性的描述信息
                        if (entityName.equals(parameterObjectName)) {
                            List<Map<String, String>> entityPropertiesDetailsList = entityDetailMap.get(entityName);

                            Map<String, String> entityMap = new HashMap<>();

                            entityPropertiesDetailsList.forEach(entityPropertieDetailMap -> {
                                String propertiesName = entityPropertieDetailMap.get("propertiesName");
                                entityMap.put(propertiesName, " ");
                            });

                            data.put("entityPropertiesDetail", entityPropertiesDetailsList);
                            data.put("prettyJson", gsonFormatter(entityMap, true));
                            data.put(Constants.SWAGGER_REQUEST_PARAMETER_OBJECT_NAME, parameterObjectName);
                        }

                    });
                });
            }
            if ("baseParam".equals(requestParameterType)) {
                //基本数据类型已经处理
                /*
                entityDetailList.forEach(entity -> {
                    entity.keySet().forEach(moduleName -> {
                        //如果是對象，则添加对象的属性的描述信息
                        List<Map<String, String>> entityPropertiesDetail = entity.get(moduleName);
                        data.put("entityPropertiesDetail",entityPropertiesDetail);
                    });
                });
                */
            }
            if ("array".equals(requestParameterType)) {

            }
        });
//        System.out.println(requestAndResponse);
    }

    /**
     * 获取Swagger的json数据源
     *
     * @return
     * @throws IOException
     */
    public static String getSwaggerJosn(String fileName) throws IOException {
// 读文件:api
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        String filePath = url.getPath() + "export/in/" + fileName;

        File fileSrc = new File(filePath);

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileSrc), "utf-8"));
        String jsonString = br.readLine().toString();
        br.close();
        return jsonString;
    }

    /**
     * 获取请求的输入响应对象
     *
     * @param swagger
     * @return
     */
    public static List<Map<String, Object>> getRequestAndResponse(Swagger swagger) {
        List<Map<String, Object>> requestAndResponseList = new ArrayList<>();

        StringBuffer stringBuffer = new StringBuffer();
        //paths一次请求了
        Map<String, Path> paths = swagger.getPaths();
        paths.keySet().forEach(pathKey -> {
            Map<String, Object> postRequestAndResponseMap = new HashMap<>();
            stringBuffer.setLength(0);
            stringBuffer.append("path解析开始：\r\n");
            stringBuffer.append("请求url：" + pathKey + "\r\n");
            postRequestAndResponseMap.put(Constants.SWAGGER_PROPERTIES_URL, pathKey);
            Path path = paths.get(pathKey);
            //Post请求
            if (path.getPost() != null) {
                Operation postOperation = path.getPost();
                String postOperationOperation = postOperation.getOperationId();
                stringBuffer.append("请求方式是：==>Post \r\n");
                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_WAY, "Post");

                List<String> postOperationTags = postOperation.getTags();
                stringBuffer.append("请求的tags是：==>" + postOperationTags.get(0) + "\r\n");
                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_TAG, postOperationTags.get(0));

                String postOperationSummary = postOperation.getSummary();
                stringBuffer.append("本次请求的简要描述：==>" + postOperationSummary + "\r\n");
                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_POST_OPERATION_SUMMARY, postOperationSummary);

                String postOperationDescription = postOperation.getDescription();
                stringBuffer.append("本次请求的描述：==>" + postOperationDescription + "\r\n");
                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_POST_OPERATION_DESCRIPTION, postOperationDescription);

                List<String> postOperationConsumes = postOperation.getConsumes();
                stringBuffer.append("本次请求的返回数据类型：==>" + postOperationConsumes.get(0) + "\r\n");
                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_POST_OPERATION_CONSUMES, postOperationConsumes.get(0));

                List<String> produces = postOperation.getProduces();
                stringBuffer.append("本次请求的produces：==>" + produces.get(0) + "\r\n");
                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_POST_PRODUCES, produces.get(0));

                List<Parameter> postOperationParameters = postOperation.getParameters();
                postOperationParameters.forEach(parameter -> {
                    //请求参数是数组：
                    /*
                    if (parameter instanceof ArrayModel) {
                        ArrayModel arrayModel = (ArrayModel) parameter;

                        String arrayModelDescription = arrayModel.getDescription();
                        stringBuffer.append("本次请求的参数描述：==>" + arrayModelDescription + "\r\n");

                        String arrayModelType = arrayModel.getType();
                        stringBuffer.append("本次请求的参数类型：==>" + arrayModelType + "\r\n");

                        Map<String, Property> properties = arrayModel.getProperties();
                        properties.keySet().forEach(producesKey -> {
                            Property propertyValue = properties.get(producesKey);
                            boolean required = propertyValue.getRequired();
                        });
                    }
                    */
                    //post请求参数是对象
                    if (parameter instanceof BodyParameter) {
                        BodyParameter bodyParameter = (BodyParameter) parameter;

                        String parameterDescription = bodyParameter.getDescription();
                        stringBuffer.append("本次请求的对象参数描述：==>" + parameterDescription + "\r\n");
                        postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_DESCRIPTION, parameterDescription);

                        boolean parameterRequired = bodyParameter.getRequired();
                        stringBuffer.append("本次请求的对象参数是否必填：==>" + parameterRequired + "\r\n");
                        postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_MUST_SEND, String.valueOf(parameterRequired));

                        Model schema = bodyParameter.getSchema();
                        //对象是数组：
                        if (schema instanceof ArrayModel) {
                            postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_TYPE, "array");
                            ArrayModel arrayModel = (ArrayModel) schema;
                            String arrayModelType = arrayModel.getType();
                            stringBuffer.append("本次请求的参数明细：\r\n")
                                    .append("参数类型是：" + arrayModelType + "\r\n");


                            /*
                            Map<String, Property> properties = arrayModel.getProperties();
                            if (properties != null) {
                                properties.keySet().forEach(propertiesKey -> {
                                    stringBuffer.append("参数key：==>" + propertiesKey + "\r\n");

                                    Property propertyValue = properties.get(propertiesKey);

                                    String type = propertyValue.getType();
                                    stringBuffer.append("参数类型：==>" + type + "\r\n");

                                    boolean required = propertyValue.getRequired();
                                    stringBuffer.append("参数是否必传：==>" + required + "\r\n");
                                });
                            }
                            */

                            Property items = arrayModel.getItems();
                            //数组内部的元素类型
                            String type = items.getType();
                            String format = items.getFormat();
                            System.out.println("入参是数组：类型是：" + type + ",格式是：" + format);
                            //数组里面的对象是基本数据类型
                            if (!"ref".equals(type) && format != null) {
                                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_ARRAYS_VALUE_TYPE, type);
                                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_ARRAYS_VALUE_EXAMPLE, format);
                            } else {
                                //数组里面的对象是自定义数据类型
                                RefProperty refProperty = (RefProperty) arrayModel.getItems();
                                String propertySimpleRefObjectName = refProperty.getSimpleRef();
                                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_ARRAYS_VALUE_TYPE, type);
                                postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_ARRAYS_OBJECT_NAME, propertySimpleRefObjectName);
                            }
                        }
                        //对象是自定义的对象
                        if (schema instanceof RefModel) {
                            postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_TYPE, "Object");
                            RefModel refModel = (RefModel) schema;
                            String parameterName = refModel.getSimpleRef();

                            stringBuffer.append("入参是对象：对象名称是：==>" + parameterName + "\r\n");
                            String $ref = refModel.get$ref();
                            String originalRef = refModel.getOriginalRef();
                            postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_OBJECT_NAME, parameterName);
                        }


                    }
                    //请求参数是基本数据
                    if (parameter instanceof QueryParameter) {
                        postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_TYPE, "baseParam");

                        QueryParameter queryParameter = (QueryParameter) parameter;
                        boolean parameterRequired = queryParameter.getRequired();
                        String queryParameterDescription = queryParameter.getDescription();
                        String queryParameterType = queryParameter.getType();
                        String queryParameterFormat = queryParameter.getFormat();
                        Object example = queryParameter.getExample();

                        stringBuffer.append("入参是基本类型或者包装类型：其名称是：==>" + queryParameterDescription + ",是否是必传：" + parameterRequired + "\r\n");
                        stringBuffer.append("类型是：==>" + queryParameterType + ",格式是：" + queryParameterFormat + "\r\n");

                        postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_QUERY_PARAMETER_BASEPARAM_DESCRIPTION, queryParameterDescription);
                        postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_QUERY_PARAMETER_BASEPARAM_TYPE, queryParameterType);
                        postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_QUERY_PARAMETER_BASEPARAM_REQUIRE, String.valueOf(parameterRequired));
                        postRequestAndResponseMap.put(Constants.SWAGGER_REQUEST_PARAMETER_QUERY_PARAMETER_BASEPARAM_FORMAT, queryParameterFormat);

                    }
                });
                System.out.println(stringBuffer);

                //一次请求的响应
                Map<String, Response> responses = postOperation.getResponses();
                responses.keySet().forEach(responsesKey -> {
                    Response response = responses.get(responsesKey);
                    String responseDescription = response.getDescription();
                });
                requestAndResponseList.add(postRequestAndResponseMap);
            }

            Operation operationHead = path.getHead();
            Map<HttpMethod, Operation> operationMap = path.getOperationMap();
            List<Parameter> parameters = path.getParameters();
            if (parameters != null) {
                parameters.forEach(parameter -> {
                    String parameterName = parameter.getName();
                    String description1 = parameter.getDescription();
                    boolean parameterRequired = parameter.getRequired();
                    String access = parameter.getAccess();
                    String in = parameter.getIn();
                    Map<String, Object> vendorExtensions = parameter.getVendorExtensions();
                });
            }
            if (path.getGet() != null) {
//                System.out.println("1111");

            }
        });
        return requestAndResponseList;

    }

    /**
     * swagger对象获取swaggerInfo基本信息
     *
     * @param swagger
     */
    public static HashMap<String, String> getSwaggerInfo(Swagger swagger) {
        HashMap<String, String> swaggerInfoMap = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();


        Info info = swagger.getInfo();
        String title = info.getTitle();
        String description = info.getDescription();
        String version = swagger.getSwagger();
        String termsOfService = info.getTermsOfService();

        Contact contact = info.getContact();
        String email = contact.getEmail();
        String name = contact.getName();
        String url = contact.getUrl();
        License license = info.getLicense();
        String host = swagger.getHost();
        String basePath = swagger.getBasePath();

        String licenseName = "";
        String licenseUrl = "";
        //Info:
        StringBuffer append = stringBuffer.append("swagger-info基本信息:\r\n")
                .append("标题:==>")
                .append(title)
                .append("描述:==>")
                .append(description + "\r\n")
                .append("版本:==>")
                .append(version + "\r\n")
                .append("termsOfService:==>")
                .append(termsOfService + "\r\n")
                .append("联系-邮箱:==>")
                .append(email + "\r\n")
                .append("联系-名称:==>")
                .append(name + "\r\n")
                .append("联系-url:==>")
                .append(url + "\r\n");
        if (license != null) {
            licenseName = license.getName();

            licenseUrl = license.getUrl();

            Map<String, Object> vendorExtensions = license.getVendorExtensions();
            System.out.println("证书名称:==>" + licenseName + ",证书url==>" + licenseUrl);
        }
        swaggerInfoMap.put(Constants.SWAGGER_INFO_TITLE, title);
        swaggerInfoMap.put(Constants.SWAGGER_INFO_DESCRIPTION, description);
        swaggerInfoMap.put(Constants.SWAGGER_INFO_VERSION, version);
        swaggerInfoMap.put(Constants.SWAGGER_INFO_TERMS_Of_SERVICE, termsOfService);
        swaggerInfoMap.put(Constants.SWAGGER_INFO_EMAIL, email);
        swaggerInfoMap.put(Constants.SWAGGER_INFO_NAME, name);
        swaggerInfoMap.put(Constants.SWAGGER_INFO_URL, url);

        swaggerInfoMap.put(Constants.SWAGGER_INFO_LICENSE_NAME, licenseName);
        swaggerInfoMap.put(Constants.SWAGGER_INFO_LICENSE_URL, licenseUrl);

        System.out.println("host:==>" + host);
        swaggerInfoMap.put(Constants.SWAGGER_HOST, host);


        System.out.println("basePath:==>" + basePath);
        swaggerInfoMap.put(Constants.SWAGGER_BASE_PATH, basePath);

        //Tags
        stringBuffer.setLength(0);
        stringBuffer.append("swagger-tag基本信息:\r\n");
        List<Tag> tags = swagger.getTags();
        tags.forEach(tag -> {
            String tagDescription = tag.getDescription();
            stringBuffer.append("tag描述：==>").append(tagDescription);
            String tagName = tag.getName();
            stringBuffer.append(" tag名称：==>").append(tagName + "\r\n");

            ExternalDocs externalDocs = tag.getExternalDocs();
            if (externalDocs != null) {
                String externalDocsDescription = externalDocs.getDescription();
                String externalDocsUrl = externalDocs.getUrl();
                Map<String, Object> externalDocsVendorMap = externalDocs.getVendorExtensions();
                System.out.println("tagExternalDocsDescription:==>" + externalDocsDescription + "URLExternalDocsDescription==>" + externalDocsUrl);
            }
            Map<String, Object> getVendorExtensionsMap = tag.getVendorExtensions();
            if (getVendorExtensionsMap.size() > 0) {
                getVendorExtensionsMap.keySet().forEach(key -> {
                    System.out.println(key + "<====>" + getVendorExtensionsMap.get(key));
                });
            }
        });
        System.out.println(stringBuffer);
        return swaggerInfoMap;
    }

    /**
     * swagger对象组装实体对象集合
     * [
     * <对象实体名称，
     * [
     * <对象属性名称，String>
     * <对象属性类型：String>
     * <对象属性描述：String>
     * <是否是必填：String>
     * ]
     * >
     * ]
     *
     * @param swagger
     * @return
     */
    public static List<Map<String, List<Map<String, String>>>> getEntityDetailList(Swagger swagger) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Map<String, List<Map<String, String>>>> entityDetailList = new ArrayList<>();

        Map<String, Model> definitions = swagger.getDefinitions();
        definitions.keySet().forEach(definitionKey -> {
            Map<String, String> entityDefayltValueMap = new HashMap<>();

            stringBuffer.setLength(0);
            stringBuffer.append("对象的名称是：" + definitionKey + "\r\n");
            ModelImpl model = (ModelImpl) definitions.get(definitionKey);
            List<String> required = model.getRequired();
            Map<String, Property> properties = model.getProperties();

            //一个对象一个map
            Map<String, List<Map<String, String>>> entityMap = new HashMap<>();
            //一个对象内部是一个属性的list
            List<Map<String, String>> pripertiesDetails = new ArrayList<>();

            properties.keySet().forEach(propertieKey -> {
                //属性的默认值
                entityDefayltValueMap.put(propertieKey, "");

                Property property = properties.get(propertieKey);
                String propertyType = property.getType();
                String propertyDescription = property.getDescription();
                boolean propertyRequired = property.getRequired();

                stringBuffer.append("该象的属性名称是：" + propertieKey + ",该象的属性类型是：" + propertyType + ",描述是：" + propertyDescription + ",是否是必填：" + propertyRequired);
                stringBuffer.append("\r\n");

                //封装所有属性描述
                Map<String, String> propertiesDes = new HashMap<>();
                propertiesDes.put(Constants.SWAGGER_PROPERTIES_NAME, propertieKey);
                propertiesDes.put(Constants.SWAGGER_PROPERTIES_TYPE, propertyType);
                propertiesDes.put(Constants.SWAGGER_PROPERTIES_DES, propertyDescription);
                propertiesDes.put(Constants.SWAGGER_PROPERTIES_REQURIED, String.valueOf(propertyRequired));
                pripertiesDetails.add(propertiesDes);
            });
            entityMap.put(definitionKey, pripertiesDetails);
            //

            entityDetailList.add(entityMap);


//            String s = gsonFormatter(entityDefayltValueMap, true);
//            stringBuffer.append("对象的属性名称都列举完了，我们看下它的json格式的字符串：" + s);
//            System.out.println(stringBuffer.toString());
        });
//        System.out.println("所有对象属性的Map表示是:" + entityDetailList);
        return entityDetailList;

    }

    /**
     * 使用Gson格式化对象，返回json
     *
     * @param object     对象内容
     * @param needPrerry 是否需要美化：treu：需要
     * @return
     */
    public static String gsonFormatter(Object object, boolean needPrerry) {
        Gson gson = null;
        if (needPrerry) {
            gson = new GsonBuilder().setPrettyPrinting().create();
        } else {
            gson = new Gson();
        }
        if (gson == null) {
            return "";
        }
        JsonReader reader = new JsonReader(new StringReader(gson.toJson(object)));
        reader.setLenient(true);
        JsonParser jsonPar = new JsonParser();
        JsonElement jsonEl = jsonPar.parse(reader);
        String prettyJson = gson.toJson(jsonEl);
        return prettyJson;

    }

}
