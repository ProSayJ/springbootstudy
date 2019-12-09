package com.prosayj.springboot.utils.parseswagger;

import io.swagger.models.*;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.parameters.QueryParameter;
import io.swagger.models.properties.*;
import io.swagger.models.refs.GenericRef;
import io.swagger.parser.SwaggerParser;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author yangjian
 * @description 解析swagger
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/24 下午 10:19
 * @since 1.0.0
 */
public class PaserNew02 {
    public static void main(String[] args) throws IOException {
        String swaggerJosn = PaserSwaggerJson2Objects.getSwaggerJosn("api-docs.json");
        Swagger swagger = new SwaggerParser().parse(swaggerJosn);
        //paserBaseInfo(swagger);
        swagger.getPaths().forEach((url, path) -> {
            //dealPost(url, path.getPost(), swagger);
            dealGet(url, path.getGet(), swagger);
        });
    }

    /**
     * 处理get请求
     *
     * @param url
     * @param get
     * @param swagger
     */
    private static void dealGet(String url, Operation get, Swagger swagger) {
        if (get != null) {
            List<Parameter> getRequestParameters = get.getParameters();

            EntityDetail entityDetail = initCommon(url, "GET", get);
            List<EntityDetail.RequestParam> requestParams = entityDetail.getRequestParams();

            getRequestParameters.forEach((Parameter getRequestParameter) -> {
                if (getRequestParameter instanceof QueryParameter) {
                    EntityDetail.RequestParam requestParam = new EntityDetail.RequestParam();
                    requestParam.setParamKey(getRequestParameter.getName());
                    requestParam.setDataBody(((QueryParameter) getRequestParameter).getType());
                    requestParam.setParamType(getRequestParameter.getIn());
                    requestParam.setRequire(getRequestParameter.getRequired());
                    requestParam.setDes(getRequestParameter.getDescription());
                    requestParams.add(requestParam);
                }
            });
            System.out.println(entityDetail.toString());
        }

    }

    private static EntityDetail initCommon(String url, String requestWay, Operation operation) {
        EntityDetail entityDetail = new EntityDetail();
        entityDetail.setInterfaceDes(" 【" + operation.getSummary() + "】");
        entityDetail.setURL(url);
        entityDetail.setRequestWay(requestWay);
        entityDetail.setRequestType(operation.getConsumes().toString());
        entityDetail.setReturnType(operation.getProduces().toString());
        return entityDetail;
    }

    /**
     * 处理post请求
     *
     * @param url
     * @param post
     * @param swagger
     */
    private static void dealPost(String url, Operation post, Swagger swagger) {
        if (post != null) {
            //接口描述
            Map<String, String> interfaceDes = new HashMap<>();
            //请求示例
            Map<String, String> requestExample = new HashMap<>();
            //返回示例：
            Map<String, String> resopnseExample = new HashMap<>();
            //入参描述
            Map<String, String> inputDes = new HashMap<>();
            //出参描述
            Map<String, String> outPutDes = new HashMap<>();

            EntityDetail entityDetail = initCommon(url, "POST", post);

            List<Parameter> parameters = post.getParameters();
            parameters.forEach(parameter -> {
                dealReqAndRes4Post(parameter, post.getResponses(), swagger, entityDetail);
            });
        }

    }

    /**
     * 处理seagger基本信息
     *
     * @param swagger
     */
    private static void dealBaseInfo(Swagger swagger) {
        String documentDescription = swagger.getInfo().getDescription();
        String apiVersion = swagger.getInfo().getVersion();
        String apiTitle = swagger.getInfo().getTitle();
        String termsOfService = swagger.getInfo().getTermsOfService();
        License license = swagger.getInfo().getLicense();
        String licenseName = license.getName();
        String licenseUrl = license.getUrl();

        String swaggerVesion = swagger.getSwagger();
        String serviceHost = swagger.getHost();
        String basePath = swagger.getBasePath();
        Stream<Tag> tags = swagger.getTags().stream().sorted(Comparator.comparing(Tag::getName));
        tags.forEach(tag -> {
            System.out.println(tag.getName());
        });


    }

    /**
     * 处理Post请求的入参出参
     *
     * @param parameter    Post请求入参
     * @param responses    Post请求出参
     * @param swagger      swagger对象
     * @param entityDetail
     */
    private static void dealReqAndRes4Post(Parameter parameter, Map<String, Response> responses, Swagger swagger, EntityDetail entityDetail) {
        dealRequestParameter(parameter, swagger, entityDetail);
        dealResponseParameter(responses, swagger, entityDetail);
        System.out.println(entityDetail.toString());
        System.out.println();
    }

    /**
     * 处理返回值参数
     *
     * @param responses 返回值对象
     * @param swagger   swagger对象
     */
    private static void dealResponseParameter(Map<String, Response> responses, Swagger swagger, EntityDetail entityDetail) {
        System.out.println("解析返回值-stat");
        responses.forEach((responsesStatus, responseBody) -> {
            System.out.println("\t返回值：" + responsesStatus + "【" + responseBody.getDescription() + "】");

            List<EntityDetail.ResponseStatus> responseStatuses = entityDetail.getResponseStatuses();
            responseStatuses.add(new EntityDetail.ResponseStatus(responsesStatus, responseBody.getDescription(), responseBody.getDescription()));

            Model model = responseBody.getResponseSchema();
            if (model != null) {
                paserMode(model, null, false, swagger, entityDetail);
            }

        });
        System.out.println("解析返回值-end");
    }

    /**
     * 处理请求参数
     *
     * @param parameter 请求参数
     * @param swagger   swagger对象
     */
    private static void dealRequestParameter(Parameter parameter, Swagger swagger, EntityDetail entityDetail) {
        System.out.println("解析请求参数-stat");
        if (parameter instanceof BodyParameter) {
            BodyParameter bodyParameter = (BodyParameter) parameter;
            bodyParameter.getSchema().getReference();
            paserMode(bodyParameter.getSchema(), bodyParameter.getName(), bodyParameter.getRequired(), swagger, entityDetail);
        }
        //System.out.println("解析请求参数-end \t\n");
        System.out.println("解析请求参数-end");
    }

    /**
     * 解析Model
     *
     * @param requestParamSchema 请求体对象
     * @param parameterAlince    请求体对象别名(接口对接的key)
     * @param required           bean对象是否是必传
     * @param swagger            seagger对象
     */
    private static void paserMode(Model requestParamSchema, String parameterAlince, boolean required, Swagger swagger, EntityDetail entityDetail) {
        //请求参数是基本数据类型
        if (requestParamSchema instanceof ModelImpl) {
            ModelImpl requestParamModelImpl = (ModelImpl) requestParamSchema;
            String type = requestParamModelImpl.getType();
            String format = requestParamModelImpl.getFormat();
            List<String> isRequired = requestParamModelImpl.getRequired();
            System.out.println("\t基本数据类型：" + type + "\t\t\t" + format + "是否必须：" + isRequired);
        }
        //请求参数自定义数据类型
        if (requestParamSchema instanceof RefModel) {
            RefModel requestParamRefModel = (RefModel) requestParamSchema;
            String beanName = requestParamRefModel.getSimpleRef();
            getBeanModelDetail(beanName, parameterAlince, required, swagger, entityDetail);
        }
        //数组
        if (requestParamSchema instanceof ArrayModel) {
            String result = "Array[";
            ArrayModel arrayModel = (ArrayModel) requestParamSchema;
            Property currentArrayProperty = arrayModel.getItems();
            boolean isrequired = currentArrayProperty.getRequired();
            if (currentArrayProperty instanceof LongProperty) {
                result += 0 + "]";
            }
            if (currentArrayProperty instanceof IntegerProperty) {
                result += 0 + "]";
            }
            if (currentArrayProperty instanceof StringProperty) {
                result += "string" + "]";
            }
            if (currentArrayProperty instanceof ArrayProperty) {
                ArrayProperty arrayProperty = (ArrayProperty) currentArrayProperty;
                Property items = arrayProperty.getItems();
                if (items instanceof RefProperty) {
                    RefProperty refProperty = (RefProperty) items;
                    String beanName = refProperty.getSimpleRef();
                    result += beanName + "]";
                    //TODO bean描述
                }
            }
            if (currentArrayProperty instanceof GenericRef) {
                GenericRef genericRef = (GenericRef) currentArrayProperty;
                String beanName = genericRef.getSimpleRef();
                result += beanName + "]";
                //TODO bean描述
            }
            if (currentArrayProperty instanceof RefProperty) {
                RefProperty refProperty = (RefProperty) currentArrayProperty;
                String beanName = refProperty.getSimpleRef();
                result += beanName + "]";
                //TODO bean描述
            }
            System.out.println("数组：" + result + " 是否是必须：" + isrequired);
        }

        if (requestParamSchema instanceof ComposedModel) {
        }

    }

    /**
     * 通过bean名称获取属性值和描述
     *
     * @param beanName        bean的非全限定性类名
     * @param parameterAlince bean对象别名
     * @param required        bean对象是否是必传
     * @param swagger         swagger对象
     */
    private static void getBeanModelDetail(String beanName, String parameterAlince, boolean required, Swagger swagger, EntityDetail entityDetail) {
        swagger.getDefinitions().forEach((String beanNameFromPool, Model beanDetail) -> {
            if (beanNameFromPool.equals(beanName)) {
                System.out.println("\t自定义数据类型：" + beanName + " " + parameterAlince + " ,是否必须：" + required);
                //遍历自定义数据的值：
                beanDetail.getProperties().forEach((String currentPropertiesKey, Property currentProperty) -> {
                    String description = currentProperty.getDescription();
                    String valueType = currentProperty.getType();
                    boolean isRequored = currentProperty.getRequired();
                    String format = currentProperty.getFormat();

                    String result = "";
                    //属性是Long类型
                    if (currentProperty instanceof LongProperty) {
                        result += 0;
                    }
                    //属性是Integer类型
                    if (currentProperty instanceof IntegerProperty) {
                        result += 0;
                    }
                    //属性是String类型
                    if (currentProperty instanceof StringProperty) {
                        result += "string";
                        //字符串的format是null，故这里手动赋值
                        format = "string";
                    }
                    //属性是DateTime类型
                    if (currentProperty instanceof DateTimeProperty) {
                        result += new Date().getTime();
                    }
                    //属性是数组，则获取属性数组里面的元素
                    if (currentProperty instanceof ArrayProperty) {
                        //array的format是null，故这里手动赋值
                        format = "Array";
                        Property items = ((ArrayProperty) currentProperty).getItems();
                        //数组内的元素是Long
                        if (items instanceof LongProperty) {
                            result += "Array[" + 0L + "]";
                        }
                        //数组内的元素是String
                        if (items instanceof StringProperty) {
                            result += "Array[" + "" + "]";
                        }
                        //数组内的元素是自定义对象
                        if (items instanceof RefProperty) {
                            //System.out.println("===================>RefProperty" + items);
                            RefProperty refProperty = (RefProperty) items;
                            String beanNameInner = refProperty.getSimpleRef();
                            result += "Array[" + beanNameInner + "]";
                            //TODO bean描述
                        }
                        if (items instanceof GenericRef) {
                            //System.out.println("===================>GenericRef");
                            GenericRef genericRef = (GenericRef) currentProperty;
                            String beanNameInner = genericRef.getSimpleRef();
                            result += "Array[" + beanNameInner + "]";
                            //TODO bean描述
                        }
                    }

                    if (currentProperty instanceof GenericRef) {
                        //System.out.println("===================>GenericRef");
                        GenericRef genericRef = (GenericRef) currentProperty;
                        String beanNameInner = genericRef.getSimpleRef();
                        result += "Array[" + beanNameInner + "]";
                        //TODO bean描述
                    }
                    if (currentProperty instanceof RefProperty) {
                        //System.out.println("===================>GenericRef");
                        RefProperty refProperty = (RefProperty) currentProperty;
                        String beanNameInner = refProperty.getSimpleRef();
                        result += "Array[" + beanNameInner + "]";
                        //TODO bean描述
                    }

                    System.out.println("\t\t名称：" + currentPropertiesKey +
                            " 描述：" + description +
                            " 类型：" + valueType +
                            " 属性format：" + format +
                            " 非空：" + isRequored +
                            " 属性示例：" + result);
                });

            }
        });

    }
}
