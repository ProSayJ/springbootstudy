package com.prosayj.springboot.spider.test;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author yangjian
 * @description 采集工具类
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/18 下午 01:37
 * @since 1.0.0
 */
public class PickUtils {

    /**
     * @param page  页面
     * @param xpath 规则
     * @return
     * @Description: 获取元素文本
     */
    public static String getTargetText(HtmlPage page, String xpath) {
        if (xpath != null && !xpath.equals("")) {
            DomNode domNode = page.getFirstByXPath(xpath);
            if (null != domNode && domNode.isDisplayed()) {
                return domNode.asText();
            }
        }
        return "";
    }

    /**
     * @param page  页面
     * @param xpath 规则
     * @return
     * @Description: 获取元素html
     */
    public static String getTargetHtml(HtmlPage page, String xpath) {
        if (xpath != null && !xpath.equals("")) {
            DomNode domNode = page.getFirstByXPath(xpath);
            if (null != domNode && domNode.isDisplayed()) {
                return domNode.asXml();
            }
        }
        return "";
    }
}
