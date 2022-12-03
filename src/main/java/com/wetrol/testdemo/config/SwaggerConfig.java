package com.wetrol.testdemo.config;


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

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /**
     * 创建Swagger2对象
     *
     *
     * */
    @Bean
    public Docket mapRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("坐标转化API")
                .apiInfo(apiInfo())
                //配置useDefaultResponseMessages(false) 可以使swagger-ui不再生成默认的401 403 404
//                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wetrol.testdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置api信息
     * title:swagger题目
     * description:描述
     * cotact:创建者
     *
     * @return
     */

    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("微服务api")
                .description("springboot 框架小服务")
                .contact(new Contact("Timothy",null,"yuhao.zhao@wetrol.com"))
                .build();
    }

    @Bean
    public Docket springBootApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("groupName: SpringBoot2特性测试")
                .apiInfo(bootApi())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.wetrol.testdemo.controller"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo bootApi(){
        return new  ApiInfoBuilder()
                .title("title: Springboot2测试 api")
                .description("description 这是我bootApi的描述信息")
                .contact(new Contact("Timothy","www.baidu.com","yuhao.zhao@wetrol.com"))
                .build();
    }

}
