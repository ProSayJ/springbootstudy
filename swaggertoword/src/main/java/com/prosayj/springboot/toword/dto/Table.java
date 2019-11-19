package com.prosayj.springboot.toword.dto;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:36
 * @since 1.0.0
 */
public class Table {
    private String title;
    private String tag;
    private String url;
    private String description;
    private String requestForm;
    private String responseForm;
    private String requestType;
    private List<Request> requestList;
    private List<Response> responseList;
    private LinkedHashMap<String, List<Parameter>> requestStructure;
    private LinkedHashMap<String, List<Parameter>> responseStructure;
    private String requestParam;
    private String responseParam;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestForm() {
        return requestForm;
    }

    public void setRequestForm(String requestForm) {
        this.requestForm = requestForm;
    }

    public String getResponseForm() {
        return responseForm;
    }

    public void setResponseForm(String responseForm) {
        this.responseForm = responseForm;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }

    public LinkedHashMap<String, List<Parameter>> getRequestStructure() {
        return requestStructure;
    }

    public void setRequestStructure(LinkedHashMap<String, List<Parameter>> requestStructure) {
        this.requestStructure = requestStructure;
    }

    public LinkedHashMap<String, List<Parameter>> getResponseStructure() {
        return responseStructure;
    }

    public void setResponseStructure(LinkedHashMap<String, List<Parameter>> responseStructure) {
        this.responseStructure = responseStructure;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam;
    }
}
