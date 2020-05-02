package com.yifu.Boiler.controller;

import com.yifu.Boiler.domain.RequestResult;
import com.yifu.Boiler.exception.NoNeedToChangeStateException;
import com.yifu.Boiler.service.BoilerStateChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoilerStateChangeController {
    @Autowired
    BoilerStateChangeService boilerStateChangeService;

    @RequestMapping(value = "/state/occupied", method = RequestMethod.POST)
    public RequestResult occupyBoiler() {
        try {
            boilerStateChangeService.occupyBoiler();
            return new RequestResult("successful");
        } catch (NoNeedToChangeStateException e) {
            return new RequestResult("failed");
        }
    }

    @RequestMapping(value = "/state/free", method = RequestMethod.POST)
    public RequestResult freeBoiler() {
        try {
            boilerStateChangeService.freeBoiler();
            return new RequestResult("successful");
        } catch (NoNeedToChangeStateException e) {
            return new RequestResult("failed");
        }
    }
}
