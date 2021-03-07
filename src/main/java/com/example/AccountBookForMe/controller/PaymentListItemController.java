package com.example.AccountBookForMe.controller;

import com.example.AccountBookForMe.entity.PaymentListItem;
import com.example.AccountBookForMe.service.PaymentListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paymentlistitem")
public class PaymentListItemController {

    @Autowired
    private PaymentListItemService paymentListItemService;

    @GetMapping("")
    List<PaymentListItem> getPaymentList() {
        return paymentListItemService.getPaymentList();
    }
}
