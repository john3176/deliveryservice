package com.spring.designpattern.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BankAccountAddMoneyRequestDto {

    private String name;
    private long money;
}
