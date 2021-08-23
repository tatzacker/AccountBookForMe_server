package com.example.AccountBookForMe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stores")
public class Store extends AbfmEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 50)
    private String name = "";

    /**
     * コンストラクタ（引数なし）
     */
    public Store() {    	
    }
    
    /**
     * コンストラクタ
     * @param name
     */
    public Store(String name) {
    	this.setName(name);
    }
}
