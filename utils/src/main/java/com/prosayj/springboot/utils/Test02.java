package com.prosayj.springboot.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.models.Info;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_user.json")), "utf-8"));
        String jsonString = br.readLine().toString();
        Swagger swagger = new SwaggerParser().parse(jsonString);
        Info info = swagger.getInfo();
        String host = swagger.getHost();
        List<String> produces = swagger.getProduces();
        Path path = swagger.getPath("/functiontree/create");
        Operation post = path.getPost();
        List<String> tags = post.getTags();
        post.getSchemes();
        System.out.println(swagger.toString());

    }
}
