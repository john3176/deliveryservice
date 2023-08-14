package com.spring.designpattern.controller;

import com.spring.designpattern.dto.PayRequestDto;
import com.spring.designpattern.dto.PayResponseDto;
import com.spring.designpattern.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/pay")
    public PayResponseDto pay(PayRequestDto request) throws Exception{
        return paymentService.pay(request);
    }

}
