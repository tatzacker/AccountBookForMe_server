package com.example.AccountBookForMe.dto;

import lombok.Data;

@Data
public class Filter {

    private Long id;

    private String name = "";

    /**
     * コンストラクタ（引数なし）
     */
    public Filter() {    	
    }
    
    /**
     * コンストラクタ
     * @param id
     * @param name
     */
    public Filter(Long id, String name) {
    	
    	this.setId(id);
    	this.setName(name);
    }

}
