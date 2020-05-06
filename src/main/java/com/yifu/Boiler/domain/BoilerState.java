package com.yifu.Boiler.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoilerState {
    private String boilerState;
    private int RemainingOccupiedTime;
}
