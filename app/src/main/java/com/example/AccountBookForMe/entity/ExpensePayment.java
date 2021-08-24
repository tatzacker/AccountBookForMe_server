package com.example.AccountBookForMe.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.AccountBookForMe.dto.PaymentListItem;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "expense_payments")
public class ExpensePayment extends AbfmEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "expense_id")
    private Long expenseId = null;

    @Column(name = "payment_id")
    private Long paymentId = null;

    @Column(name = "total")
    private BigDecimal total = BigDecimal.ZERO;

    /**
     * コンストラクタ（引数なし）
     */
    public ExpensePayment() {    	
    }

    /**
     * コンストラクタ
     * @param pli
     */
    public ExpensePayment(PaymentListItem pli) {
    	
    	this.setTotal(pli.getTotal());
    	this.setExpenseId(pli.getExpenseId());
    	this.setPaymentId(pli.getPaymentId());
    }
}
