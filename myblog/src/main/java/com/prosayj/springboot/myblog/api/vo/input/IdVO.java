package com.prosayj.springboot.blog_t.api.vo.input;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/14 18:16
 * @since 1.0.0
 */
public class IdVO {
    @ApiModelProperty(value = "主键Id", required = false)
    private Long id;
    @ApiModelProperty(value = "业务主键Id", required = false)
    private Long businessId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "IdVO{" +
                "id=" + id +
                ", businessId=" + businessId +
                '}';
    }
}
