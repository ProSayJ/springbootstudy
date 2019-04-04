package com.prosayj.springboot.utils;

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
import io.swagger.models.refs.GenericRef;
import io.swagger.parser.SwaggerParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {
    public static void main(String[] args) throws IOException {

        // 读文件:api
//        File fileSrc = new File("C:\\workspace\\idea_workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_api.json");
        File fileSrc = new File("C:\\workspace\\idea_workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_api.json");
//        File fileSrc = new File("D:\\workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_api.json");


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileSrc), "utf-8"));
        String jsonString = br.readLine().toString();
        Swagger swagger = new SwaggerParser().parse(jsonString);

        Info info = swagger.getInfo();
        String title = info.getTitle();
        String description = info.getDescription();
        String version = info.getVersion();
        String termsOfService = info.getTermsOfService();

        Contact contact = info.getContact();
        String email = contact.getEmail();
        String name = contact.getName();
        String url = contact.getUrl();
        License license = info.getLicense();

        StringBuffer stringBuffer = new StringBuffer();

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
            String licenseName = license.getName();
            String licenseUrl = license.getUrl();
            Map<String, Object> vendorExtensions = license.getVendorExtensions();
            System.out.println("证书名称:==>" + licenseName + ",证书url==>" + licenseUrl);
        }

        System.out.println(append);

        String host = swagger.getHost();
        System.out.println("host:==>" + host);

        String basePath = swagger.getBasePath();
        System.out.println("basePath:==>" + basePath);

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

        //paths

        Map<String, Path> paths = swagger.getPaths();
        paths.keySet().forEach(pathKey -> {
            stringBuffer.setLength(0);
            stringBuffer.append("path解析开始：\r\n");
            stringBuffer.append("请求url：" + pathKey + "\r\n");
            Path path = paths.get(pathKey);
            //Post请求
            if (path.getPost() != null) {
                Operation postOperation = path.getPost();
                List<String> postOperationTags = postOperation.getTags();
                stringBuffer.append("请求的tags是：==>" + postOperationTags.get(0) + "\r\n");


                String postOperationSummary = postOperation.getSummary();
                stringBuffer.append("本次请求的简要描述：==>" + postOperationSummary + "\r\n");

                String postOperationDescription = postOperation.getDescription();
                stringBuffer.append("本次请求的描述：==>" + postOperationDescription + "\r\n");

                List<String> postOperationConsumes = postOperation.getConsumes();
                stringBuffer.append("本次请求的返回参数：==>" + postOperationConsumes.get(0) + "\r\n");

                List<String> produces = postOperation.getProduces();
                stringBuffer.append("本次请求的produces：==>" + produces.get(0) + "\r\n");

                List<Parameter> postOperationParameters = postOperation.getParameters();
                postOperationParameters.forEach(parameter -> {
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
                    if (parameter instanceof BodyParameter) {
                        BodyParameter bodyParameter = (BodyParameter) parameter;

                        String parameterDescription = bodyParameter.getDescription();
                        stringBuffer.append("本次请求的参数描述：==>" + parameterDescription + "\r\n");

                        boolean parameterRequired = bodyParameter.getRequired();
                        stringBuffer.append("本次请求的参数是否必填：==>" + parameterRequired + "\r\n");

                        Model schema = bodyParameter.getSchema();
                        if (schema instanceof ArrayModel) {
                            ArrayModel arrayModel = (ArrayModel) schema;
                            String arrayModelType = arrayModel.getType();

                            stringBuffer.append("本次请求的参数明细：\r\n")
                                    .append("参数类型是：" + arrayModelType + "\r\n");


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



  /*                          Property items = arrayModel.getItems();
                            if(items instanceof LongProperty) {
                                LongProperty longProperty = (LongProperty) items;
                                String longPropertyType = longProperty.getType();
                                String format = longProperty.getFormat();
                            }
*/
                        }
                        if (schema instanceof RefModel) {
                            RefModel refModel = (RefModel) schema;
                            String parameterName = refModel.getSimpleRef();

                            stringBuffer.append("入参是对象：对象名称是：==>" + parameterName + "\r\n");
                            String $ref = refModel.get$ref();
                            String originalRef = refModel.getOriginalRef();
                        }


                    }//
                    if (parameter instanceof QueryParameter) {
                        QueryParameter queryParameter = (QueryParameter) parameter;
                        boolean parameterRequired = queryParameter.getRequired();
                        String queryParameterDescription = queryParameter.getDescription();
                        String queryParameterType = queryParameter.getType();
                        String queryParameterFormat = queryParameter.getFormat();
                        stringBuffer.append("入参是基本类型或者包装类型：其名称是：==>" + queryParameterDescription + ",是否是必传：" + parameterRequired + "\r\n");
                        stringBuffer.append("类型是：==>" + queryParameterType + ",格式是：" + queryParameterFormat + "\r\n");
                    }
                });
                System.out.println(stringBuffer);

                //一次请求的响应
                Map<String, Response> responses = postOperation.getResponses();
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
        });


        Map<String, Model> definitions = swagger.getDefinitions();





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
}
