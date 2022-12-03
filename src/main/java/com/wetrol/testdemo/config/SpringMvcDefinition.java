package com.wetrol.testdemo.config;

import com.wetrol.testdemo.domain.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.List;

@Configuration
public class SpringMvcDefinition {

    /**
     * 更改 rest风格请求的 隐藏前缀
     * 默认为 _method
     */
    @Bean
    public HiddenHttpMethodFilter methodFilterDefinition(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_mmm");
        return hiddenHttpMethodFilter;
    }


    @Bean
    public WebMvcConfigurer enableMatrixVariable(){
        return new WebMvcConfigurer() {

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                //自定义 MessageConverter
                //并且添加到media Type 中
//                converters.add(new DefineUserMessageConverter());
                //提高优先级 0
                converters.add(0,new DefineUserMessageConverter());
            }

//            @Override
//            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//                converters.add(new DefineUserMessageConverter());
//            }

            //自定义mvc在接受参数时对于对象格式的处理逻辑
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        String s = " ";
                        System.out.println("hasLength "+StringUtils.hasLength(s));
                        System.out.println("hasText "+StringUtils.hasText(s));
                        if(StringUtils.hasLength(source)){
                            String[] split = source.split(",");
                            int length = split.length;
                            Pet pet = new Pet();
                            pet.setGender(split[0]);
                            pet.setColor(split[1]);
                            pet.setAge(Integer.parseInt(split[2]));
                            return pet;
                        }
                        return null;
                    }
                });
            }
            //为使用矩阵变量，需要把springMvc中默认移除 ";" 改为false
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }

}
