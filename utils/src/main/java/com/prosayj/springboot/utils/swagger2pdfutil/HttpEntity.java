package com.prosayj.springboot.utils.swagger2pdfutil;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 18:48
 * @since 1.0.0
 */
public class HttpEntity {
    // 版本
    private String swagger;
    // swagger信息
    private Info info;
    // ip地址
    private String host;
    // 基础路径
    private String basePath;
    // tags
    private List<Tag> tags;
    // url 请求对象参数
    private List<SwaggerReqResEntity> swaggerReqResEntities;

    private List<BeanEntityDetail> beanEntityDetails;

    public String getSwagger() {
        return swagger;
    }

    public void setSwagger(String swagger) {
        this.swagger = swagger;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<SwaggerReqResEntity> getSwaggerReqResEntities() {
        return swaggerReqResEntities;
    }

    public void setSwaggerReqResEntities(List<SwaggerReqResEntity> swaggerReqResEntities) {
        this.swaggerReqResEntities = swaggerReqResEntities;
    }

    public List<BeanEntityDetail> getBeanEntityDetails() {
        return beanEntityDetails;
    }

    public void setBeanEntityDetails(List<BeanEntityDetail> beanEntityDetails) {
        this.beanEntityDetails = beanEntityDetails;
    }

    @Override
    public String toString() {
        return "HttpEntity{" +
                "swagger='" + swagger + '\'' +
                ", info=" + info +
                ", host='" + host + '\'' +
                ", basePath='" + basePath + '\'' +
                ", tags=" + tags +
                ", swaggerReqResEntities=" + swaggerReqResEntities +
                ", beanEntityDetails=" + beanEntityDetails +
                '}';
    }
}
