package ru.itis.spring_test.webconf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("resources/", "static/", "public/",
                        "META-INF/resources/")
                .addResourceLocations("classpath:resources/", "classpath:static/",
                        "classpath:public/", "classpath:META-INF/resources/");

    }
}
