package com.wetrol.testdemo;

import com.wetrol.testdemo.domain.MyCar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.ConfigurableEnvironment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Map;

@SpringBootApplication
//@EnableConfigurationProperties(MyCar.class)
@ImportResource("classpath:beans.xml")
public class TestDemoApplication {

    public static void main(String[] args) {
        String s ="练习合并代码冲突";
        ConfigurableApplicationContext run = SpringApplication.run(TestDemoApplication.class, args);

        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        System.out.println("bean的所有数量： " + beanDefinitionNames.length);

//        for (String s : beanDefinitionNames){
//            System.out.println("beanName:" + s);
//        }

        ConfigurableEnvironment environment = run.getEnvironment();
        Map<String, Object> systemEnvironment =
                environment.getSystemEnvironment();

        Map<String, Object> systemProperties = environment.getSystemProperties();

        System.out.println(systemEnvironment);
        System.out.println(systemProperties);
    }

}
