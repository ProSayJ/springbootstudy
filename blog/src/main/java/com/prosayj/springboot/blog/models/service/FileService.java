package com.prosayj.springboot.blog.models.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
    /**
     * 上传图片
     *
     * @param multipartFile        文件上传对象
     * @param needUpLoad2ClassPath 是否需要上传到项目类路径：true：需要
     * @return
     */
    Boolean uploadImg(MultipartFile multipartFile, Boolean needUpLoad2ClassPath) throws IOException;

    /**
     * 通过文件id下载文件
     *
     * @param id
     * @param path
     */
    void downloadImg(Long id, String path);


}
