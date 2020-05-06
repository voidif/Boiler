package com.yifu.Boiler.service;

import com.yifu.Boiler.domain.BoilerState;
import com.yifu.Boiler.domain.BoilerStateDatabase;
import com.yifu.Boiler.domain.BoilerStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BoilerStateQueryService {
    @Autowired
    BoilerStateDatabase boilerStateDatabase;

    public BoilerState getCurrentBoilerState() {
        synchronized (boilerStateDatabase) {
            BoilerStates boilerState = boilerStateDatabase.getBoilerState();
            int countDownTime = 0;
            if (boilerState == BoilerStates.Occupied) {
                countDownTime = (int)boilerStateDatabase.getCountdownTimerFutureTask().getDelay(TimeUnit.SECONDS);
            }
            return new BoilerState(boilerState.name(), countDownTime);
        }
    }
}
