package com.prosayj.springboot.notice;

import com.prosayj.springboot.utils.security.SecurityUtil;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Demo {

    public static void main(String[] args) {
        sendMail();
    }

    public static void sendMail() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        Map<String, String> emailConfig = new HashMap<String, String>();
        emailConfig.put("mail.smtp.writetimeout", "5000");
        emailConfig.put("mail.smtp.socketFactory.clas", "javax.net.ssl.SSLSocketFactory");
        emailConfig.put("mail.smtp.starttls.required", "true");
        emailConfig.put("mail.smtp.connectiontimeout", "5000");
        emailConfig.put("mail.smtp.host", "*");
        emailConfig.put("mail.smtp.timeout", "5000");
        emailConfig.put("mail.smtp.starttls.enable", "true");
        emailConfig.put("mail.smtp.auth", "true");
        emailConfig.put("mail.smtp.ssl.trust", "*");


        sender.setProtocol("smtp");
        sender.setHost("smtp.exmail.qq.com");
        sender.setUsername("service@yinuojr.cn");
        String password = SecurityUtil.decryptBasedDes("s+V+rjN+HLtbnwq2AX7vdw==");
        sender.setPassword(password);
        sender.setDefaultEncoding(Charset.forName("utf-8").name());


        sender.setPort(465);


        Properties ssl = asProperties(emailConfig, "SSL");
        sender.setJavaMailProperties(ssl);
        //发送
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("service@yinuojr.cn");
            message.setTo("yangjian@bubi.cn");
            message.setSubject("邀请码为[31ihhH]，您的合作伙伴（苏州缘来无界工艺品有限公司）邀请您开通平台账号，请用电脑登录：https://platform.yinuojr.cn/  进行账号注册并使用。提示：接受邀请即授权邀请企业查看您企业的实名相关信息。");
            message.setText("邀请企业实名认证");

            //logger.info("邮件服务开启，向邮箱：{}的内容为：{}", emailAddress, sendContent);
            try {
                sender.send(message);

            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (Exception e) {
            //logger.error("send email fail errorMessage:{}", e);
        }
    }

    private static Properties asProperties(Map<String, String> source, String encryptProtocol) {
        Properties properties = new Properties();
        properties.putAll(source);
        if ("TLS".equals(encryptProtocol)) {
            properties.remove("mail.smtp.socketFactory.class");
        }
        return properties;
    }

}
