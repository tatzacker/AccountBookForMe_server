package com.example.AccountBookForMe.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Expenses画面でリスト表示する用
 */
@Data
@Entity
public class ExpenseListItem {

    @Id
    Long expenseId;

    // 購入日と曜日のみ
    String purchasedAt = "";

    // 詳しい購入日（年月日）
    LocalDate fullPurchasedAt = null;

    Float price = 0F;

    String method;

    String store = "";

}
