package com.prosayj.springboot.utils.easycaptchautil;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/1/11 15:26
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        getGif();
        getPng();
        getChineseGif();
        getChinesPng();


    }

    private static void getChinesPng() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(new File("D:/a/4.png"));
        // 三个参数分别为宽、高、位数
        ChineseCaptcha chineseCaptcha = new ChineseCaptcha(130, 48, 4);
        // 设置字体
        chineseCaptcha.setFont(new Font("楷体", Font.PLAIN, 28));  // 有默认字体，可以不用设置
        // 生成的验证码
        String code = chineseCaptcha.text();
        // 输出图片流
        chineseCaptcha.out(outputStream);
    }

    private static void getChineseGif() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(new File("D:/a/3.gif"));
        // 三个参数分别为宽、高、位数
        ChineseGifCaptcha chineseGifCaptcha = new ChineseGifCaptcha(130, 48, 4);
        // 设置字体
        chineseGifCaptcha.setFont(new Font("楷体", Font.PLAIN, 28));  // 有默认字体，可以不用设置
        // 生成的验证码
        String code = chineseGifCaptcha.text();
        // 输出图片流
        chineseGifCaptcha.out(outputStream);
    }

    private static void getPng() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(new File("D:/a/2.png"));
        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置字体
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        // 生成的验证码
        String code = specCaptcha.text();
        // 输出图片流
        specCaptcha.out(outputStream);
    }

    private static void getGif() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(new File("D:/a/1.gif"));
        // 三个参数分别为宽、高、位数
        GifCaptcha gifCaptcha = new GifCaptcha(130, 48, 5);
        // 设置字体
        gifCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        gifCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        // 生成的验证码
        String code = gifCaptcha.text();
        // 输出图片流
        gifCaptcha.out(outputStream);
    }
}
