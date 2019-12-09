package com.prosayj.springboot.utils.swagger2pdfutil;

import java.io.Serializable;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 18:45
 * @since 1.0.0
 */
public class SwaggerResponse implements Serializable {
    private static final long serialVersionUID = -2509211910838842224L;
    private String responseCode;
    private String description;
    private Schema schema;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "SwaggerResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", description='" + description + '\'' +
                ", schema=" + schema +
                '}';
    }
}
