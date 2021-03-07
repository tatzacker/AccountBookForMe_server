package com.example.AccountBookForMe.service;

import com.example.AccountBookForMe.entity.PaymentMethod;
import com.example.AccountBookForMe.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    public Optional<String> getNameById(Long id) {
        return paymentMethodRepository.findById(id).map(PaymentMethod::getName);
    }
}
