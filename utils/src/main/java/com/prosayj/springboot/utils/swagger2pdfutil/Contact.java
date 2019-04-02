package com.prosayj.springboot.utils.swagger2pdfutil;

import java.io.Serializable;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 12:00
 * @since 1.0.0
 */
public class Contact implements Serializable {
    private static final long serialVersionUID = -4347292344740962108L;

    private String name;
    private String url;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
