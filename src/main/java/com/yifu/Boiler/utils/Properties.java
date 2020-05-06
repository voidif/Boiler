package com.yifu.Boiler.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/constant.properties")
public class Properties {
    @Autowired
    private Environment env;

    public String getProperty(String name) {
        return env.getProperty(name);
    }
}