package com.prosayj.springboot.toword.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prosayj.springboot.toword.dto.Parameter;
import com.prosayj.springboot.toword.dto.Request;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:40
 * @since 1.0.0
 */
public interface ParameterService {
    Map<String, Object> buildParamMap(List<Request> var1, Map<String, Object> var2) throws IOException;

    ObjectNode parseRef2Json(String var1, Map<String, Object> var2);

    void parseRef2Table(String var1, Map<String, Object> var2, LinkedHashMap<String, List<Parameter>> var3);
}
