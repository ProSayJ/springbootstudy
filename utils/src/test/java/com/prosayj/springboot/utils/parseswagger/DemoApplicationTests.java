package com.prosayj.springboot.utils.parseswagger;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author yangjian
 * @description mavn 命令执行：asciidoctor:process-asciidoc 生成 html静态页面
 * bug：有的swagger.json文件不规范可能解析出错
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/12 16:40
 * @since 1.0.0
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DemoApplicationTests {

//    @Test
    public void generateAsciiDocsToFile() throws Exception {
        String swaggerJosn = getSwaggerJosn("api-docs_user.json");
//        String swaggerJosn = getSwaggerJosn("api-docs_api.json");
        //	输出Ascii到一个文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .build();

//        Swagger2MarkupConverter.from(new URL("http://localhost/v2/api-docs"))
        Swagger2MarkupConverter.from(swaggerJosn)
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/docs/asciidoc/generated/all"));
    }

//    @Test
    public void generateAsciiDocs() throws Exception {
        //	输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/asciidoc/generated"));
    }

//    @Test
    public void generateMarkdownDocs() throws Exception {
        //	输出Markdown格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost/v2/api-docs"))
//        Swagger2MarkupConverter.from(new URL("http://localhost:28009/service/v2/api-docs"))
                .withConfig(config)
                .build()
//				.toFolder(Paths.get("src/docs/markdown/generated"));
                .toFolder(Paths.get("src/docs/markdown/generated/all"));
    }

//    @Test
    public void generateConfluenceDocs() throws Exception {
        //	输出Confluence使用的格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/confluence/generated"));
    }

//    @Test
    public void generateMarkdownDocsToFile() throws Exception {
        //	输出Markdown到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/docs/markdown/generated/all"));
    }

    public static void main(String[] args) throws IOException {
        getSwaggerJosn("api-docs_user.json");
    }

    public static String getSwaggerJosn(String fileName) throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
//        String filePath = "C:\\workspace\\idea_workspace\\git\\springbootstudy\\utils\\src\\main\\resources\\export\\in\\" + fileName;
        String filePath = "D:\\workspace\\git\\springbootstudy\\utils\\src\\main\\resources\\export\\in\\" + fileName;
        File fileSrc = new File(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileSrc), "utf-8"));
        return br.readLine();
    }

}
