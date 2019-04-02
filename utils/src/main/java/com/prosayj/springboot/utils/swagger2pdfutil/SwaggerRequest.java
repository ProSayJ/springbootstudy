package com.prosayj.springboot.utils.swagger2pdfutil;

import java.io.Serializable;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/2 11:42
 * @since 1.0.0
 */
public class SwaggerRequest<Request> implements Serializable {
    private static final long serialVersionUID = 860931620629407421L;

    private String requestUrl;
    private Request request;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
