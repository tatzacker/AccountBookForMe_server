package com.example.AccountBookForMe.repository;

import com.example.AccountBookForMe.entity.ExpensePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensePaymentRepository extends JpaRepository<ExpensePayment, Long> {

    List<ExpensePayment> findByExpenseId(Long expenseId);
    
    @Query(value = "SELECT ep.* FROM expense_payments ep"
    		+ "	LEFT JOIN expenses"
    		+ "	ON ep.expense_id = expenses.id"
    		+ "	WHERE payment_id = :paymentId"
    		+ "	ORDER BY expenses.purchased_at DESC", nativeQuery = true)
    List<ExpensePayment> findByPaymentIdOrderByPurchasedAtDesc(@Param("paymentId") Long paymentId);
    
    void deleteByExpenseId(Long expenseId);
    
    void deleteByPaymentId(Long paymentId);
    
}
