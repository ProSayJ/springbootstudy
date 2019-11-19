package com.prosayj.springboot.toword.service.impl;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.prosayj.springboot.toword.dto.Parameter;
import com.prosayj.springboot.toword.dto.Request;
import com.prosayj.springboot.toword.dto.Response;
import com.prosayj.springboot.toword.dto.Table;
import com.prosayj.springboot.toword.service.ParameterService;
import com.prosayj.springboot.toword.service.WordService;
import com.prosayj.springboot.toword.utils.JsonUtils;
import com.sun.deploy.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:41
 * @since 1.0.0
 */
@Service
public class WordServiceImpl implements WordService {
    private static final Logger log = LoggerFactory.getLogger(WordServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;
    @Value("${swagger.url}")
    private String swaggerUrl;
    @Autowired
    private ParameterService parameterService;


    @Override
    public Map<String, List<Table>> tableList(String swaggerUi) {
        swaggerUi = (String)Optional.ofNullable(swaggerUi).orElse(this.swaggerUrl);
        ArrayList result = new ArrayList();

        try {
            String jsonUrl = swaggerUi.replace("swagger-ui.html", "v2/api-docs");
            String jsonStr = (String)this.restTemplate.getForObject(jsonUrl, String.class, new Object[0]);
            Map<String, Object> map = (Map)JsonUtils.readValue(jsonStr, HashMap.class);
            ArrayList<LinkedHashMap> allTags = (ArrayList)map.get("tags");
            Map<String, String> tagMap = this.buildTagMap(allTags);
            Map<String, LinkedHashMap> paths = (LinkedHashMap)map.get("paths");
            Map<String, Object> definitions = (Map)map.get("definitions");
            if (paths != null) {
                Iterator it = paths.entrySet().iterator();

                outbreak:
                while(true) {
                    while(true) {
                        if (!it.hasNext()) {
                            break outbreak;
                        }

                        Map.Entry<String, LinkedHashMap> path = (Map.Entry)it.next();
                        Iterator<Map.Entry<String, LinkedHashMap>> it2 = ((LinkedHashMap)path.getValue()).entrySet().iterator();
                        String url = (String)path.getKey();
                        String requestType = StringUtils.join(((LinkedHashMap)path.getValue()).keySet(), ",");
                        Map.Entry<String, LinkedHashMap> firstRequest = (Map.Entry)it2.next();
                        Map<String, Object> content = (Map)firstRequest.getValue();
                        String title = String.valueOf(((List)content.get("tags")).get(0));
                        String tag = String.valueOf(content.get("summary"));
                        String description = String.valueOf(content.get("summary"));
                        String requestForm = "";
                        List<String> consumes = (List)content.get("consumes");
                        if (consumes != null && consumes.size() > 0) {
                            requestForm = StringUtils.join(consumes, ",");
                        }

                        String responseForm = "";
                        List<String> produces = (List)content.get("produces");
                        if (produces != null && produces.size() > 0) {
                            responseForm = StringUtils.join(produces, ",");
                        }

                        List<Request> requestList = new ArrayList();
                        List<LinkedHashMap> parameters = (ArrayList)content.get("parameters");
                        Object obj;
                        if (!CollectionUtils.isEmpty(parameters)) {
                            Iterator var26 = parameters.iterator();

                            while(var26.hasNext()) {
                                Map<String, Object> param = (Map)var26.next();
                                Request request = new Request();
                                request.setName(String.valueOf(param.get("name")));
                                Object in = param.get("in");
                                if (in != null && "body".equals(in)) {
                                    request.setType(String.valueOf(in));
                                    Map<String, Object> schema = (Map)param.get("schema");
                                    obj = schema.get("$ref");
                                    if (schema.get("type") != null && "array".equals(schema.get("type"))) {
                                        obj = ((Map)schema.get("items")).get("$ref");
                                    }

                                    request.setParamType(obj == null ? "{}" : obj.toString());
                                } else {
                                    request.setType(param.get("type") == null ? "Object" : param.get("type").toString());
                                    request.setParamType(String.valueOf(in));
                                }

                                request.setRequire((Boolean)param.get("required"));
                                request.setRemark(String.valueOf(param.get("description")));
                                requestList.add(request);
                            }
                        }

                        List<Response> responseList = new ArrayList();
                        Map<String, Object> responses = (LinkedHashMap)content.get("responses");
                        Iterator it3 = responses.entrySet().iterator();

                        while(it3.hasNext()) {
                            Response response = new Response();
                            Map.Entry<String, Object> entry = (Map.Entry)it3.next();
                            response.setName((String)entry.getKey());
                            LinkedHashMap<String, Object> statusCodeInfo = (LinkedHashMap)entry.getValue();
                            response.setDescription(String.valueOf(statusCodeInfo.get("description")));
                            response.setRemark(String.valueOf(statusCodeInfo.get("description")));
                            responseList.add(response);
                        }

                        Table table = new Table();
                        table.setTitle(tagMap.get(title) == null ? title : (String)tagMap.get(title));
                        table.setUrl(url);
                        table.setTag(tag);
                        table.setDescription(description);
                        table.setRequestForm(requestForm);
                        table.setResponseForm(responseForm);
                        table.setRequestType(requestType);
                        table.setResponseList(responseList);
                        table.setRequestParam(JsonUtils.prettyString(this.parameterService.buildParamMap(requestList, definitions)));
                        LinkedHashMap<String, List<Parameter>> requestLinkedHashMap = new LinkedHashMap();
                        Iterator var48 = requestList.iterator();

                        while(var48.hasNext()) {
                            Request request = (Request)var48.next();
                            this.parameterService.parseRef2Table(request.getParamType(), definitions, requestLinkedHashMap);
                            request.setParamType(request.getParamType().replaceAll("#/definitions/", ""));
                        }

                        table.setRequestList(requestList);
                        table.setRequestStructure(requestLinkedHashMap);
                        obj = responses.get("200");
                        if (obj == null) {
                            table.setResponseParam("");
                            result.add(table);
                        } else {
                            Object schema = ((Map)obj).get("schema");
                            if (schema != null) {
                                if (((Map)schema).get("$ref") != null) {
                                    String ref = (String)((Map)schema).get("$ref");
                                    ObjectNode objectNode = this.parameterService.parseRef2Json(ref, definitions);
                                    LinkedHashMap<String, List<Parameter>> responseLinkedHashMap = new LinkedHashMap();
                                    this.parameterService.parseRef2Table(ref, definitions, responseLinkedHashMap);
                                    table.setResponseParam(JsonUtils.prettyString(objectNode));
                                    table.setResponseStructure(responseLinkedHashMap);
                                    result.add(table);
                                    continue;
                                }

                                Object items = ((Map)schema).get("items");
                                if (items != null && ((Map)items).get("$ref") != null) {
                                    String ref = (String)((Map)items).get("$ref");
                                    ObjectNode objectNode = this.parameterService.parseRef2Json(ref, definitions);
                                    ArrayNode arrayNode = JsonUtils.createArrayNode();
                                    arrayNode.add(objectNode);
                                    LinkedHashMap<String, List<Parameter>> responseLinkedHashMap = new LinkedHashMap();
                                    this.parameterService.parseRef2Table(ref, definitions, responseLinkedHashMap);
                                    table.setResponseStructure(responseLinkedHashMap);
                                    table.setResponseParam(JsonUtils.prettyString(arrayNode));
                                    result.add(table);
                                    continue;
                                }
                            }

                            result.add(table);
                        }
                    }
                }
            }
        } catch (Exception var38) {
            log.error("parse error", var38);
        }

        Map<String, List<Table>> tableMap = (Map)result.stream().collect(Collectors.groupingBy(Table::getTitle));
        return tableMap;
    }

    private Map<String, String> buildTagMap(ArrayList<LinkedHashMap> allTags) {
        Map<String, String> tagMap = new HashMap();
        Iterator var3 = allTags.iterator();

        while(var3.hasNext()) {
            LinkedHashMap map = (LinkedHashMap)var3.next();
            tagMap.put((String)map.get("name"), (String)map.get("description"));
        }

        return tagMap;
    }
}
