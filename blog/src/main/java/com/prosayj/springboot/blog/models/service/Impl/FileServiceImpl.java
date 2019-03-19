package com.prosayj.springboot.blog.models.service.Impl;

import com.prosayj.springboot.blog.models.image.domain.ImageDomain;
import com.prosayj.springboot.blog.models.image.mapper.ImageDomainMapper;
import com.prosayj.springboot.blog.models.image.module.ImageDTO;
import com.prosayj.springboot.blog.models.image.service.ImageService;
import com.prosayj.springboot.blog.models.service.FileService;
import com.prosayj.springboot.constants.Constants;
import com.prosayj.springboot.utils.FileUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageDomainMapper imageDomainMapper;

    @Override
    public Boolean uploadImg(MultipartFile fileMultipart, Boolean needUpLoad2ClassPath) throws IOException {
        //目前只有一个文件上传的需求
        String trueFileName = fileMultipart.getOriginalFilename();
        String suffix = trueFileName.substring(trueFileName.lastIndexOf(Constants.POINT));
        String fileName = System.currentTimeMillis() + suffix;
        if (needUpLoad2ClassPath) {
            FileUtils.upload2ClassPath(fileMultipart, fileName);
        }
        //image入db
        InputStream inputStream = fileMultipart.getInputStream();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImgSource(FileUtils.inputStream2ByteArray(inputStream));
        imageDTO.setImgSuffix(suffix);
        imageDTO.setImgName(fileName);
        imageService.save(imageDTO);
        return Boolean.TRUE;
    }

    @Override
    public void exoprtAllImgs() {
        String path = "D:\\img\\haha";
        List<ImageDomain> allImage = imageDomainMapper.getAllImage();
        allImage.forEach(data -> {
            FileUtils.byte2image(data.getImgSource(), path, data.getImgName());
        });
    }

    @Override
    public void downloadImage(Long id, HttpServletResponse response) throws IOException {
        ImageDomain imageDomain = imageDomainMapper.selectByPrimaryKey(id);
        byte[] imgSource = imageDomain.getImgSource();
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition",
                "attachment;fileName=" + imageDomain.getImgName());// 设置文件名
        OutputStream os = response.getOutputStream();
        os.write(imgSource);
    }

    private boolean multipartCheck(HttpServletRequest request) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            //TODO:throw:请求必须是文件格式
        }
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);

        Map<String, MultipartFile> multiFiles = multipartRequest.getFileMap();
        if (multiFiles.isEmpty()) {
            //TODO:throw:请求文件列表为空
        }
        return isMultipart;
    }

}
