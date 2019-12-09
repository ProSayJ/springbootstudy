package com.prosayj.springboot.utils.swagger2pdfutil;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 13:56
 * @since 1.0.0
 */
public class Post implements Serializable {
    private static final long serialVersionUID = 3386639296555089401L;
    private List<String> tags;
    private String summary;
    private String description;
    private String operationId;
    private List<String> consumes;
    private List<String> produces;
    private List<RequestParameter> parameters;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public List<String> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<String> consumes) {
        this.consumes = consumes;
    }

    public List<String> getProduces() {
        return produces;
    }

    public void setProduces(List<String> produces) {
        this.produces = produces;
    }

    public List<RequestParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<RequestParameter> parameters) {
        this.parameters = parameters;
    }


    @Override
    public String toString() {
        return "Post{" +
                "tags=" + tags +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", operationId='" + operationId + '\'' +
                ", consumes=" + consumes +
                ", produces=" + produces +
                ", parameters=" + parameters +
                '}';
    }
}

