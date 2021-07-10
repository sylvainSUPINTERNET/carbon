package com.carbon.apicarbon.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
            .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
            .allowedOrigins("http://localhost:3000")
            .allowedHeaders("*")
            .allowCredentials(true); // can't use * with credentials include in fetch from client
        }
    }