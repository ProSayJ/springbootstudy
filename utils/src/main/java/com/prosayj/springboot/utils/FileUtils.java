package com.prosayj.springboot.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author yangjian
 * @description 文件IO操作工具类
 * @email ProSayj@gmail.com
 * @creatTime 2019/3/18 0:29
 * @since 1.0.0
 */
public class FileUtils {

    public static void transferImg(MultipartFile file,String srcImgDes,String fileName){
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
}
