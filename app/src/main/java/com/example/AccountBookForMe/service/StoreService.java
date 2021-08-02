package com.example.AccountBookForMe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AccountBookForMe.dto.Filter;
import com.example.AccountBookForMe.entity.Store;
import com.example.AccountBookForMe.exception.AbfmNotFoundException;
import com.example.AccountBookForMe.repository.ExpenseRepository;
import com.example.AccountBookForMe.repository.StoreRepository;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Autowired
    private ExpenseService expenseService;

    /**
     * リスト表示用のデータを全件取得
     * @return リスト表示用のデータ
     */
    public List<Filter> findAll() {
    	
    	List<Filter> storeList = new ArrayList<>();
    	
    	storeRepository.findAll().forEach(store -> {
    		storeList.add(new Filter(store.getId(), store.getName()));
    	});

    	return storeList;
    }
    
    /**
     * 新規作成
     * @param name : 店舗名
     */
    public void create(String name) {
    	storeRepository.save(new Store(name));
    }
    
    /**
     * 更新
     * @param filter : 店舗ID、店舗名
     */
    @Transactional
    public void update(Filter filter) {
    	
		Store store = storeRepository.findById(filter.getId())
				.orElseThrow(() -> new AbfmNotFoundException("Not found store id: " + filter.getId()));
		
		store.setName(filter.getName());
		storeRepository.save(store);
    }
    
    /**
     * 削除
     * @param id : 店舗ID
     */
    @Transactional
    public void delete(Long id) {
    	
    	if (storeRepository.existsById(id)) {
    		storeRepository.deleteById(id);

    		// 関連するExpenseも消す
    		expenseRepository.findByStoreId(id).forEach(expense -> {
    			expenseService.delete(expense.getId());
    		});

    	} else {
			throw new AbfmNotFoundException("Not found store id: " + id);
    	}
    }
}
