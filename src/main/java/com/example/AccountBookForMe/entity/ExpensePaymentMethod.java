package com.example.AccountBookForMe.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "expenses_payment_methods")
public class ExpensePaymentMethod {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "expense_id")
    Long expenseId = null;

    @Column(name = "payment_method_id")
    Long paymentMethodId = null;

    @Column(name = "sub_amount")
    Float subTotal = 0F;

}
