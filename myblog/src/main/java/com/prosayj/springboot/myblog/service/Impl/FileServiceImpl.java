package com.prosayj.springboot.myblog.service.Impl;

import com.prosayj.springboot.constants.Constants;
import com.prosayj.springboot.myblog.repository.domain.ArticleDomain;
import com.prosayj.springboot.myblog.repository.mapper.ArticleDomainMapper;
import com.prosayj.springboot.myblog.models.dto.ImageDTO;
import com.prosayj.springboot.myblog.repository.domain.ImageDomain;
import com.prosayj.springboot.myblog.repository.mapper.ImageDomainMapper;
import com.prosayj.springboot.myblog.service.ImageService;
import com.prosayj.springboot.myblog.service.FileService;
import com.prosayj.springboot.utils.BeanUtil;
import com.prosayj.springboot.utils.FileUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageDomainMapper imageDomainMapper;
    @Autowired
    private ArticleDomainMapper articleDomainMapper;

    @Override
    public String uploadImg(MultipartFile fileMultipart, Long articleId, Boolean needUpLoad2ClassPath) throws IOException {
        ArticleDomain articleDomain = articleDomainMapper.selectByPrimaryKey(articleId);
        String articleMdContent = articleDomain.getArticleMdContent();
        //目前只有一个文件上传的需求
        String fullName = fileMultipart.getOriginalFilename();
        String suffix = fullName.substring(fullName.lastIndexOf(Constants.POINT));
        String trueFileName = fullName.substring(fullName.lastIndexOf(Constants.SEPARATOR) + 1, fullName.lastIndexOf(Constants.POINT));
        String fileName = trueFileName + "_" + System.currentTimeMillis() + "_" + suffix;
        if (needUpLoad2ClassPath) {
            FileUtils.upload2ClassPath(fileMultipart, fileName);
        }
        //image入db
        InputStream inputStream = fileMultipart.getInputStream();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setArticleId(articleDomain.getId());
        imageDTO.setImgSource(FileUtils.inputStream2ByteArray(inputStream));
        //后缀
        imageDTO.setImgSuffix(suffix);
        //文件名+后缀
        imageDTO.setImgName(fileName);
        //导出的静态资源的路径
        imageDTO.setImgStaticUrl("\\static\\images\\upload\\" + articleDomain.getArticleTitle());
        //处理原文中不需要的file文件：
        List<ImageDomain> imgs = imageDomainMapper.getByArticleId(articleId);
        imgs.forEach(img->{
            if (!articleMdContent.contains(img.getImgDbUrl())){
                imageDomainMapper.deleteByPrimaryKey(img.getId());
            }
        });

        return imageService.save(imageDTO);
    }

    @Override
    public void exoprtAllImgs() {
        String path = "D:\\static\\images\\upload";
        List<ImageDomain> allImage = imageDomainMapper.getAllImage();
        allImage.forEach(data -> {
            FileUtils.byte2image(data.getImgSource(), "D:\\" + data.getImgStaticUrl(), data.getImgName());
        });
    }

    @Override
    public List<ImageDTO> getAllImgsDetails() {
        List<ImageDomain> allImage = imageDomainMapper.getAllImage();
        List<ImageDTO> imageDTOS = BeanUtil.toBeanList(allImage, ImageDTO.class);
        return imageDTOS;
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
