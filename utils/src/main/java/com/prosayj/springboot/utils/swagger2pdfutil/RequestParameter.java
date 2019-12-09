package com.prosayj.springboot.utils.swagger2pdfutil;

import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 18:58
 * @since 1.0.0
 */
public class RequestParameter {
    private String in;
    private String name;
    private String description;
    private String required;
    private String schema;
    private Object schemaObject;

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Object getSchemaObject() {
        return schemaObject;
    }

    public void setSchemaObject(Object schemaObject) {
        this.schemaObject = schemaObject;
    }
}
