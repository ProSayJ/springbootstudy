package com.prosayj.springboot.blog.api;

import com.prosayj.springboot.blog.api.vo.input.IdVO;
import com.prosayj.springboot.blog.models.service.FileService;
import com.prosayj.springboot.constants.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        fileService.uploadImg(fileMultipart, Boolean.FALSE);


        Map<String, Object> res = new HashMap<>();
        res.put("url", "http://localhost/static/images/upload/" + fileName);
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
    }


    @ApiOperation(value = "图片下载", nickname = "file-controller-img-download")
    @RequestMapping(value = "/img-download", method = RequestMethod.GET)
    public void downloadImage(IdVO idVO, HttpServletResponse response) {
        try {
            fileService.downloadImage(idVO.getId(), response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @ApiOperation(value = "导出所有图片到本地", nickname = "file-controller-img-expport-all")
    @PostMapping(value = "/img-expport-all")
    @ResponseBody
    public boolean exportAllImgs() {
        fileService.exoprtAllImgs();
        return true;
    }

}
