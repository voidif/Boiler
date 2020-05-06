package com.yifu.Boiler.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControllerProperties {
    private static String SUCCESS_CODE_NAME = "success_code";
    private static String FAILURE_CODE_NAME = "failure_code";

    @Autowired
    Properties properties;

    public int getSuccessCode(){
        String successCode = properties.getProperty(SUCCESS_CODE_NAME);
        return Integer.valueOf(successCode);
    }

    public int getFailureCode() {
        String failureCode = properties.getProperty(FAILURE_CODE_NAME);
        return Integer.valueOf(failureCode);
    }
}
