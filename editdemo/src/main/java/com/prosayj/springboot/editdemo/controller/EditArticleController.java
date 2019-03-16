package com.prosayj.springboot.editdemo.controller;

import com.prosayj.springboot.editdemo.controller.constant.Constant;
import com.prosayj.springboot.editdemo.controller.vo.Blogs;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/13 11:15
 * @since 1.0.0
 */
@Controller
public class EditArticleController {

    @GetMapping("/editor")
    public String login() {
        return "example/editor";
    }


    @PostMapping("/publishArticle")
    @ResponseBody
    public Map<String, String> publishArticle(Blogs blogs, HttpServletRequest request) {
        String mdArticleContent = blogs.getArticleContent();
        System.out.println(mdArticleContent);
        //获得文章html代码并生成摘要
        String articleHtmlContent = blogs.getArticleHtmlContent();
        System.out.println(articleHtmlContent);

//        Constant.mdSrc_1 = mdArticleContent;
        Constant.mdSrc = mdArticleContent;

        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
        return result;
    }

    @GetMapping("/test.md")
    @ResponseBody
    public String testMd() {
//        return Constant.mdSrc_1;
        return Constant.mdSrc;
    }

    @PostMapping("/img-upload")
    @ResponseBody
    public Object imgUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file) throws Exception {
        String trueFileName = file.getOriginalFilename();
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + suffix;

        //获取根目录
        File classpath = new File(ResourceUtils.getURL("classpath:").getPath());
        if (!classpath.exists()) {
            classpath = new File("");
        }
        //C:\workspace\idea_workspace\git\springbootstudy\editdemo\target\classes
        //获取根目录的绝对路径
        String absoluteClassPath = classpath.getAbsolutePath();
        System.out.println("path:" + absoluteClassPath);

        //处理路径指定到Resources下面的静态资源位置
        String srcImgDes = new StringBuffer()
                .append(absoluteClassPath.substring(0, absoluteClassPath.indexOf("\\target")))
                .append("\\src\\main\\resources\\static\\images\\upload").toString();
        //创建Resources下面的静态资源目录
        File srcImgDesPath = new File(srcImgDes);
        if (!srcImgDesPath.exists() || !srcImgDesPath.isDirectory()) {
            srcImgDesPath.mkdirs();
        }
        //创建Resources下面的静态资源目录中待上传的文件
        File targetImgDes = new File(srcImgDesPath.getAbsolutePath(), fileName);
        if (!targetImgDes.exists()) {
            targetImgDes.createNewFile();
        }
        //保存文件到Resources下面的静态资源目录中
        try {
            file.transferTo(targetImgDes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //在target下新建文件目录
        File classImgDesPath = new File(absoluteClassPath, "static/images/upload/");
        if (!classImgDesPath.exists() || !classImgDesPath.isDirectory()) {
            classImgDesPath.mkdirs();
        }
        //在target下新建待上传的图片文件存储目录
        File catalog = new File(classImgDesPath.getAbsolutePath());
        if (!catalog.exists() || !catalog.isDirectory()) {
            catalog.mkdirs();
        }
        //在target下的上传的图片文件存储目录新建空的待上传的文件
        File targetFile = new File(classImgDesPath.getAbsolutePath(), fileName);
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        //上传图片到target下的图片文件存储目录
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Map<String, Object> res = new HashMap<>();
        res.put("url", "http://localhost:8888/static/images/upload/" + targetFile.getName());
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
    }

}
