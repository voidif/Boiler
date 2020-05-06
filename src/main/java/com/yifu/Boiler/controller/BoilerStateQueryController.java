package com.yifu.Boiler.controller;

import com.yifu.Boiler.domain.BoilerState;
import com.yifu.Boiler.domain.ResponseMsg;
import com.yifu.Boiler.service.BoilerStateQueryService;
import com.yifu.Boiler.utils.ControllerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BoilerStateQueryController {
    @Autowired
    BoilerStateQueryService boilerStateQueryService;
    @Autowired
    ControllerProperties controllerProperties;

    @RequestMapping("/state")
    public ResponseMsg<BoilerState> getBoilerState() {
        BoilerState currentState = boilerStateQueryService.getCurrentBoilerState();
        ResponseMsg<BoilerState> responseMsg = ResponseMsg.<BoilerState>builder().
                data(currentState).
                status(controllerProperties.getSuccessCode()).
                statusInfo("").build();
        return responseMsg;
    }
}
