package com.example.AccountBookForMe.dto;

import java.math.BigDecimal;

import com.example.AccountBookForMe.entity.ExpensePayment;

import lombok.Data;

@Data
public class PaymentListItem {

    private Long id;
    
    private BigDecimal total = BigDecimal.ZERO;

    private Long expenseId = null;
    
    private Long paymentId = null;

    /**
     * コンストラクタ（引数なし）
     */
    public PaymentListItem() {
    }
    
    /**
     * コンストラクタ
     * @param ep
     */
    public PaymentListItem(ExpensePayment ep) {
    	
    	this.setId(ep.getId());
    	this.setTotal(ep.getTotal());
    	this.setExpenseId(ep.getExpenseId());
    	this.setPaymentId(ep.getPaymentId());
    }

}
