package com.example.AccountBookForMe.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name", length = 30)
    String name = "";

    // TODO: 以下今後実装予定
    @Column(name = "color_id")
    Long colorId = null;

    @Column(name = "icon_id")
    Long iconId = null;

}
