package com.prosayj.springboot.utils.swagger2pdfutil;

import java.io.Serializable;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 14:09
 * @since 1.0.0
 */
public class Schema implements Serializable {
    private static final long serialVersionUID = -7840793241277710229L;
    private String type;
    private String format;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "type='" + type + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
