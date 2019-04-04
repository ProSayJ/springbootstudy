package com.prosayj.springboot.test;

import com.prosayj.springboot.utils.swagger2pdfutil.test;

import java.net.URL;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = test.getMap();
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        FreeMarkToHtml.freemarkToHtml(url.getPath(), "test.ftl", map, url.getPath() + "result.html");
       // XHtml2Pdf.XHtml2Pdf(url.getPath() + "result.html", url.getPath() + "result.pdf");
    }

}
