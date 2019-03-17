package com.prosayj.springboot.blog.api;

import com.prosayj.springboot.constants.Constants;
import com.prosayj.springboot.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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


    @ApiOperation(value = "图片上传", nickname = "file-controller-img-upload")
    @PostMapping("/img-upload")
    @ResponseBody
    public Object imgUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file) throws Exception {
        String trueFileName = file.getOriginalFilename();
        String suffix = trueFileName.substring(trueFileName.lastIndexOf(Constants.POINT));
        String fileName = System.currentTimeMillis() + suffix;

        //获取根目录
        File classpath = new File(ResourceUtils.getURL(Constants.CLASSPATH).getPath());
        if (!classpath.exists()) {
            classpath = new File(Constants.ENPTY_STRING);
        }
        //获取根目录的绝对路径D:\workspace\git\springbootstudy\blog\target\classes
        String absoluteClassPath = classpath.getAbsolutePath();

        //处理路径指定到Resources下面的静态资源位置：D:\workspace\git\springbootstudy\blog/src/main/resources/static/images/upload
        String srcImgDes = new StringBuffer()
                .append(absoluteClassPath.substring(Constants.ZERO, absoluteClassPath.indexOf(Constants.TARGET)))
                .append(Constants.RESOURCE_PATH).toString();


        FileUtils.transferImg(file,srcImgDes,fileName);


        //在target下新建文件目录
        File classImgDesPath = new File(absoluteClassPath, Constants.IMG_SRC);
        if (!classImgDesPath.exists() || !classImgDesPath.isDirectory()) {
            classImgDesPath.mkdirs();
        }

        FileUtils.transferImg(file,classImgDesPath.getAbsolutePath(),fileName);


        Map<String, Object> res = new HashMap<>();
        res.put("url", "http://localhost/static/images/upload/" + fileName);
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
    }

}
