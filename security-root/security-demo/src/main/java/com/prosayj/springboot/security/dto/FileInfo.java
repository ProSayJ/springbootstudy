package com.prosayj.springboot.security.dto;

/**
 * @author yangjian
 * @description
 * @Date 下午 11:28 2019/11/3
 * @since 1.0.0
 */
public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
