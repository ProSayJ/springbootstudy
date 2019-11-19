package com.prosayj.springboot.utils.parseswagger;

import io.swagger.models.Model;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.Parameter;
import io.swagger.parser.SwaggerParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 06:42
 * @since 1.0.0
 */
public class PaserNew {
    public static void main(String[] args) throws IOException {

        String swaggerJosn = PaserSwaggerJson2Objects.getSwaggerJosn("api-docs.json");
        Swagger swagger = new SwaggerParser().parse(swaggerJosn);
        Map<String, Path> paths = swagger.getPaths();
        paths.forEach((url,path)->{
            System.out.println("url = " + url);
            Operation get = path.getGet();
            Operation post = path.getPost();
            if (post != null) {
                System.out.println("post.getSummary() = " + post.getSummary());
                List<Parameter> parameters = post.getParameters();
                parameters.forEach(parameter -> {
                    if (parameter instanceof BodyParameter) {
                        BodyParameter bodyParameter = (BodyParameter)parameter;
                        String bodyParameterName = bodyParameter.getName();
                        boolean required = bodyParameter.getRequired();

                        String reference = bodyParameter.getSchema().getReference();
                        swagger.getDefinitions().forEach((modelKey,modelDetail)->{
                            if (reference.contains(modelKey)) {
                                modelDetail.getProperties().forEach((propertiesKey,propertiesValue)->{
                                    System.out.println("propertiesKey = " + propertiesKey);
                                   /* if (propertiesValue instanceof  ) {

                                    }*/// 根据类型初始化默认值
                                    System.out.println("propertiesValue.getDescription() = " + propertiesValue.getDescription());
                                    System.out.println("propertiesValue.getType() = " + propertiesValue.getType());

                                    System.out.println("=======");

                                });
                            }
                        });

                    }
                });

            }

        });


    }
}
