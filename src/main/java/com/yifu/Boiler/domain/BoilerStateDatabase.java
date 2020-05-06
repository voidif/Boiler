package com.yifu.Boiler.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;

@Component
@Getter
@Setter
public class BoilerStateDatabase {
    private BoilerStates boilerState = BoilerStates.Free;
    private ScheduledFuture countdownTimerFutureTask;
}


