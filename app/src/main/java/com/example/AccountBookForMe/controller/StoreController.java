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
import com.example.AccountBookForMe.dto.Name;
import com.example.AccountBookForMe.exception.AbfmNotFoundException;
import com.example.AccountBookForMe.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * リスト表示用のデータを全件取得
     * @return リスト表示用のデータ
     */
    @GetMapping("")
    List<Filter> findAll() {
        return storeService.findAll();
    }
    
    /**
     * 新規作成
     * @param name : 店舗名
     * @return リスト表示用のデータ
     */
    @PutMapping("/create")
    List<Filter> create(@RequestBody Name name) {
    	return storeService.create(name);
    }
    
    /**
     * 更新
     * @param filter : 店舗ID、店舗名
     * @return リスト表示用のデータ
     */
    @PutMapping("/update")
    List<Filter> update(@RequestBody Filter filter) {
    	
    	try {
    		return storeService.update(filter);
		} catch (AbfmNotFoundException e) {
			throw e;
		}
    }

    /**
     * 削除
     * @param id : 店舗ID
     * @return リスト表示用のデータ
     */
    @DeleteMapping("/delete/{id}")
    List<Filter> delete(@PathVariable Long id) {
    	
    	try {
    		return storeService.delete(id);
		} catch (AbfmNotFoundException e) {
			throw e;
		}
    }
}
