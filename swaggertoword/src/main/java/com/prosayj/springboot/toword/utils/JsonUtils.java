package com.prosayj.springboot.toword.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:43
 * @since 1.0.0
 */
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public JsonUtils() {
    }

    public static <T> T readValue(String jsonStr, Class<T> clazz) throws IOException {
        return objectMapper.readValue(jsonStr, clazz);
    }

    public static <T> List<T> readListValue(String jsonStr, Class<T> clazz) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, new Class[]{clazz});
        return (List) objectMapper.readValue(jsonStr, javaType);
    }

    public static ArrayNode readArray(String jsonStr) throws IOException {
        JsonNode node = objectMapper.readTree(jsonStr);
        return node.isArray() ? (ArrayNode) node : null;
    }

    public static JsonNode readNode(String jsonStr) throws IOException {
        return objectMapper.readTree(jsonStr);
    }

    public static String writeJsonStr(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static String prettyString(Object obj) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    public static ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        return objectMapper.createArrayNode();
    }

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }
}
