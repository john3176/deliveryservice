package com.spring.designpattern.controller;

import com.spring.designpattern.dto.BankAccountAddMoneyRequestDto;
import com.spring.designpattern.dto.BankAccountChangeMoneyResponseDto;
import com.spring.designpattern.dto.BankAccountCreateRequestDto;
import com.spring.designpattern.dto.BankAccountSubMoneyRequestDto;
import com.spring.designpattern.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bankaccount")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping("/create")
    public Long create(BankAccountCreateRequestDto request) throws Exception {
        return bankAccountService.createAccount(request);
    }

    @PostMapping("/add")
    public BankAccountChangeMoneyResponseDto add(BankAccountAddMoneyRequestDto request) throws Exception{
        return bankAccountService.add(request);
    }

    @PostMapping("/sub")
    public BankAccountChangeMoneyResponseDto sub(BankAccountSubMoneyRequestDto request) throws Exception{
        return bankAccountService.sub(request);
    }

}
