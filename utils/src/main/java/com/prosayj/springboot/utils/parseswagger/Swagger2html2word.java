package com.prosayj.springboot.utils.parseswagger;

import com.prosayj.springboot.utils.parseswagger.assemble.FreeMarkToHtml;
import com.prosayj.springboot.utils.parseswagger.assemble.Html2World;
import com.prosayj.springboot.utils.test.XHtml2Pdf;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Swagger2html2word {

    public static void main(String[] args) throws Exception {

        String swaggerJosn = PaserSwaggerJson2Objects.getSwaggerJosn("api-docs_api.json");
        Swagger swagger = new SwaggerParser().parse(swaggerJosn);

        HashMap<String, String> swaggerInfo = PaserSwaggerJson2Objects.getSwaggerInfo(swagger);
        List<Map<String, Object>> requestAndResponse = PaserSwaggerJson2Objects.getRequestAndResponse(swagger);
        List<Map<String, List<Map<String, String>>>> entityDetailList = PaserSwaggerJson2Objects.getEntityDetailList(swagger);
        Map<String, List<Map<String, String>>> swaggerTagsInfo = PaserSwaggerJson2Objects.getSwaggerTagsInfo(swagger);

        PaserSwaggerJson2Objects.dealrequestAndResponseParams(requestAndResponse, entityDetailList, swagger);

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
        map.put("swaggerTagsInfo", swaggerTagsInfo);
        map.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm SSS").format(new Date()));

        URL url = Thread.currentThread().getContextClassLoader().getResource("");
//        FreeMarkToHtml.freemarkToHtml(url.getPath(), "template01.ftl", map, url.getPath() + "result01.html");
        FreeMarkToHtml.freemarkToHtml(url.getPath(), "template02.ftl", map, url.getPath() + "result02.html");


//        File htmlSrc = new File(url.getPath() + "result01.html");
        File htmlSrc = new File(url.getPath() + "result02.html");
        StringBuffer htmlString = new StringBuffer();
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(htmlSrc), "utf-8"));
        while ((s = br.readLine()) != null) {
            htmlString.append(s + "\n");
        }

        //Html2World.jacob_html2word(htmlString.toString());

        //XHtml2Pdf.XHtml2Pdf(url.getPath() + "result02.html", url.getPath() + "result02.pdf");

        /*
        Map<String, Object> map = test.getMap();
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        FreeMarkToHtml.freemarkToHtml(url.getPath(), "test.ftl", map, url.getPath() + "result.html");
        */

//         XHtml2Pdf.XHtml2Pdf(url.getPath() + "result.html", url.getPath() + "result.pdf");
//         XHtml2Pdf.XHtml2Pdf(url.getPath() + "result02.html", url.getPath() + "result.pdf");
    }
}
