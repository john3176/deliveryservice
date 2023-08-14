package com.spring.designpattern.service;

import com.spring.designpattern.domain.bankaccount.BankAccount;
import com.spring.designpattern.domain.bankaccount.BankAccountRepository;
import com.spring.designpattern.domain.bankaccount.paymentlogic.PaymentLogic;
import com.spring.designpattern.domain.bankaccount.paymentlogic.PaymentProxy;
import com.spring.designpattern.dto.BankAccountCreateRequestDto;
import com.spring.designpattern.dto.PayRequestDto;
import com.spring.designpattern.dto.PayResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BankAccountRepository bankAccountRepository;

    @Transactional
    public PayResponseDto pay(PayRequestDto request) throws Exception{
        PaymentLogic payment = new PaymentProxy(request.getPayerName(), request.getReceiverName(), request.getAmount(), bankAccountRepository);
        Long depositAfter = payment.payment();
        return PayResponseDto.builder()
                .receiverName(request.getReceiverName())
                .amount(request.getAmount())
                .deposit(depositAfter)
                .build();
    }
}
