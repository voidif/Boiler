package com.yifu.Boiler.service;

import com.yifu.Boiler.domain.BoilerStateDatabase;
import com.yifu.Boiler.domain.BoilerStates;
import com.yifu.Boiler.exception.NoNeedToChangeStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class BoilerStateChangeService {
    @Autowired
    BoilerStateDatabase boilerStateDatabase;
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    public void occupyBoiler(Integer countdownMinutes) throws NoNeedToChangeStateException {
        synchronized (boilerStateDatabase) {
            changeBoilerState(BoilerStates.Occupied);
            ScheduledFuture futureTask = executor.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        freeBoiler();
                    } catch (NoNeedToChangeStateException e) {
                        //TODO
                    }
                }
            }, countdownMinutes, TimeUnit.MINUTES);
            boilerStateDatabase.setCountdownTimerFutureTask(futureTask);
        }
    }

    public void freeBoiler() throws NoNeedToChangeStateException {
        synchronized (boilerStateDatabase) {
            changeBoilerState(BoilerStates.Free);
            boilerStateDatabase.getCountdownTimerFutureTask().cancel(false);
        }
    }

    private void changeBoilerState(BoilerStates newState) throws NoNeedToChangeStateException {
        if (!boilerStateDatabase.getBoilerState().equals(newState)) {
            boilerStateDatabase.setBoilerState(newState);
        } else {
            throw new NoNeedToChangeStateException();
        }
    }
}
