package com.prosayj.springboot.myblog.service;

import com.prosayj.springboot.myblog.models.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface FileService {
    /**
     * 上传图片
     *
     * @param multipartFile        文件上传对象
     * @param articleId            文章id
     * @param needUpLoad2ClassPath 是否需要上传到项目类路径下：true：需要
     * @return
     */
    String uploadImg(MultipartFile multipartFile, Long articleId, Boolean needUpLoad2ClassPath) throws IOException;

    /**
     * 批量导出所有的图片文件
     */
    void exoprtAllImgs();


    /**
     * 获取所有文件相关信息
     *
     * @return
     */
    List<ImageDTO> getAllImgsDetails();


    /**
     * 下载图片
     *
     * @param id       图片id
     * @param response 相应流
     */
    void downloadImage(Long id, HttpServletResponse response) throws IOException;


}
