package com.lixiang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author GuoQiang
 * @create 2022-01-16 17:14
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        //http://ip地址:端口/项目名/swagger-ui.html#/
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("springCloud测试") //网站标题
                .description("测试") //网站描述
                .version("1.0") //版本
                .contact(new Contact("郭强", "https://www.baidu.com", "2949131036@qq.com")) //联系人
                .license("The Apache License") //协议
                .licenseUrl("http://www.baidu.com") //协议url
                .build();

        return new Docket(DocumentationType.SWAGGER_2) //swagger版本
                .pathMapping("/")
                .select()
                //扫描那些controller
                .apis(RequestHandlerSelectors.basePackage("com.lixiang.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }

}
