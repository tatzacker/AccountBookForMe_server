package com.example.AccountBookForMe.controller;

import com.example.AccountBookForMe.entity.PaymentMethod;
import com.example.AccountBookForMe.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paymentmethods")
public class PaymentMethodController {

    @Autowired
    PaymentMethodService paymentMethodService;

    @GetMapping("")
    List<PaymentMethod> findAll() {
        return paymentMethodService.findAll();
    }
}
