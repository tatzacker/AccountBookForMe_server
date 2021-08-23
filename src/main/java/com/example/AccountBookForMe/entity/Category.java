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
@Table(name = "categories")
public class Category extends AbfmEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 50)
    private String name = "";

    /**
     * コンストラクタ（引数なし）
     */
    public Category() {    	
    }

    /**
     * コンストラクタ
     * @param name
     */
    public Category(String name) {
    	this.setName(name);
    }
}
