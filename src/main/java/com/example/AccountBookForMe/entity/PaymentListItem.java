package com.example.AccountBookForMe.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 支出詳細画面で支払方法を選択するときに表示するリスト用
 */
@Data
@Entity
public class PaymentListItem {

    @Id
    Long id;

    String name;

    Float subTotal = 0F;

}
