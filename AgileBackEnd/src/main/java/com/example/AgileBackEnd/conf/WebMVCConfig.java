package com.example.AgileBackEnd.conf;

import com.example.AgileBackEnd.handler.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    private LogInterceptor logInterceptor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //后续增加拦截路径
        //测试阶段暂时不拦截
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/articles/publish")
                .addPathPatterns("/comments/create/change");

    }
}
