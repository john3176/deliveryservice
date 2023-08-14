package com.spring.designpattern.domain.bankaccount.paymentlogic;

import com.spring.designpattern.domain.bankaccount.BankAccount;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentImpl implements PaymentLogic {

    private final BankAccount sender;
    private final BankAccount receiver;
    private final long amount;

    @Override
    public long payment() {
        try{
            sender.subMoney(amount);
            receiver.addMoney(amount);
            return sender.getDeposit();
        }catch(Exception e){
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
    }
}
