package com.prosayj.springboot.utils.swagger2pdfutil;


import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 11:33
 * @since 1.0.0
 */
public class test {
    public static void main(String[] args) throws Exception {
        getMap();

    }

    public static Map<String, Object> getMap() throws Exception {
        // 读文件:user
//        File file = new File("C:\\workspace\\idea_workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_user.json");
//        File file = new File("D:\\workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_user.json");

        // 读文件:api
        File file = new File("C:\\workspace\\idea_workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_api.json");
//        File file = new File("D:\\workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_api.json");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        String jsonString = br.readLine().toString();
        System.out.println(jsonString);
/*
        JSONObject jsonObject = new JSONObject(jsonString);
        jsonObject.getJSONObject("definitions")
                */


        Gson gson = new Gson();
        HttpEntity result = new HttpEntity();
        Map<String, Object> map = gson.fromJson(jsonString, Map.class);
        map.keySet().forEach(key -> {
            switch (key) {
                case "swagger": {
                    result.setSwagger((String) map.get(key));
                    break;
                }
                case "info": {
                    Map<String, Object> info = (Map<String, Object>) map.get("info");
                    Info info1 = new Info();
                    info.keySet().forEach(infoKey -> {
                        if (infoKey.equals("description")) {
                            info1.setDescription((String) info.get("description"));
                        }
                        if (infoKey.equals("version")) {
                            info1.setVersion((String) info.get("version"));
                        }
                        if (infoKey.equals("title")) {
                            info1.setTitle((String) info.get("title"));
                        }
                        if (infoKey.equals("termsOfService")) {
                            info1.setTermsOfService((String) info.get("termsOfService"));
                        }
                        if (infoKey.equals("contact")) {
                            Map<String, String> contact = (Map<String, String>) info.get("contact");
                            Contact contact1 = new Contact();
                            contact.keySet().forEach(contactKey -> {
                                if (contactKey.equals("name")) {
                                    contact1.setName(contact.get("name"));
                                }
                                if (contactKey.equals("url")) {
                                    contact1.setUrl(contact.get("url"));
                                }
                                if (contactKey.equals("email")) {
                                    contact1.setEmail(contact.get("email"));
                                }
                            });
                            info1.setContact(contact1);
                        }
                        result.setInfo(info1);
                    });
                    break;
                }
                case "host": {
                    result.setHost((String) map.get("host"));
                    break;
                }
                case "basePath": {
                    result.setBasePath((String) map.get("basePath"));
                    break;
                }
                case "tags": {
                    result.setTags((ArrayList<Tag>) map.get("tags"));
                    break;
                }

                case "paths": {
                    List<SwaggerReqResEntity> swaggerReqResEntities = new ArrayList<>();

                    Map<String, Map<String, Object>> paths = (Map<String, Map<String, Object>>) map.get("paths");

                    Iterator<String> iterator = paths.keySet().iterator();
                    while (iterator.hasNext()) {
                        String requestUrl = iterator.next();
                        Map<String, Object> requestMethodAndParams = paths.get(requestUrl);

                        requestMethodAndParams.keySet().forEach(requestMethod -> {
                            if ("post".equals(requestMethod)) {
                                SwaggerReqResEntity<Post> swaggerReqResEntity = new SwaggerReqResEntity<>();
                                List<SwaggerResponse> swaggerResponses = new ArrayList<SwaggerResponse>();


                                Post post = new Post();
                                Map<String, Object> requestParamsMap = (Map<String, Object>) requestMethodAndParams.get(requestMethod);
                                requestParamsMap.keySet().forEach(requestParamsKey -> {
                                    if (requestParamsKey.equals("tags")) {
                                        List<String> tags = (ArrayList<String>) requestParamsMap.get("tags");
                                        post.setTags(tags);
                                    }
                                    if (requestParamsKey.equals("summary")) {
                                        post.setSummary((String) requestParamsMap.get("summary"));
                                    }
                                    if (requestParamsKey.equals("description")) {
                                        post.setDescription((String) requestParamsMap.get("description"));
                                    }
                                    if (requestParamsKey.equals("operationId")) {
                                        post.setOperationId((String) requestParamsMap.get("operationId"));
                                    }
                                    if (requestParamsKey.equals("consumes")) {
                                        ArrayList<String> consumes = (ArrayList<String>) requestParamsMap.get("consumes");
                                        post.setConsumes(consumes);
                                    }
                                    if (requestParamsKey.equals("produces")) {
                                        ArrayList<String> produces = (ArrayList<String>) requestParamsMap.get("produces");
                                        post.setProduces(produces);
                                    }
                                    if (requestParamsKey.equals("parameters")) {
                                        List<RequestParameter> parameters = (List<RequestParameter>) requestParamsMap.get("parameters");
                                        post.setParameters(parameters);
                                    }
                                    if (requestParamsKey.equals("responses")) {
                                        Map<String, Object> responses = (Map<String, Object>) requestParamsMap.get("responses");
                                        responses.keySet().forEach(responsesCode -> {
                                            SwaggerResponse swaggerResponse = new SwaggerResponse();
                                            swaggerResponse.setResponseCode(responsesCode);

                                            Map<String, Object> stringObjectMap = (Map<String, Object>) responses.get(responsesCode);
                                            stringObjectMap.keySet().forEach(responseKey -> {
                                                if (responseKey.equals("description")) {
                                                    swaggerResponse.setDescription((String) stringObjectMap.get(responseKey));
                                                }
                                                if (responseKey.equals("schema")) {
                                                    String jsonStr = gson.toJson(stringObjectMap.get(responseKey));
                                                    Schema schema = gson.fromJson(jsonStr, Schema.class);
                                                    if (schema.getFormat() == null || schema.getType() == null) {
                                                        Map<String, String> objectRef = (Map<String, String>) stringObjectMap.get(responseKey);
                                                        schema.setObjectRef(objectRef);
                                                    }
                                                    swaggerResponse.setSchema(schema);
                                                }

                                            });
                                            swaggerResponses.add(swaggerResponse);
                                        });
                                    }
                                });
                                SwaggerRequest<Post> swaggerRequest = new SwaggerRequest();
                                swaggerRequest.setRequestUrl(requestUrl);
                                swaggerRequest.setRequest(post);
                                swaggerReqResEntity.setRequest(swaggerRequest);
                                swaggerReqResEntity.setResponse(swaggerResponses);
                                swaggerReqResEntities.add(swaggerReqResEntity);
                            }
                        });
                    }
                    result.setSwaggerReqResEntities(swaggerReqResEntities);
                    break;
                }

                case "definitions": {
                    /**
                     /companycert/add-and-replace-admin-cert

                     AddAndReplaceAdminCertVO
                     type	"object"
                     required
                     0	"companyId"
                     1	"originalStr"
                     2	"signStr"
                     3	"subjectCn"
                     properties
                     companyId
                     type	"integer"
                     format	"int64"
                     description	"目标企业id"
                     originalStr
                     type	"string"
                     description	"原文串"
                     signStr
                     type	"string"
                     description	"签名串"
                     subjectCn
                     type	"string"
                     description	"证书主题CN"



                     */
                    List<BeanEntityDetail> beanEntityDetails = new ArrayList<>();
                    Map<String, Object> definitions = (Map<String, Object>) map.get("definitions");
                    definitions.keySet().forEach(objectName -> {
                        BeanEntityDetail beanEntityDetail = new BeanEntityDetail();
                        beanEntityDetail.setObjectName(objectName);

                        Map<String, Object> stringObjectMap = (Map<String, Object>) definitions.get(objectName);
                        String type = (String) stringObjectMap.get("type");
                        beanEntityDetail.setObjectType(type);

                        List<String> required = (List<String>) stringObjectMap.get("required");
                        if (!CollectionUtils.isEmpty(required)) {
                            beanEntityDetail.setRequirePropertiesKeys(required);
                        }

                        Map<String, Object> properties = (Map<String, Object>) stringObjectMap.get("properties");

                        List<PropertiesDetail> propertiesDetails = new ArrayList<>();
                        properties.keySet().forEach(propertiesKey -> {
                            PropertiesDetail propertiesDetail = new PropertiesDetail();
                            propertiesDetail.setPropertiesKey(propertiesKey);

                            String jsonStr = gson.toJson(properties.get(propertiesKey));
                            PropertiesKeyDes propertiesKeyDes = gson.fromJson(jsonStr, PropertiesKeyDes.class);
                            propertiesDetail.setPropertiesKeyDes(propertiesKeyDes);
                            propertiesDetails.add(propertiesDetail);
                        });
                        beanEntityDetail.setProperties(propertiesDetails);
                        beanEntityDetails.add(beanEntityDetail);
                    });
                    result.setBeanEntityDetails(beanEntityDetails);
                    break;
                }
            }
        });
        List<SwaggerReqResEntity> swaggerReqResEntities = result.getSwaggerReqResEntities();

        BeanEntityDetail beanEntityDetail = result.getBeanEntityDetails().get(2);
        BeanEntityDetailDeal beanEntityDetailDeal = dealBeanEntityDetail(beanEntityDetail);
//        System.out.println(GsonFormatter(beanEntityDetailDeal, true));


        //处理输出对象：返回实体是否是要求必填处理
        List<BeanEntityDetail> beanEntityDetails = result.getBeanEntityDetails();
        List<BeanEntityDetailDeal> beanEntityDetailDeals = new ArrayList<>(beanEntityDetails.size());
        beanEntityDetails.forEach(beanEntityDetailSingle -> {
            beanEntityDetailDeals.add(dealBeanEntityDetail(beanEntityDetailSingle));
        });
        HttpEntityDeal httpEntityDeal = new HttpEntityDeal();
        BeanUtils.copyProperties(result, httpEntityDeal);
        httpEntityDeal.setBeanEntityDetailsDeals(beanEntityDetailDeals);

        //


//        return objectToMap(result);
        return objectToMap(httpEntityDeal);

    }

    /**
     * 处理对象的属性是否是必填
     *
     * @param beanEntityDetail
     * @return
     */
    private static BeanEntityDetailDeal dealBeanEntityDetail(BeanEntityDetail beanEntityDetail) {
        BeanEntityDetailDeal beanEntityDetailDeal = new BeanEntityDetailDeal();
        BeanUtils.copyProperties(beanEntityDetail, beanEntityDetailDeal);

        List<String> requirePropertiesKeys = beanEntityDetail.getRequirePropertiesKeys();
        List<PropertiesDetail> properties = beanEntityDetail.getProperties();

        List<PropertiesDetailDeal> propertiesDetailDeals = new ArrayList<>(properties.size());

        if (!CollectionUtils.isEmpty(properties) && !CollectionUtils.isEmpty(requirePropertiesKeys)) {
            for (PropertiesDetail property : properties) {
                PropertiesDetailDeal propertiesDetailDeal = new PropertiesDetailDeal();
                propertiesDetailDeal.setFormat(property.getPropertiesKeyDes().getFormat());
                propertiesDetailDeal.setDescription(property.getPropertiesKeyDes().getDescription());
                propertiesDetailDeal.setType(property.getPropertiesKeyDes().getType());
                propertiesDetailDeal.setPropertiesKey(property.getPropertiesKey());

                if (requirePropertiesKeys.contains(property.getPropertiesKey())) {
                    propertiesDetailDeal.setRequire(true);
                } else {
                    propertiesDetailDeal.setRequire(false);
                }
                propertiesDetailDeals.add(propertiesDetailDeal);
            }
        }
        beanEntityDetailDeal.setPropertiesDeals(propertiesDetailDeals);
        return beanEntityDetailDeal;
    }

    /**
     * 使用Gson格式化对象，返回json
     *
     * @param object     对象内容
     * @param needPrerry 是否需要美化：treu：需要
     * @return
     */
    public static String GsonFormatter(Object object, boolean needPrerry) {
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

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }

    /**
     * 获取JsonObject
     *
     * @param json
     * @return
     */
    public static JsonObject parseJson(String json) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObj = parser.parse(json).getAsJsonObject();
        return jsonObj;
    }


    /**
     * 将JSONObjec对象转换成Map-List集合
     *
     * @param json
     * @return
     */
    public static Map<String, Object> toMap(JsonObject json) {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<Map.Entry<String, JsonElement>> entrySet = json.entrySet();
        for (Iterator<Map.Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext(); ) {
            Map.Entry<String, JsonElement> entry = iter.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JsonArray)
                map.put((String) key, toList((JsonArray) value));
            else if (value instanceof JsonObject)
                map.put((String) key, toMap((JsonObject) value));
            else
                map.put((String) key, value);
        }
        return map;
    }

    /**
     * 将JSONArray对象转换成List集合
     *
     * @param json
     * @return
     */
    public static List<Object> toList(JsonArray json) {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < json.size(); i++) {
            Object value = json.get(i);
            if (value instanceof JsonArray) {
                list.add(toList((JsonArray) value));
            } else if (value instanceof JsonObject) {
                list.add(toMap((JsonObject) value));
            } else {
                list.add(value);
            }
        }
        return list;
    }

    public static Object map2JavaBean(Class<?> clazz, Map<String, Object> map) throws Exception {
        Object javabean = clazz.newInstance(); // 构建对象
        Method[] methods = clazz.getMethods(); // 获取所有方法
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String field = method.getName(); // 截取属性名
                field = field.substring(field.indexOf("set") + 3);
                field = field.toLowerCase().charAt(0) + field.substring(1);
                if (map.containsKey(field)) {
                    method.invoke(javabean, map.get(field));
                }
            }
        }
        return javabean;
    }
}
