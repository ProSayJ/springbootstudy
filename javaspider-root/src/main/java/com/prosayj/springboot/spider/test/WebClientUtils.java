package com.prosayj.springboot.spider.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/18 下午 01:29
 * @since 1.0.0
 */
public class WebClientUtils {

    public final static int TIMEOUT = 5000;

    public final static int JAVASCRIPTTIMEOUT = 3000;

    public final static String REFERER = "http://www.baidu.com";

    /**
     * @return WebClient    返回类型
     * @Title: getWebClient
     * @Description: 获取webcilent，禁止js，禁止css
     */
    public static WebClient getWebClient() {
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(Boolean.FALSE);
        webClient.getOptions().setJavaScriptEnabled(Boolean.FALSE);
        webClient.getOptions().setTimeout(TIMEOUT);
        return webClient;
    }


    /**
     * @return WebClient    返回类型
     * @Title: getWebClientLoadJs
     * @Description: 获取webcilent，加载js，禁止css
     */
    public static WebClient getWebClientLoadJs() {
        WebClient webClient = new WebClient();
        webClient.addRequestHeader("Referer", REFERER);
        webClient.setJavaScriptTimeout(JAVASCRIPTTIMEOUT);//设置JS执行的超时时间
        // 禁用css ，一般来说 css没啥用
        webClient.getOptions().setCssEnabled(false);
        //当HTTP的状态非200时是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        // 设置支持 js 很重要
        webClient.getOptions().setJavaScriptEnabled(true);
        // 不抛出异常
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setDoNotTrackEnabled(true);
        // 最好设置一下超时
        //设置“浏览器”的请求超时时间
        webClient.getOptions().setTimeout(TIMEOUT);
        // 支持ajax
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setRedirectEnabled(true);
        webClient.waitForBackgroundJavaScript(JAVASCRIPTTIMEOUT);//设置JS后台等待执行时间
        webClient.getOptions().setUseInsecureSSL(true);
        return webClient;
    }

    /**
     * @return WebClient    返回类型
     * @Title: getProxyWebClient
     * @Description: 使用代理获取webclient
     */
    public static WebClient getProxyWebClient(String host, int port) {

        WebClient webClient = new WebClient(BrowserVersion.CHROME, host, port);

        webClient.addRequestHeader("Referer", REFERER);
        webClient.setJavaScriptTimeout(JAVASCRIPTTIMEOUT);//设置JS执行的超时时间
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setTimeout(TIMEOUT);//设置“浏览器”的请求超时时间
        webClient.getOptions().setCssEnabled(false);//是否启用CSS
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.waitForBackgroundJavaScript(JAVASCRIPTTIMEOUT);//设置JS后台等待执行时间
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//设置支持AJAX
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        return webClient;
    }

}
