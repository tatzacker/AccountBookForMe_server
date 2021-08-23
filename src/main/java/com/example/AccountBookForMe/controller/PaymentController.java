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
import com.example.AccountBookForMe.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

    /**
     * リスト表示用のデータを全件取得
     * @return リスト表示用のデータ
     */
    @GetMapping("")
    List<Filter> findAll() {
        return paymentService.findAll();
    }
    
    /**
     * 新規作成
     * @param name : 決済方法名
     * @return リスト表示用のデータ
     */
    @PutMapping("/create")
    List<Filter> create(@RequestBody Name name) {
    	return paymentService.create(name);
    }
    
    /**
     * 更新
     * @param filter : 決済方法ID、決済方法名
     * @return リスト表示用のデータ
     */
    @PutMapping("/update")
    List<Filter> update(@RequestBody Filter filter) {
    	
    	try {
    		return paymentService.update(filter);
		} catch (AbfmNotFoundException e) {
			throw e;
		}
    }

    /**
     * 削除
     * @param id : 決済方法ID
     * @return リスト表示用のデータ
     */
    @DeleteMapping("/delete/{id}")
    List<Filter> delete(@PathVariable Long id) {
    	
    	try {
    		return paymentService.delete(id);
		} catch (AbfmNotFoundException e) {
			throw e;
		}
    }
}
