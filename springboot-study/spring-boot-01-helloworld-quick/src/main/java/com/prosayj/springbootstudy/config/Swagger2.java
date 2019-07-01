package com.prosayj.springbootstudy.config;

/**
 * @description swagger配置
 * @author yangjian
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/20 12:46
 * @since 1.0.0
 */
//@Configuration
public class Swagger2 {
   /* @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为controller包路径
                .apis(RequestHandlerSelectors.basePackage("com.prosayj.springboot.portal.api"))
                .paths(PathSelectors.any())
                .build();
    }*/

    //构建 api文档的详细信息函数
    /*private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot2.0使用 Swagger2 构建RestFul API")
                //创建人
                .contact(new Contact("ProSayJ", "http://localhost/swagger-ui.html", "ProSayJ@gmail.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API接口文档")
                .build();
    }*/
}
