package com.example.AccountBookForMe.service;

import com.example.AccountBookForMe.entity.Expense;
import com.example.AccountBookForMe.repository.ExpenseRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(Long id) throws NotFoundException {
        return expenseRepository.findById(id).orElseThrow(() -> new NotFoundException("Expense"));
    };

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense update(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
}
