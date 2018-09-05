package com.prosayj.springboot.designmode.研磨设计模式._15_Template_method.example7;

public interface LoginCallback {
    public LoginModel findLoginUser(String loginId);

    public String encryptPwd(String pwd, LoginTemplate template);

    public boolean match(LoginModel lm, LoginModel dbLm, LoginTemplate template);
}
