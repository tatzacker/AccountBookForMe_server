package com.example.AccountBookForMe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AccountBookForMe.dto.ItemListItem;
import com.example.AccountBookForMe.dto.TotalEachFilter;
import com.example.AccountBookForMe.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
    /**
     * カテゴリIDに基づいて、リスト表示用のデータを全件取得
     * @param id : カテゴリID
     * @return リスト表示用のデータ
     */
    @GetMapping("/category/{id}")
    List<ItemListItem> findByCategoryId(@PathVariable Long id) {
    	return itemService.findByCategoryId(id);
    }
    
    /**
     * カテゴリごとの合計金額を返す
     * @return リスト表示用のデータ
     */
    @GetMapping("/category/totals")
    List<TotalEachFilter> getTotalEachCategory() {
    	return itemService.getTotalEachCategory();
    }

}
