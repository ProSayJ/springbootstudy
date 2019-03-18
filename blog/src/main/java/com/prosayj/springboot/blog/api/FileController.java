package com.prosayj.springboot.blog.api;

import com.prosayj.springboot.blog.models.image.domain.ImageDomain;
import com.prosayj.springboot.blog.models.image.mapper.ImageDomainMapper;
import com.prosayj.springboot.blog.models.image.module.ImageDTO;
import com.prosayj.springboot.blog.models.image.service.ImageService;
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
    private ImageService imageService;
    @Autowired
    private ImageDomainMapper imageDomainMapper;

    @ApiOperation(value = "图片上传", nickname = "file-controller-img-upload")
    @PostMapping("/img-upload")
    @ResponseBody
    public Object imgUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile fileMultipart) throws Exception {
        //目前只有一个文件上传的需求
        String trueFileName = fileMultipart.getOriginalFilename();
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

        FileUtils.transferImg(fileMultipart, srcImgDes, fileName);

        //在target下新建文件目录
        File classImgDesPath = new File(absoluteClassPath, Constants.IMG_SRC);
        if (!classImgDesPath.exists() || !classImgDesPath.isDirectory()) {
            classImgDesPath.mkdirs();
        }

        FileUtils.transferImg(fileMultipart, classImgDesPath.getAbsolutePath(), fileName);


        //入db
        InputStream inputStream = fileMultipart.getInputStream();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImgSource(InputStream2ByteArray(inputStream));

        Long save = imageService.save(imageDTO);
        ImageDomain imageDomain = imageDomainMapper.selectByPrimaryKey(save);
        FileUtils.byte2image(imageDomain.getImgSource(), "D:\\img\\haha","123.jpg");



        Map<String, Object> res = new HashMap<>();
        res.put("url", "http://localhost/static/images/upload/" + fileName);
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
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

    /**
     * 输入流转字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] InputStream2ByteArray(InputStream inputStream) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int num = inputStream.read(buffer);
            while (num != -1) {
                baos.write(buffer, 0, num);
                num = inputStream.read(buffer);
            }
            baos.flush();
            return baos.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

}
