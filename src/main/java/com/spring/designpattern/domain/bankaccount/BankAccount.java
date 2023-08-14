package com.spring.designpattern.domain.bankaccount;

import com.spring.designpattern.dto.BankAccountAddMoneyRequestDto;
import com.spring.designpattern.dto.BankAccountChangeMoneyResponseDto;
import com.spring.designpattern.dto.BankAccountSubMoneyRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long deposit;

    public long addMoney(long amount){
        deposit = deposit + amount;
        return deposit;
    }

    public BankAccountChangeMoneyResponseDto addMoney(BankAccountAddMoneyRequestDto request){
        deposit = deposit + request.getMoney();
        return BankAccountChangeMoneyResponseDto.builder()
                .id(id)
                .name(name)
                .deposit(deposit)
                .build();
    }

    public long subMoney(long amount) throws Exception{
        if(deposit - amount <0){
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        deposit = deposit - amount;
        return deposit;
    }

    public BankAccountChangeMoneyResponseDto subMoney (BankAccountSubMoneyRequestDto request){
        if(request.getMoney()>deposit){
            throw new IllegalArgumentException();
        }
        deposit = deposit - request.getMoney();
        return BankAccountChangeMoneyResponseDto.builder()
                .id(id)
                .name(name)
                .deposit(deposit)
                .build();
    }

}
