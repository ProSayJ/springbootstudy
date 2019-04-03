package com.prosayj.springboot.test;

import com.itextpdf.text.DocumentException;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.prosayj.springboot.utils.swagger2pdfutil.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
/*

        File file = new File("D:\\workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_user.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        String jsonString = br.readLine().toString();
        Gson gson = new Gson();
        HttpEntity result = new HttpEntity();
        Map<String, Object> replaceData = gson.fromJson(jsonString, Map.class);

*/

        Map<String, Object> map = test.getMap();
        URL url = Thread.currentThread().getContextClassLoader().getResource("");


//        Map replaceData = initData();
        FreeMarkToHtml.freemarkToHtml(url.getPath(), "test.ftl", map, url.getPath() + "result.html");

        //XHtml2Pdf.XHtml2Pdf(url.getPath() + "result.html", url.getPath() + "result.pdf");
        /*
        try {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (CssResolverException e) {
            e.printStackTrace();
        }*/
    }

}
