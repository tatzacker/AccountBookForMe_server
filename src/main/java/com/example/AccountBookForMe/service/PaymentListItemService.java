package com.example.AccountBookForMe.service;

import com.example.AccountBookForMe.entity.PaymentListItem;
import com.example.AccountBookForMe.repository.PaymentListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentListItemService {

    @Autowired
    private PaymentListItemRepository paymentListItemRepository;

    public List<PaymentListItem> getPaymentList() {
        return paymentListItemRepository.getPaymentList();
    }
}
