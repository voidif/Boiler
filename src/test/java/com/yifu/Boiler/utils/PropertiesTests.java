package com.yifu.Boiler.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Properties.class)
public class PropertiesTests {
    @Autowired
    Properties properties;

    @Test
    void getPropertiesTest() {
        String constant = properties.getProperty("success_code");
        System.out.printf(constant);
    }
}
