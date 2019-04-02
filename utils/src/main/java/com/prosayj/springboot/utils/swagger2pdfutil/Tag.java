package com.prosayj.springboot.utils.swagger2pdfutil;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 12:02
 * @since 1.0.0
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = -476434889637853336L;
    private String name;
    private String description;

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
}
