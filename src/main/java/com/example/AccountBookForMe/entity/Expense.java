package com.example.AccountBookForMe.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "total_amount")
    Float totalAmount = 0F;

    @Column(name = "store_id")
    Long storeId = null;

    @Column(name = "store_name")
    String storeName = null;

    @Column(name = "purchased_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate purchasedAt = null;

    @Column(name = "note", length = 140)
    String note = null;

}
