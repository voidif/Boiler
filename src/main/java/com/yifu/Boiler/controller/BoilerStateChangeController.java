package com.yifu.Boiler.controller;

import com.yifu.Boiler.domain.ResponseMsg;
import com.yifu.Boiler.exception.NoNeedToChangeStateException;
import com.yifu.Boiler.service.BoilerStateChangeService;
import com.yifu.Boiler.utils.ControllerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class BoilerStateChangeController {
    @Autowired
    BoilerStateChangeService boilerStateChangeService;
    @Autowired
    ControllerProperties controllerProperties;

    @RequestMapping(value = "/state/occupied", method = RequestMethod.POST)
    public ResponseMsg occupyBoiler(Integer time) {
        try {
            boilerStateChangeService.occupyBoiler(time);
            return ResponseMsg.builder().
                    status(controllerProperties.getSuccessCode()).build();
        } catch (NoNeedToChangeStateException e) {
            return ResponseMsg.builder().
                    status(controllerProperties.getFailureCode()).build();
        }
    }

    @RequestMapping(value = "/state/free", method = RequestMethod.POST)
    public ResponseMsg freeBoiler() {
        try {
            boilerStateChangeService.freeBoiler();
            return ResponseMsg.builder().
                    status(controllerProperties.getSuccessCode()).build();
        } catch (NoNeedToChangeStateException e) {
            return ResponseMsg.builder().
                    status(controllerProperties.getFailureCode()).build();
        }
    }
}
