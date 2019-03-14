package com.prosayj.springboot.blog.api.vo.input;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/14 18:16
 * @since 1.0.0
 */
public class IdVO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdVO{" +
                "id=" + id +
                '}';
    }
}
