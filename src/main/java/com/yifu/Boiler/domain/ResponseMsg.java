package com.yifu.Boiler.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseMsg<T> {
    private T data;
    private int status;
    private String statusInfo;
}
