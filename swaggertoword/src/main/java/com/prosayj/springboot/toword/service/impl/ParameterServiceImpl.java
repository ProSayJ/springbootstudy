package com.prosayj.springboot.toword.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prosayj.springboot.toword.dto.Parameter;
import com.prosayj.springboot.toword.dto.Request;
import com.prosayj.springboot.toword.service.ParameterService;
import com.prosayj.springboot.toword.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:46
 * @since 1.0.0
 */
@Service
public class ParameterServiceImpl implements ParameterService {
    private static final Logger log = LoggerFactory.getLogger(ParameterServiceImpl.class);


    @Override
    public Map<String, Object> buildParamMap(List<Request> list, Map<String, Object> map) throws IOException {
        Map<String, Object> paramMap = new HashMap(8);
        if (list != null && list.size() > 0) {
            Iterator var4 = list.iterator();

            while(var4.hasNext()) {
                Request request = (Request)var4.next();
                String name = request.getName();
                String type = request.getType();
                byte var9 = -1;
                switch(type.hashCode()) {
                    case -1034364087:
                        if (type.equals("number")) {
                            var9 = 2;
                        }
                        break;
                    case -891985903:
                        if (type.equals("string")) {
                            var9 = 0;
                        }
                        break;
                    case 3029410:
                        if (type.equals("body")) {
                            var9 = 4;
                        }
                        break;
                    case 64711720:
                        if (type.equals("boolean")) {
                            var9 = 3;
                        }
                        break;
                    case 1958052158:
                        if (type.equals("integer")) {
                            var9 = 1;
                        }
                }

                switch(var9) {
                    case 0:
                        ((Map)paramMap).put(name, "string");
                        break;
                    case 1:
                        ((Map)paramMap).put(name, 0);
                        break;
                    case 2:
                        ((Map)paramMap).put(name, 0.0D);
                        break;
                    case 3:
                        ((Map)paramMap).put(name, true);
                        break;
                    case 4:
                        String paramType = request.getParamType();
                        ObjectNode objectNode = this.parseRef2Json(paramType, map);
                        paramMap = (Map) JsonUtils.readValue(objectNode.toString(), Map.class);
                        break;
                    default:
                        ((Map)paramMap).put(name, (Object)null);
                }
            }
        }

        return (Map)paramMap;
    }

    @Override
    public ObjectNode parseRef2Json(String ref, Map<String, Object> definitions) {
        log.info(ref);
        ObjectNode objectNode = JsonUtils.createObjectNode();
        if (StringUtils.isNotEmpty(ref) && ref.startsWith("#")) {
            String[] refs = ref.split("/");
            Map<String, Object> objectMap = (Map)definitions.get(refs[2]);
            if (objectMap == null) {
                return objectNode;
            }

            Object properties = objectMap.get("properties");
            if (properties == null) {
                return objectNode;
            }

            Map<String, Object> propertiesMap = (Map)properties;
            Set<String> keys = propertiesMap.keySet();
            Iterator var9 = keys.iterator();

            while(var9.hasNext()) {
                String key = (String)var9.next();
                Map<String, Object> keyMap = (Map)propertiesMap.get(key);
                String str;
                if ("array".equals(keyMap.get("type"))) {
                    str = (String)((Map)keyMap.get("items")).get("$ref");
                    ArrayNode arrayNode = JsonUtils.createArrayNode();
                    if (str == null) {
                        arrayNode.add((String)((Map)keyMap.get("items")).get("type"));
                        objectNode.set(key, arrayNode);
                    } else {
                        if (str.equals(ref)) {
                            arrayNode.add(refs[2]);
                        } else {
                            JsonNode jsonNode = this.parseRef2Json(str, definitions);
                            arrayNode.add(jsonNode);
                        }

                        objectNode.set(key, arrayNode);
                    }
                } else if (keyMap.get("$ref") != null) {
                    str = (String)keyMap.get("$ref");
                    if (str.equals(ref)) {
                        objectNode.put(key, refs[2]);
                    } else {
                        ObjectNode object = this.parseRef2Json(str, definitions);
                        objectNode.set(key, object);
                    }
                } else {
                    str = "";
                    if (keyMap.get("description") != null) {
                        str = str + keyMap.get("description");
                    }

                    if (keyMap.get("format") != null) {
                        str = str + String.format("格式为(%s)", keyMap.get("format"));
                    }

                    objectNode.put(key, str);
                }
            }
        }

        return objectNode;
    }

    public void parseRef2Table(String ref, Map<String, Object> definitions, LinkedHashMap<String, List<Parameter>> linkedHashMap) {
        if (StringUtils.isNotEmpty(ref) && ref.startsWith("#")) {
            String[] refs = ref.split("/");
            Map<String, Object> objectMap = (Map)definitions.get(refs[2]);
            if (objectMap == null) {
                return;
            }

            List requiredList = (List)objectMap.get("required");
            Object properties = objectMap.get("properties");
            if (properties == null) {
                return;
            }

            if (linkedHashMap.containsKey(refs[2])) {
                return;
            }

            Map<String, Object> propertiesMap = (Map)properties;
            List<Parameter> list = new ArrayList();
            linkedHashMap.put(refs[2], list);
            Parameter parameter = null;

            for(Iterator var11 = propertiesMap.entrySet().iterator(); var11.hasNext(); list.add(parameter)) {
                Map.Entry<String, Object> entry = (Map.Entry)var11.next();
                parameter = new Parameter();
                Map<String, Object> keyMap = (Map)entry.getValue();
                String key = (String)entry.getKey();
                parameter.setName(key);
                parameter.setRemark((String)keyMap.get("description"));
                if (requiredList == null) {
                    parameter.setRequire(false);
                } else {
                    parameter.setRequire(requiredList.contains(key));
                }

                String sonRef;
                if ("array".equals(keyMap.get("type"))) {
                    sonRef = (String)((Map)keyMap.get("items")).get("$ref");
                    if (sonRef == null) {
                        parameter.setType("array:" + (String)((Map)keyMap.get("items")).get("type"));
                    } else {
                        parameter.setType("array:" + sonRef.replace("#/definitions/", ""));
                        this.parseRef2Table(sonRef, definitions, linkedHashMap);
                    }
                } else if (keyMap.get("$ref") != null) {
                    sonRef = (String)keyMap.get("$ref");
                    parameter.setType(sonRef.replace("#/definitions/", ""));
                    this.parseRef2Table(sonRef, definitions, linkedHashMap);
                } else {
                    parameter.setType((String)keyMap.get("type"));
                }
            }
        }

    }
}
