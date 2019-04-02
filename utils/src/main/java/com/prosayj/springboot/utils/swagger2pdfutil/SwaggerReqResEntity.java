package com.prosayj.springboot.utils.swagger2pdfutil;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 11:56
 * @since 1.0.0
 */
public class SwaggerReqResEntity<Request> implements Serializable {
    private static final long serialVersionUID = -1620707934026501665L;
    //接口请求参数
    private SwaggerRequest<Request> request;
    //接口服务响应
    private List<SwaggerResponse> response;

    public SwaggerRequest<Request> getRequest() {
        return request;
    }

    public void setRequest(SwaggerRequest<Request> request) {
        this.request = request;
    }

    public List<SwaggerResponse> getResponse() {
        return response;
    }

    public void setResponse(List<SwaggerResponse> response) {
        this.response = response;
    }
}

