package com.prosayj.springboot.security.web.controller;

import com.prosayj.springboot.security.dto.FileInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

@Api(value = "FileController123", tags = "FileController345", description = "文件控制器")
@RestController
@RequestMapping("/file")
public class FileController {
    private String folder = "D:\\workspace\\git\\springbootstudy\\security-root\\security-demo\\src\\main\\java\\com\\prosayj\\springboot\\security\\web\\controller";

    @ApiOperation(value = "上传文件")
    @PostMapping
    public FileInfo upload(MultipartFile file) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //try中的流可以自动关闭
        try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }
}
