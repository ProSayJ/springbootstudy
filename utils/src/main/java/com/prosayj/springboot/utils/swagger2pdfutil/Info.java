package com.prosayj.springboot.utils.swagger2pdfutil;

import java.io.Serializable;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 11:57
 * @since 1.0.0
 */
public class Info implements Serializable {

    private static final long serialVersionUID = -4909006333135960101L;

    private String description;

    private String version;

    private String title;

    private String termsOfService;

    private Contact contact;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Info{" +
                "description='" + description + '\'' +
                ", version='" + version + '\'' +
                ", title='" + title + '\'' +
                ", termsOfService='" + termsOfService + '\'' +
                ", contact=" + contact +
                '}';
    }
}
