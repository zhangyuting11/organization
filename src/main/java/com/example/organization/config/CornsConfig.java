package com.example.organization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description@ // TODO 全局处理
 * @create@ create by zhangyuting 2020/11/05
 */
@Configuration
public class CornsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**").allowedHeaders("*").allowedOrigins("*").allowedMethods("*");
    }
}