package com.spring.designpattern.domain.bankaccount.paymentlogic;

import com.spring.designpattern.domain.bankaccount.BankAccount;
import com.spring.designpattern.domain.bankaccount.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashMap;

public class PaymentProxy implements PaymentLogic {

    private HashMap<String, BankAccount> cashMap = new HashMap<>();
    private final BankAccountRepository repository;
    private final String senderName;
    private final String receiverName;
    private final long amount;
    private PaymentLogic payment;


    public PaymentProxy(String senderName, String receiverName, long amount, BankAccountRepository repository){
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.amount = amount;
        this.repository = repository;
    }

    @Override
    public long payment() throws Exception{
        LocalDateTime start = LocalDateTime.now();
        BankAccount sender;
        BankAccount receiver;
        if(cashMap.containsKey(senderName)){
            sender = cashMap.get(senderName);
        } else{
            sender = repository.findByName(senderName).orElseThrow(()-> new IllegalArgumentException("사용자가 없습니다."));
            cashMap.put(senderName, sender);
        }

        if(cashMap.containsKey(receiverName)){
            receiver = cashMap.get(receiverName);
        } else{
            receiver = repository.findByName(receiverName).orElseThrow(() -> new IllegalArgumentException("사용자가 없습니다."));
            cashMap.put(receiverName, receiver);
        }

        payment = new PaymentImpl(sender, receiver, amount);
        System.out.println(LocalDateTime.now().getNano() - start.getNano());
        return payment.payment();
    }
}
