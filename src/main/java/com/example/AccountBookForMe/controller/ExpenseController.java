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

import com.example.AccountBookForMe.dto.ExpenseDetail;
import com.example.AccountBookForMe.dto.ExpenseListItem;
import com.example.AccountBookForMe.dto.TotalEachFilter;
import com.example.AccountBookForMe.exception.AbfmNotFoundException;
import com.example.AccountBookForMe.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    /**
     * リスト表示用のデータを全件取得
     * @return リスト表示用のデータ
     */
    @GetMapping("")
    List<ExpenseListItem> findAll() {
        return expenseService.findAll();
    }

    /**
     * 支出IDをもとに詳細表示用のデータを取得
     * @param id : 支出ID
     * @return 詳細表示用のデータ
     */
    @GetMapping("/{id}")
    ExpenseDetail findById(@PathVariable Long id) {

    	try {
            return expenseService.findById(id);    		
    	} catch (AbfmNotFoundException e) {
    		throw e;
    	}
    }

    /**
     * 支出の新規作成
     * @param expenseDetail
     */
    @PutMapping("/create")
    void create(@RequestBody ExpenseDetail expenseDetail) {
    	expenseService.create(expenseDetail);
    }

    /**
     * 支出の更新
     * @param expenseDetail
     */
    @PutMapping("/update")
    void update(@RequestBody ExpenseDetail expenseDetail) {

		try {
			expenseService.update(expenseDetail);
		} catch (AbfmNotFoundException e) {
			throw e;
		}
    }

    /**
     * 支出の削除
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {

    	try {
            expenseService.delete(id);
    	} catch (AbfmNotFoundException e) {
    		throw e;
    	}
    }

    /**
     * 決済方法IDに基づいて、リスト表示用のデータを全件取得
     * @param id : 決済方法ID
     * @return リスト表示用のデータ
     */
    @GetMapping("/payment/{id}")
    List<ExpenseListItem> findByPaymentId(@PathVariable Long id) {
    	return expenseService.findByPaymentId(id);
    }

    /**
     * 店舗IDに基づいて、リスト表示用のデータを全件取得
     * @param id : 店舗ID
     * @return リスト表示用のデータ
     */
    @GetMapping("/store/{id}")
    List<ExpenseListItem> findByStoreId(@PathVariable Long id) {
    	return expenseService.findByStoreId(id);
    }
    
    /**
     * 決済方法ごとの合計金額を返す
     * @return リスト表示用のデータ
     */
    @GetMapping("/payment/totals")
    List<TotalEachFilter> getTotalEachPayment() {
    	return expenseService.getTotalEachPayment();
    }
    
    /**
     * 店舗ごとの合計金額を返す
     * @return リスト表示用のデータ
     */
    @GetMapping("/store/totals")
    List<TotalEachFilter> getTotalEachStore() {
    	return expenseService.getTotalEachStore();
    }
}
