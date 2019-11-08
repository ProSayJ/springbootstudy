package com.prosayj.springboot.utils.twocode;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/11/7 下午 12:21
 * @since 1.0.0
 */
public class QrCodeTest {
    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        String text = "https://blog.csdn.net/jam_fanatic/article/details/82818857";
        // 嵌入二维码的图片路径
        String imgPath = "C:\\Users\\ProSayJ\\Pictures\\123.jpg";
        // 生成的二维码的路径及名称
        String destPath = "D:/MyQRCode.png";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);

    }
}
