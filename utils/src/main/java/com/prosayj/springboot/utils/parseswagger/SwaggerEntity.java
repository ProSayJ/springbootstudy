package com.prosayj.springboot.utils.parseswagger;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/24 下午 07:09
 * @since 1.0.0
 */
public class SwaggerEntity {
    private SwaggerRequest request;
    private SwaggerResponse response;


    public SwaggerRequest getRequest() {
        return request;
    }

    public void setRequest(SwaggerRequest request) {
        this.request = request;
    }

    public SwaggerResponse getResponse() {
        return response;
    }

    public void setResponse(SwaggerResponse response) {
        this.response = response;
    }
}

class SwaggerRequest {
    private String requestUrl;
    private String requestDes;

}

class SwaggerResponse {
    /**
     * 返回状态码
     */
    private String status;


    //基本数据类型
    private  String type;
    private String format;



}