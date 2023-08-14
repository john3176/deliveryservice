package com.spring.designpattern.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class PayRequestDto {

    private String payerName;
    private String receiverName;
    private long amount;

}
