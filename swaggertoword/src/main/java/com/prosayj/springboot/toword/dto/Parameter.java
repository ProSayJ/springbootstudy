package com.prosayj.springboot.toword.dto;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:35
 * @since 1.0.0
 */
public class Parameter extends Request {
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Parameter)) {
            return false;
        } else {
            Parameter other = (Parameter) o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Parameter;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "Parameter()";
    }
}
