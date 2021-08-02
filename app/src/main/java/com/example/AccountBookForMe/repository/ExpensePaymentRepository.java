package com.example.AccountBookForMe.repository;

import com.example.AccountBookForMe.entity.ExpensePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensePaymentRepository extends JpaRepository<ExpensePayment, Long> {

    List<ExpensePayment> findByExpenseId(Long expenseId);
    
    List<ExpensePayment> findByPaymentId(Long paymentId);
    
    void deleteByExpenseId(Long expenseId);
    
    void deleteByPaymentId(Long paymentId);
    
}
