package com.yifu.Boiler.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BoilerStateDatabase {
    private BoilerStates boilerState = BoilerStates.Free;
}


