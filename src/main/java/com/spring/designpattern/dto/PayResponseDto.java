package com.spring.designpattern.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class PayResponseDto {

    private String receiverName;
    private long amount;
    private long deposit;
}
