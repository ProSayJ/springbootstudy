package com.prosayj.springboot.utils.parseswagger;

import io.swagger.models.*;
import io.swagger.models.parameters.*;
import io.swagger.models.properties.*;
import io.swagger.models.refs.GenericRef;
import io.swagger.parser.SwaggerParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 06:42
 * @since 1.0.0
 */
public class PaserNew {
    public static void main(String[] args) throws IOException {
        String swaggerJosn = PaserSwaggerJson2Objects.getSwaggerJosn("api-docs_user.json");
        Swagger swagger = new SwaggerParser().parse(swaggerJosn);
        Map<String, Path> paths = swagger.getPaths();
        paths.forEach((url, path) -> {
            Operation get = path.getGet();
            Operation post = path.getPost();
            if (post != null) {
                System.out.println("接口url是：" + url + " 【" + post.getSummary() + "】");

                if (url.equals("/functiontree/get")) {
                    System.out.println("");
                }
                List<Parameter> parameters = post.getParameters();
                parameters.forEach(parameter -> {
                    dealReqAndRes4Post(parameter, post.getResponses(), swagger);
//                    dealCookieParameter(parameter, swagger);
//                    dealFormParameter(parameter, swagger);
//                    dealHeaderParameter(parameter, swagger);
//                    dealPathParameter(parameter, swagger);
//                    dealRefParameter(parameter, swagger);
                });

            }

        });


    }


    /**
     * 解析Post请求数据
     *
     * @param parameter 请求参数
     * @param responses 返回值
     * @param swagger   swagger对象
     */
    private static void dealReqAndRes4Post(Parameter parameter, Map<String, Response> responses, Swagger swagger) {
        dealRequestParameter(parameter, swagger);
        dealResponseParameter(responses, swagger);
        System.out.println();
    }

    private static void dealRequestParameter(Parameter parameter, Swagger swagger) {
        System.out.println("解析请求参数-stat");
        if (parameter instanceof BodyParameter) {
            BodyParameter bodyParameter = (BodyParameter) parameter;
            bodyParameter.getSchema().getReference();
            String parameterName = bodyParameter.getName();
            boolean required = bodyParameter.getRequired();
            Model model = bodyParameter.getSchema();
            dealMode(model, swagger, parameterName, required);
        }
        System.out.println("解析请求参数-end");

    }

    private static void dealResponseParameter(Map<String, Response> responses, Swagger swagger) {
        System.out.println("解析返回值-stat");
        responses.forEach((responsesStatus, responseBody) -> {
            System.out.println("\t返回值：" + responsesStatus + "【" + responseBody.getDescription() + "】");
            Model model = responseBody.getResponseSchema();
            if (model != null) {
                dealMode(model, swagger, null, false);
            }

        });
        System.out.println("解析返回值-end");
    }

    /**
     * 解析Model
     *
     * @param model           待解析对象
     * @param swagger         swagger对象
     * @param parameterAlince model别名 对象的小写
     * @param required        是否是必填
     */
    private static void dealMode(Model model, Swagger swagger, String parameterAlince, boolean required) {
        //基本数据类型
        if (model instanceof ModelImpl) {
            ModelImpl modelImpl = (ModelImpl) model;
            System.out.println("\t\t基本数据类型：" + modelImpl.getType() + " " + modelImpl.getFormat() + " 是否必须：" + modelImpl.getRequired());
        }
        //自定义数据类型
        if (model instanceof RefModel) {
            RefModel refModel = (RefModel) model;
            String simpleRef = refModel.getSimpleRef();
            getRefModelDetail(swagger, simpleRef, parameterAlince, required);
        }
        //数组
        if (model instanceof ArrayModel) {
            String result = "Array[";
            ArrayModel arrayModel = (ArrayModel) model;
            Property currentProperty = arrayModel.getItems();
            boolean isrequired = currentProperty.getRequired();
            if (currentProperty instanceof LongProperty) {
                result += 0 + "]";
            }
            if (currentProperty instanceof IntegerProperty) {
                result += 0 + "]";
            }
            if (currentProperty instanceof StringProperty) {
                result += "\"\"" + "]";
            }
            if (currentProperty instanceof ArrayProperty) {
                ArrayProperty arrayProperty = (ArrayProperty) currentProperty;
                Property items = arrayProperty.getItems();
                if (items instanceof RefProperty) {
                    RefProperty refProperty = (RefProperty) items;
                    String beanName = refProperty.getSimpleRef();
                    result += beanName + "]";
                    //TODO bean描述
                }
            }
            if (currentProperty instanceof GenericRef) {
                GenericRef genericRef = (GenericRef) currentProperty;
                String beanName = genericRef.getSimpleRef();
                result += beanName + "]";
                //TODO bean描述
            }
            if (currentProperty instanceof RefProperty) {
                RefProperty refProperty = (RefProperty) currentProperty;
                String beanName = refProperty.getSimpleRef();
                result += beanName + "]";
                //TODO bean描述
            }
            System.out.println("数组：" + result + " 是否是必须：" + isrequired);
            //getInitDate(arrayProperty, swagger);
        }

        if (model instanceof ComposedModel) {

        }
    }

    /**
     * @param swagger
     * @param simpleRef        数据类型
     * @param simpleRefAlience 数据类型别名
     * @param required
     */
    private static void getRefModelDetail(Swagger swagger, String simpleRef, String simpleRefAlience, boolean required) {
        swagger.getDefinitions().forEach((String modelKey, Model modelDetail) -> {
            if (modelKey.equals(simpleRef)) {
                System.out.println("\t\t自定义数据类型：" + modelKey + " " + (simpleRefAlience == null ? simpleRef : simpleRefAlience) + " ,是否必须：" + required);
                //遍历自定义数据的值：
                modelDetail.getProperties().forEach((String currentPropertiesKey, Property currentProperty) -> {
                    String description = currentProperty.getDescription();
                    String valueType = currentProperty.getType();
                    boolean isRequored = currentProperty.getRequired();
                    String format = currentProperty.getFormat();

                    String result = "";
                    if (currentProperty instanceof LongProperty) {
                        result += 0;
                    }
                    if (currentProperty instanceof IntegerProperty) {
                        result += 0;
                    }
                    if (currentProperty instanceof StringProperty) {
                        result += "\"\"";
                    }
                    if (currentProperty instanceof ArrayProperty) {
                        ArrayProperty arrayProperty = (ArrayProperty) currentProperty;
                        Property items = arrayProperty.getItems();
                        if (items instanceof RefProperty) {
                            RefProperty refProperty = (RefProperty) items;
                            String beanName = refProperty.getSimpleRef();
                            result += "Array[" + beanName + "]";
                            //TODO bean描述
                        }
                    }
                    if (currentProperty instanceof GenericRef) {
                        GenericRef genericRef = (GenericRef) currentProperty;
                        String beanName = genericRef.getSimpleRef();
                        result += "Array[" + beanName + "]";
                        //TODO bean描述
                    }
                    if (currentProperty instanceof RefProperty) {
                        RefProperty refProperty = (RefProperty) currentProperty;
                        String beanName = refProperty.getSimpleRef();
                        result += "Array[" + beanName + "]";
                        //TODO bean描述
                    }

                    System.out.println("\t\t\t属性名称：" + currentPropertiesKey +
                            "\t属性描述：" + description +
                            "\t, 属性类型：" + valueType +
                            "\t, 属性format：" + format +
                            "\t, 属性是否必须：" + isRequored +
                            "\t, 属性示例：" + result);
                    //+ getInitDate(currentPropertiesValue, swagger));


                    //dealEntityProperty(currentPropertiesKey, currentPropertiesValue, swagger);


                });

            }
        });
    }

    /**
     * 处理自定义对象的propertiesKey对应的value值
     *
     * @param currentPropertiesKey
     * @param currentPropertiesValue 父对象中的属性对象
     */
    private static void dealEntityProperty(String currentPropertiesKey, Property currentPropertiesValue, Swagger swagger) {
        Map<String, String> result = new HashMap<>();


        System.out.println("\t\t\t" + currentPropertiesKey + "\t"
                + currentPropertiesValue.getDescription() + "\t"
                + currentPropertiesValue.getType() + "\t"
                + currentPropertiesValue.getRequired() + "\t"
                + getInitDate(currentPropertiesValue, swagger));
    }

    private static Object getInitDate(Property currentProperty, Swagger swagger) {
        String type = currentProperty.getType();
        boolean required = currentProperty.getRequired();
        Object result = null;
        if (currentProperty instanceof LongProperty) {
            result = 0L;
            return result;
        }
        if (currentProperty instanceof IntegerProperty) {
            result = 0;
            return result;
        }
        if (currentProperty instanceof StringProperty) {
            result = "\"\"";
            return result;
        }
        if (currentProperty instanceof ArrayProperty) {
            ArrayProperty arrayProperty = (ArrayProperty) currentProperty;
            Property items = arrayProperty.getItems();
            if (items instanceof RefProperty) {
                RefProperty refProperty = (RefProperty) items;
                String properties = refProperty.getSimpleRef();
                return "Array[" + properties + "]";
            }
        }


        if (currentProperty instanceof GenericRef) {
            GenericRef genericRef = (GenericRef) currentProperty;
            String simpleRef = genericRef.getSimpleRef();
            getRefModelDetail(swagger, simpleRef, simpleRef, required);
        }
        if (currentProperty instanceof RefProperty) {
            RefProperty refProperty = (RefProperty) currentProperty;
            String simpleRef = refProperty.getSimpleRef();
            getRefModelDetail(swagger, simpleRef, simpleRef, required);
        }


        return result;
    }


    private static void dealFormParameter(Parameter parameter, Swagger swagger) {
        if (parameter instanceof FormParameter) {
            FormParameter formParameter = (FormParameter) parameter;
            System.out.println("formParameter");
        }
    }

    private static void dealHeaderParameter(Parameter parameter, Swagger swagger) {
        if (parameter instanceof HeaderParameter) {
            HeaderParameter headerParameter = (HeaderParameter) parameter;
            System.out.println("headerParameter");
        }
    }

    private static void dealRefParameter(Parameter parameter, Swagger swagger) {
        if (parameter instanceof RefParameter) {
            RefParameter refParameter = (RefParameter) parameter;
            System.out.println("refParameter");
        }
    }


    private static void dealPathParameter(Parameter parameter, Swagger swagger) {
        if (parameter instanceof PathParameter) {
            PathParameter pathParameter = (PathParameter) parameter;
            System.out.println("parameter");
        }
    }

    private static void dealCookieParameter(Parameter parameter, Swagger swagger) {
        if (parameter instanceof CookieParameter) {
            CookieParameter cookieParameter = (CookieParameter) parameter;
            System.out.println("cookieParameter");
        }
    }

}
