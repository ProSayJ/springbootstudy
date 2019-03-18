package com.prosayj.springboot.utils;

import com.prosayj.springboot.constants.Constants;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

/**
 * @author yangjian
 * @description 文件IO操作工具类
 * @email ProSayj@gmail.com
 * @creatTime 2019/3/18 0:29
 * @since 1.0.0
 */
public class FileUtils {

    /**
     * 上传文件
     *
     * @param file
     * @param srcImgDes
     * @param fileName
     */
    public static void transferImg(MultipartFile file, String srcImgDes, String fileName) {
        //创建Resources下面的静态资源目录
        File srcImgDesPath = new File(srcImgDes);
        if (!srcImgDesPath.exists() || !srcImgDesPath.isDirectory()) {
            srcImgDesPath.mkdirs();
        }
        //创建Resources下面的静态资源目录中待上传的文件
        File targetImgDes = new File(srcImgDesPath.getAbsolutePath(), fileName);
        if (!targetImgDes.exists()) {
            try {
                targetImgDes.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //保存文件到Resources下面的静态资源目录中
        try {
            file.transferTo(targetImgDes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 图片到byte数组
     *
     * @param path 图片路径
     * @return
     */
    public static byte[] image2byte(String path) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

    /**
     * byte数组到图片
     *
     * @param data              图片二进制文件
     * @param fullPathAndSuffix 图片全路径(有名称有后缀)
     */

    public static void byte2image(byte[] data, String fullPathAndSuffix) {
        if (data.length < 3 || fullPathAndSuffix.equals(Constants.ENPTY_STRING)) {
            return;
        }
/*
        String path = fullPathAndSuffix.substring(Constants.ZERO, fullPathAndSuffix.lastIndexOf(Constants.POINT));

        try {
            File fdir = new File(substring);
            if (!fdir.isDirectory() || !fdir.exists()) {
                fdir.mkdirs();
            }
            File emptyFile = new File(fdir, "hhh.jpg");
            FileImageOutputStream imageOutput = new FileImageOutputStream(emptyFile);
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
//            System.out.println("Make Picture success,Please find image in " + path);
        } catch (Exception ex) {
//            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }*/
    }

    /**
     * @param data     图片二进制文件
     * @param path     图片存储绝对路径
     * @param fileName 图片名称(有后缀)
     */
    public static void byte2image(byte[] data, String path, String fileName) {
        try {
            File fdir = new File(path);
            if (!fdir.isDirectory() || !fdir.exists()) {
                fdir.mkdirs();
            }
            File emptyFile = new File(fdir, fileName);
            FileImageOutputStream imageOutput = new FileImageOutputStream(emptyFile);
            imageOutput.write(data, Constants.ZERO, data.length);
            imageOutput.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * byte数组到16进制字符串
     *
     * @param data
     * @return
     */
    public static String byte2string(byte[] data) {
        if (data == null || data.length <= 1) return "0x";
        if (data.length > 200000) return "0x";
        StringBuffer sb = new StringBuffer();
        int buf[] = new int[data.length];
        //byte数组转化成十进制
        for (int k = 0; k < data.length; k++) {
            buf[k] = data[k] < 0 ? (data[k] + 256) : (data[k]);
        }
        //十进制转化成十六进制
        for (int k = 0; k < buf.length; k++) {
            if (buf[k] < 16) sb.append("0" + Integer.toHexString(buf[k]));
            else sb.append(Integer.toHexString(buf[k]));
        }
        return "0x" + sb.toString().toUpperCase();
    }

}
