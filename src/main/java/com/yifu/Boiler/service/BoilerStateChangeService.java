package com.yifu.Boiler.service;

import com.yifu.Boiler.domain.BoilerStateDatabase;
import com.yifu.Boiler.domain.BoilerStates;
import com.yifu.Boiler.exception.NoNeedToChangeStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoilerStateChangeService {
    @Autowired
    BoilerStateDatabase boilerStateDatabase;

    public void occupyBoiler() throws NoNeedToChangeStateException {
        changeBoilerState(BoilerStates.Occupied);
    }

    public void freeBoiler() throws NoNeedToChangeStateException {
        changeBoilerState(BoilerStates.Free);
    }

    private void changeBoilerState(BoilerStates newState) throws NoNeedToChangeStateException {
        synchronized (boilerStateDatabase) {
            if (!boilerStateDatabase.getBoilerState().equals(newState)) {
                boilerStateDatabase.setBoilerState(newState);
            } else {
                throw new NoNeedToChangeStateException();
            }
        }
    }
}
