package com.nfdw.utils;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public class MyWebAppConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/temp-rainy/**").addResourceLocations("file:D:/temp-rainy/");
    }

}
