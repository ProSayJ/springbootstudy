package com.prosayj.springboot.myblog.api;

import com.prosayj.springboot.myblog.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public Map imgUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile fileMultipart, HttpServletRequest request) throws Exception {
        Long editorId = Long.parseLong(request.getParameter("editorId"));
        String imgDbUrl = fileService.uploadImg(fileMultipart, editorId, Boolean.FALSE);

        Map<String, Object> res = new HashMap<>();
//        res.put("url", "http://localhost/static/images/upload/" + fileName);//静态资源路径
//        res.put("url", "http://localhost/file/img-download?id=" + fileId);//db路径
        res.put("url", "http://localhost" + imgDbUrl);//db路径
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
    }


    @ApiOperation(value = "图片下载", nickname = "file-controller-img-download")
    @RequestMapping(value = "/img-download", method = RequestMethod.GET)
    public void downloadImage(com.prosayj.springboot.myblog.api.vo.input.IdVO idVO, HttpServletResponse response) {
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

    @ApiOperation(value = "修复所有文件的静态资源路径位置", nickname = "file-controller-img-expport-all")
    @PostMapping(value = "/img-staticsrc-repair")
    @ResponseBody
    public boolean staticSrcRepair() {
        return true;
    }

}