package com.example.AccountBookForMe.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.AccountBookForMe.dto.ItemListItem;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "items")
public class Item extends AbfmEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 50)
    private String name = "";

    @Column(name = "price")
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "expense_id")
    private Long expenseId = null;

    @Column(name = "category_id")
    private Long categoryId = null;

    /**
     * コンストラクタ（引数なし）
     */
    public Item() {    	
    }

    /**
     * コンストラクタ
     * @param ili : ItemListItem
     */
    public Item(ItemListItem ili) {
    	
    	this.setName(ili.getName());
    	this.setPrice(ili.getPrice());
    	this.setExpenseId(ili.getExpenseId());
    	this.setCategoryId(ili.getCategoryId());
    }

}
