package com.spring.designpattern.service;

import com.spring.designpattern.domain.bankaccount.BankAccount;
import com.spring.designpattern.domain.bankaccount.BankAccountRepository;
import com.spring.designpattern.dto.BankAccountAddMoneyRequestDto;
import com.spring.designpattern.dto.BankAccountChangeMoneyResponseDto;
import com.spring.designpattern.dto.BankAccountCreateRequestDto;
import com.spring.designpattern.dto.BankAccountSubMoneyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Transactional
    public Long createAccount(BankAccountCreateRequestDto request) throws Exception{
        if(!bankAccountRepository.findByName(request.getName()).isEmpty()){
            throw new IllegalArgumentException();
        }
        return bankAccountRepository.save(BankAccount.builder()
                        .name(request.getName())
                        .deposit(request.getInitDeposit())
                        .build())
                .getId();
    }

    @Transactional
    public BankAccountChangeMoneyResponseDto add(BankAccountAddMoneyRequestDto request) throws Exception{
        BankAccount account = bankAccountRepository.findByName(request.getName()).orElseThrow(() -> new IllegalArgumentException());
        return account.addMoney(request);
    }

    @Transactional
    public BankAccountChangeMoneyResponseDto sub(BankAccountSubMoneyRequestDto request) throws Exception {
        BankAccount account = bankAccountRepository.findByName(request.getName()).orElseThrow(() -> new IllegalArgumentException());
        return account.subMoney(request);
    }
}
