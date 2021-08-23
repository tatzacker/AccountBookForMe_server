package com.example.AccountBookForMe.dto;

import java.math.BigDecimal;

import com.example.AccountBookForMe.entity.Item;

import lombok.Data;

@Data
public class ItemListItem {

    private Long id;

    private String name = "";

    private BigDecimal price = BigDecimal.ZERO;

    private Long expenseId = null;

    private Long categoryId = null;
    
    private boolean isDeleted = false;

    /**
     * コンストラクタ（引数なし）
     */
    public ItemListItem() {
    }
    
    /**
     * コンストラクタ
     * @param item
     */
    public ItemListItem(Item item) {
    	
    	this.setId(item.getId());
    	this.setName(item.getName());
    	this.setPrice(item.getPrice());
    	this.setExpenseId(item.getExpenseId());
    	this.setCategoryId(item.getCategoryId());
    }
}
