package com.prosayj.springboot.test;

import com.prosayj.springboot.utils.Test02;
import com.prosayj.springboot.utils.swagger2pdfutil.test;
import io.swagger.models.ExternalDocs;
import io.swagger.models.Model;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {

        String swaggerJosn = Test02.getSwaggerJosn();
        Swagger swagger = new SwaggerParser().parse(swaggerJosn);

        HashMap<String, String> swaggerInfo = Test02.getSwaggerInfo(swagger);
        List<Map<String, Object>> requestAndResponse = Test02.getRequestAndResponse(swagger);
        List<Map<String, List<Map<String, String>>>> entityDetailList = Test02.getEntityDetailList(swagger);


        Test02.dealrequestAndResponseParams(requestAndResponse, entityDetailList, swagger);

        /*
        requestAndResponse.forEach(data -> {
            data.keySet().forEach(key -> {
                if (key.equals("requestParameterType") && data.get(key).equals("baseParam")) {
                    String requestParameterQueryParameterBaseParamDescription = data.get("requestParameterQueryParameterBaseParamDescription");
                    String requestParameterQueryParameterBaseParamType = data.get("requestParameterQueryParameterBaseParamType");
                    String requestParameterQueryParameterBaseParamTRequire = data.get("requestParameterQueryParameterBaseParamTRequire");
                    String requestParameterQueryParameterBaseParamtFormat = data.get("requestParameterQueryParameterBaseParamtFormat");
                    System.out.println(requestParameterQueryParameterBaseParamDescription + "<===>" + requestParameterQueryParameterBaseParamType + "<===>" + requestParameterQueryParameterBaseParamTRequire + "<===>" + requestParameterQueryParameterBaseParamtFormat);
                }
            });
        });
        */

        Map<String, Object> map = new HashMap<>();
        map.put("swaggerInfo", swaggerInfo);
        map.put("requestAndResponse", requestAndResponse);
        map.put("entityDetailList", entityDetailList);
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        FreeMarkToHtml.freemarkToHtml(url.getPath(), "test02.ftl", map, url.getPath() + "result02.html");
        XHtml2Pdf.XHtml2Pdf(url.getPath() + "result02.html", url.getPath() + "result02.pdf");



        /*
        Map<String, Object> map = test.getMap();
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        FreeMarkToHtml.freemarkToHtml(url.getPath(), "test.ftl", map, url.getPath() + "result.html");
        */

        // XHtml2Pdf.XHtml2Pdf(url.getPath() + "result.html", url.getPath() + "result.pdf");
    }

}
