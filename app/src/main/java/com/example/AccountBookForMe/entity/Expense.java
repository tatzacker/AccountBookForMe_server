package com.example.AccountBookForMe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "expenses")
public class Expense extends AbfmEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "store_id")
    private Long storeId = null;

    @Column(name = "store_name", length = 50)
    private String storeName = null;

    @Column(name = "purchased_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime purchasedAt = null;

    @Column(name = "note", length = 255)
    private String note = null;
    
}
