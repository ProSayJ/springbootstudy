package com.prosayj.springboot.utils.parseswagger;

import com.prosayj.springboot.constants.Constants;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwaggerJson2Word {
    public static void main(String[] args) throws IOException {
        // 读文件:api
//        File fileSrc = new File("C:\\workspace\\idea_workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_api.json");
//        File fileSrc = new File("C:\\workspace\\idea_workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_user.json");
//        File fileSrc = new File("D:\\workspace\\git\\springbootstudy\\utils\\src\\main\\java\\com\\prosayj\\springboot\\utils\\in" + "\\api-docs_api.json");


        File fileSrc = new File(ResourceUtils.getURL(Constants.CLASSPATH).getPath() + "\\export\\in\\api-docs_user2.json");


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileSrc), "utf-8"));
        String jsonString = br.readLine().toString();
        Map<String, List<Swagger>> map = paseSwaggerSimple(jsonString);

        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassForTemplateLoading(SwaggerJson2Word.class, "/template");
        configuration.setDefaultEncoding("utf-8");


        File file = new File("api.doc");
        try {
            Template template = configuration.getTemplate("word.ftl");
            FileWriter writer = new FileWriter(file);
            try {
                template.process(map, writer);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("create word failed.");
        }

    }

    public static Map<String, List<Swagger>> paseSwaggerSimple(String jsonString) {
        Swagger swagger = new SwaggerParser().parse(jsonString);
        Map<String, List<Swagger>> map = new HashMap<>();
        List<Swagger> list = new ArrayList<>();
        list.add(swagger);
        map.put("swaggers", list);
        return map;
    }
}
