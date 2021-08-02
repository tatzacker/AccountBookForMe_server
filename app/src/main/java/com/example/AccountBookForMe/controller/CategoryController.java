package com.example.AccountBookForMe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AccountBookForMe.dto.Filter;
import com.example.AccountBookForMe.exception.AbfmNotFoundException;
import com.example.AccountBookForMe.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

    /**
     * リスト表示用のデータを全件取得
     * @return リスト表示用のデータ
     */
    @GetMapping("")
    List<Filter> findAll() {
        return categoryService.findAll();
    }
    
    /**
     * 新規作成
     * @param name : カテゴリ名
     */
    @PutMapping("/create")
    void create(@RequestBody String name) {
    	categoryService.create(name);
    }
    
    /**
     * 更新
     * @param filter : カテゴリID、カテゴリ名
     */
    @PutMapping("/update")
    void update(@RequestBody Filter filter) {
    	
    	try {
    		categoryService.update(filter);
		} catch (AbfmNotFoundException e) {
			throw e;
		}
    }

    /**
     * 削除
     * @param id : カテゴリID
     */
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
    	
    	try {
    		categoryService.delete(id);
		} catch (AbfmNotFoundException e) {
			throw e;
		}
    }
}
