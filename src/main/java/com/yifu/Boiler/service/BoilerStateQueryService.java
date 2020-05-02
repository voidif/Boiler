package com.yifu.Boiler.service;

import com.yifu.Boiler.domain.BoilerState;
import com.yifu.Boiler.domain.BoilerStateDatabase;
import com.yifu.Boiler.domain.BoilerStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoilerStateQueryService {
    @Autowired
    BoilerStateDatabase boilerStateDatabase;

    public BoilerState getCurrentBoilerState() {
        synchronized (boilerStateDatabase) {
            BoilerStates boilerState = boilerStateDatabase.getBoilerState();
            return new BoilerState(boilerState.name());
        }
    }
}
