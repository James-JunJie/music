package com.junjie.music.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description:解决跨域问题
 * @author:LiJunJie
 * @Date 2020/12/26
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {//WebMvcConfigurer
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")// 不能用allowedOrigins，springboot2.4.0bug
                // 是否允许证书（cookies）
                .allowCredentials(true)
                // 设置允许的方法
                .allowedMethods("*")
                // 跨域允许时间
                .maxAge(3600);
    }
}