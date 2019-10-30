package com.prosayj.springboot.notice;

import com.prosayj.springboot.utils.FileUtils;
import com.prosayj.springboot.utils.security.SecurityUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author yangjian
 * @description javamail测试类
 * @email yangjian@bubi.cn
 * @creatTime 2019/8/5 17:06
 * @since 1.0.0
 */
public class MailUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailUtil.class);
    private static String mailSmtpServer = "smtp.exmail.qq.com";
    private static String mailFrom = "service@yinuojr.cn";
    private static String mailPassword = SecurityUtil.decryptBasedDes("s+V+rjN+HLtbnwq2AX7vdw==");
    private static Session localSession = null;


    public static void main(String[] args) {
        sendEmail("这个是邮件主题",
                "这个是邮件内容",
                "wangguokang@bubi.cn");
    }

    /**
     * 邮件服务器初始化
     */
    private static void mealInit() {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", mailSmtpServer);
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        //端口号
        props.setProperty("mail.smtp.prot", "25");
        // 设置环境信息
        localSession = Session.getInstance(props, new javax.mail.Authenticator() {
            // 在session中设置账户信息，Transport发送邮件时会使用
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailFrom, mailPassword);
            }
        });
    }

    /**
     * 发送邮件
     *
     * @param subject     邮件主题
     * @param sendHtml    邮件内容
     * @param receiveUser 接收人邮箱地址
     */
    public static void sendEmail(String subject, String sendHtml, String receiveUser) {

        mealInit();

        try {
            String[] users = receiveUser.split(",");
            for (int i = 0; i < users.length; i++) {
                doSendHtmlEmail(subject, sendHtml, users[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送邮件
     *
     * @param subject     邮件主题
     * @param htmlContent 邮件内容
     * @param receiveUser 收件人地址
     */
    private static void doSendHtmlEmail(String subject, String htmlContent, String receiveUser) {
        try {
            // 创建邮件对象
            Message msg = new MimeMessage(localSession);
            // 发件人
            msg.setFrom(new InternetAddress(mailFrom));
            // 多个收件人
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiveUser));
            // 抄送人
            //msg.setRecipient(Message.RecipientType.CC, new InternetAddress("java_mail_001@163.com"));
            // 暗送人
            //msg.setRecipient(Message.RecipientType.BCC, new InternetAddress("java_mail_004@163.com"));
            // 主题
            msg.setSubject(subject);
            // HTML内容
            //msg.setContent(htmlContent, "text/html;charset=utf-8");


            //整封邮件的MINE消息体
            MimeMultipart msgMultipart = new MimeMultipart("mixed");//混合的组合关系
            //设置邮件的MINE消息体


            // 添加附件1
            MimeBodyPart attch1 = new MimeBodyPart();
            //DataHandler dh1 = new DataHandler(new FileDataSource(new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\线程的生命周期.png")) );
            byte[] picByte = MailUtil.getPicByte();
            DataHandler dh = new DataHandler(new ByteArrayDataSource(picByte, "application/octet-stream"));
            attch1.setDataHandler(dh);
            attch1.setFileName("file1.jpg");
            msgMultipart.addBodyPart(attch1);


            // 添加附件2_xlsx
            HSSFWorkbook workBook = new HSSFWorkbook();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            workBook.write(baos);
            byte[] bytes = baos.toByteArray();
            MimeBodyPart attch2 = new MimeBodyPart();
            attch2.setDataHandler(new DataHandler(new ByteArrayDataSource(bytes, "application/octet-stream")));
            attch2.setFileName("V3.4.0_证书管理排期.xlsx");
            msgMultipart.addBodyPart(attch2);


            //添加邮件内容
            MimeBodyPart content = new MimeBodyPart();
            content.setContent(htmlContent, "text/html;charset=utf-8");
            msgMultipart.addBodyPart(content);

            msg.setContent(msgMultipart);

            LOGGER.info("邮件服务开启，向邮箱：{}的内容为：{}", receiveUser, htmlContent);
            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static byte[] getPicByte() throws IOException {
        HSSFWorkbook workBook = new HSSFWorkbook();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workBook.write(baos);
        byte[] bytes = baos.toByteArray();
        String imgBase64 = FileUtils.getText("picBase64.txt");
        //前台在用Ajax传base64值的时候会把base64中的+换成空格，所以需要替换回来。去除base64中无用的部分
        String replace = imgBase64.replaceAll(" ", "+").replace("data:image/png;base64,", "");
        byte[] b = new BASE64Decoder().decodeBuffer(replace);
        //imgBase64 = imgBase64.replace("base64,", "");
        return b;
    }
}
