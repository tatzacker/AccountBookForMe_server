package com.example.AccountBookForMe.controller;

import com.example.AccountBookForMe.entity.ExpenseListItem;
import com.example.AccountBookForMe.service.ExpenseListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expenselist")
public class ExpenseListItemController {

    @Autowired
    private ExpenseListItemService expenseListItemService;

    @GetMapping("")
    List<ExpenseListItem> getExpenseList() {
        return expenseListItemService.getExpenseList();
    }

}
