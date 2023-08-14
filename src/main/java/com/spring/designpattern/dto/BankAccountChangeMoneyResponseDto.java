package com.spring.designpattern.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BankAccountChangeMoneyResponseDto {

    private long id;
    private String name;
    private long deposit;
}
