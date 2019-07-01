package com.prosayj.springbootstudy.api.vo.input;

public class UserQuery {

//    @ApiModelProperty(value = "登录名", required = false)
    private String name;
//    @ApiModelProperty(value = "用户名", required = false)
    private String trueName;
//    @ApiModelProperty(value = "手机号", required = false)
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}