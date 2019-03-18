package com.prosayj.springboot.blog.api;

import com.prosayj.springboot.blog.models.image.domain.ImageDomain;
import com.prosayj.springboot.blog.models.image.mapper.ImageDomainMapper;
import com.prosayj.springboot.blog.models.image.module.ImageDTO;
import com.prosayj.springboot.blog.models.image.service.ImageService;
import com.prosayj.springboot.blog.models.service.FileService;
import com.prosayj.springboot.constants.Constants;
import com.prosayj.springboot.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description 文件上传控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/16 15:59
 * @since 1.0.0
 */
@Api(value = "file-controller", tags = "file-controller", description = "文件上传控制器")
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "图片上传", nickname = "file-controller-img-upload")
    @PostMapping("/img-upload")
    @ResponseBody
    public Object imgUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile fileMultipart) throws Exception {
        String trueFileName = fileMultipart.getOriginalFilename();
        String suffix = trueFileName.substring(trueFileName.lastIndexOf(Constants.POINT));
        String fileName = System.currentTimeMillis() + suffix;


        fileService.uploadImg(fileMultipart, Boolean.TRUE);


        Map<String, Object> res = new HashMap<>();
        res.put("url", "http://localhost/static/images/upload/" + fileName);
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
    }

}
