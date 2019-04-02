package com.prosayj.springboot.utils.test;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.prosayj.springboot.utils.swagger2pdfutil.HttpEntity;
import com.prosayj.springboot.utils.swagger2pdfutil.test;
import com.prosayj.springboot.utils.test.entity.Student;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_user.json");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        String jsonString = br.readLine().toString();
        Gson gson = new Gson();
        HttpEntity result = new HttpEntity();
        Map<String, Object> replaceData = gson.fromJson(jsonString, Map.class);
        URL url = Thread.currentThread().getContextClassLoader().getResource("");

        Map<String, Object> map = test.getMap();


//        Map replaceData = initData();
        FreeMarkToHtml.freemarkToHtml(url.getPath(), "test.ftl", map, url.getPath() + "result.html");

/*
        try {
            XHtml2Pdf.XHtml2Pdf(url.getPath() + "result.html", url.getPath() + "result.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (CssResolverException e) {
            e.printStackTrace();
        }
        */
    }

}
