package com.prosayj.springboot.blog.models.service;

import com.prosayj.springboot.blog.api.vo.input.IdVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
    /**
     * 上传图片
     *
     * @param multipartFile        文件上传对象
     * @param needUpLoad2ClassPath 是否需要上传到项目类路径下：true：需要
     * @return
     */
    Boolean uploadImg(MultipartFile multipartFile, Boolean needUpLoad2ClassPath) throws IOException;

    /**
     * 批量导出所有的图片文件
     */
    void exoprtAllImgs();


    /**
     * 下载图片
     *
     * @param id       图片id
     * @param response 相应流
     */
    void downloadImage(Long id, HttpServletResponse response) throws IOException;


}
