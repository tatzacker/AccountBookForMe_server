package com.example.AccountBookForMe.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TotalEachFilter extends Filter {

    private BigDecimal total = BigDecimal.ZERO;

    /**
     * コンストラクタ（引数なし）
     */
    public TotalEachFilter() {    	
    }

    /**
     * コンストラクタ
     * @param id
     * @param name
     * @param total
     */
    public TotalEachFilter(Long id, String name, BigDecimal total) {

    	this.setId(id);
    	this.setName(name);
    	this.setTotal(total);
    }

}
