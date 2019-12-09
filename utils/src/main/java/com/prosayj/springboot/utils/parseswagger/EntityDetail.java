package com.prosayj.springboot.utils.parseswagger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/26 上午 12:07
 * @since 1.0.0
 */
public class EntityDetail {
    //接口描述
    private String interfaceDes;
    //请求方式
    private String URL;
    private String requestWay;
    //请求类型
    private String requestType;
    //返回类型
    private String returnType;
    //Post请求参数描述
    private List<RequestParam> requestParams;
    //返回状态码
    private List<ResponseStatus> responseStatuses;


    public EntityDetail() {
        if (responseStatuses == null) {
            responseStatuses = new ArrayList<>();
        }
        if (requestParams == null) {
            requestParams = new ArrayList<>();
        }
    }


    @Override
    public String toString() {
        return "EntityDetail{" +
                "interfaceDes='" + interfaceDes + '\'' +
                ", URL='" + URL + '\'' +
                ", requestWay='" + requestWay + '\'' +
                ", requestType='" + requestType + '\'' +
                ", returnType='" + returnType + '\'' +
                ", requestParams=" + requestParams +
                ", responseStatuses=" + responseStatuses +
                '}';
    }

    public List<RequestParam> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(List<RequestParam> requestParams) {
        this.requestParams = requestParams;
    }

    public List<ResponseStatus> getResponseStatuses() {
        return responseStatuses;
    }

    public void setResponseStatuses(List<ResponseStatus> responseStatuses) {
        this.responseStatuses = responseStatuses;
    }

    public String getRequestWay() {
        return requestWay;
    }

    public void setRequestWay(String requestWay) {
        this.requestWay = requestWay;
    }

    public String getInterfaceDes() {
        return interfaceDes;
    }

    public void setInterfaceDes(String interfaceDes) {
        this.interfaceDes = interfaceDes;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }


    static class RequestParam {
        /**
         * 参数key(参数名称)
         */
        private String paramKey;

        /**
         * 数据类型(参数请求对象还是基本数据类型):请求体为body，基本数据类型则是其示例：如Sting类型的为string
         */
        private String dataBody;

        /**
         * 参数类型
         */
        private String paramType;


        /**
         * 是否必传
         */
        private boolean require;

        /**
         * 参数说明
         */
        private String des;

        public String getParamKey() {
            return paramKey;
        }

        public void setParamKey(String paramKey) {
            this.paramKey = paramKey;
        }

        public String getParamType() {
            return paramType;
        }

        public void setParamType(String paramType) {
            this.paramType = paramType;
        }

        public String getDataBody() {
            return dataBody;
        }

        public void setDataBody(String dataBody) {
            this.dataBody = dataBody;
        }

        public boolean isRequire() {
            return require;
        }

        public void setRequire(boolean require) {
            this.require = require;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        @Override
        public String toString() {
            return "RequestParam{" +
                    "paramKey='" + paramKey + '\'' +
                    ", paramType='" + paramType + '\'' +
                    ", dataBody='" + dataBody + '\'' +
                    ", require=" + require +
                    ", des='" + des + '\'' +
                    '}';
        }
    }

    static class ResponseStatus {
        /**
         * 状态码
         */
        private String code;
        /**
         * 描述
         */
        private String des;
        /**
         * 说明
         */
        private String detail;


        public ResponseStatus(String code, String des, String detail) {
            this.code = code;
            this.des = des;
            this.detail = detail;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @Override
        public String toString() {
            return "ResponseStatus{" +
                    "code='" + code + '\'' +
                    ", des='" + des + '\'' +
                    ", detail='" + detail + '\'' +
                    '}';
        }
    }
    static class GetRequestParam{
        /**
         * 参数类型
         */
        private String type;
    }
}
