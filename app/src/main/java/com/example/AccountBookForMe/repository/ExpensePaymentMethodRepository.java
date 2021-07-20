package com.example.AccountBookForMe.repository;

import com.example.AccountBookForMe.entity.ExpensePaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensePaymentMethodRepository extends JpaRepository<ExpensePaymentMethod, Long> {

    List<ExpensePaymentMethod> findByExpenseId(Long expenseId);
}
