package com.spring.security.config;

import com.spring.security.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//interceptor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
//registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/demo/**")
//        .excludePathPatterns("/authenticate/**");
        registry.addInterceptor(loggingInterceptor).addPathPatterns("/demo/**")
                .excludePathPatterns("/authenticate/**");
    }
}
