package com.prosayj.springboot.spider.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

import com.gargoylesoftware.htmlunit.WebClient;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/18 下午 01:09
 * @since 1.0.0
 */
public class Test {
    /*
     * 首先说说HtmlUnit相对于HttpClient的最明显的一个好处,
     * 是HtmlUnit不仅保存了这个网页对象，更难能可贵的是它还存有这个网页的所有基本操作甚至事件。
     * 现在很多网站使用大量ajax，普通爬虫无法获取js生成的内容。
     */
    /*
     * 依赖的jar包
     * commons-lang3-3.1.jar
     * htmlunit-2.13.jar
     *
     * htmlunit-core-js-2.13.jar
     * httpclient-4.3.1.jar
     * httpcore-4.3.jar
     * httpmime-4.3.1.jar
     * sac-1.3.jar
     * xml-apis-1.4.01.jar
     * commons-collections-3.2.1.jar
     * commons-io-2.4.jar
     * xercesImpl-2.11.0.jar
     * xalan-2.7.1.jar
     * cssparser-0.9.11.jar
     * nekohtml-1.9.19.jar
     */

    public static void main(String[] args) {
        jsoupParse();
    }

    private static void jsoupParse() {
        try {

/**
 <div class="yy_dianjichakangengduo">
 <a onclick="ShowMorePage(this);" pnum="2" lm="2846" href="javascript:void(0)"> 點擊查看更多 </a>
 </div>
 */
            WebClient webClient = WebClientUtils.getWebClientLoadJs();
            HtmlPage htmlPage = webClient.getPage("https://oil.fx168.com/");
            // TODO: 10秒钟是为了让js能够充分执行（特别是ajax）
            webClient.waitForBackgroundJavaScript(10*1000);
            webClient.setJavaScriptTimeout(5*1000);

//            htmlPage.g


            HtmlElement documentElement = htmlPage.getDocumentElement();
            String xml = htmlPage.asXml();
            // 服务器端进行校验并清除有害的HTML代码,防止富文本提交有害代码
            Jsoup.clean(xml, Whitelist.basic());
            /** jsoup解析文档 */
            // 把String转化成document格式
            Document doc = Jsoup.parse(xml);
            System.out.println(doc.body());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
