package com.example.AccountBookForMe.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExpenseListItem {

    private Long id;

    private String storeName = null;

    private LocalDateTime purchasedAt = null;

    private BigDecimal total = BigDecimal.ZERO;
    
    /**
     * コンストラクタ（引数なし）
     */
    public ExpenseListItem() {    	
    }
    
    /**
     * コンストラクタ
     * @param expense
     */
    public ExpenseListItem(Long id, String storeName, LocalDateTime purchasedAt, BigDecimal total) {

    	this.setId(id);
		this.setStoreName(storeName);
		this.setPurchasedAt(purchasedAt);
		this.setTotal(total);
    }

}
