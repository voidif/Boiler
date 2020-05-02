package com.yifu.Boiler.controller;

import com.yifu.Boiler.domain.BoilerState;
import com.yifu.Boiler.service.BoilerStateQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class BoilerStateQueryController {
    @Autowired
    BoilerStateQueryService boilerStateQueryService;

    @RequestMapping("/state")
    public BoilerState getBoilerState(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST");
        return boilerStateQueryService.getCurrentBoilerState();
    }
}
