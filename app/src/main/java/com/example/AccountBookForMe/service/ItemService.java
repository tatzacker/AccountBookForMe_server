package com.example.AccountBookForMe.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.AccountBookForMe.dto.ItemListItem;
import com.example.AccountBookForMe.dto.TotalEachFilter;
import com.example.AccountBookForMe.repository.CategoryRepository;
import com.example.AccountBookForMe.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
    /**
     * 支出IDをもとに品物内容を取得
     * @param expenseId
     * @return 品物内容
     */
	public List<ItemListItem> findByExpenseId(Long expenseId) {
		
		List<ItemListItem> itemList = new ArrayList<>();

		itemRepository.findByExpenseIdOrderByPurchasedAtDesc(expenseId).forEach(item -> {
			itemList.add(new ItemListItem(item));
		});
		
		return itemList;
	}
	

    /**
     * カテゴリIDに紐づいて、リスト表示用のデータを全件取得
     * @param categoryId : カテゴリID
     * @return リスト表示用のデータ
     */
    public List<ItemListItem> findByCategoryId(Long categoryId) {

		List<ItemListItem> itemList = new ArrayList<>();
		
		itemRepository.findByCategoryIdOrderByPurchasedAtDesc(categoryId).forEach(item -> {
			itemList.add(new ItemListItem(item));
		});

		return itemList;
    }

    /**
     * カテゴリごとの合計金額を返す
     * @return リスト表示用のデータ
     */
    public List<TotalEachFilter> getTotalEachCategory() {
    	
    	// 返却用のリスト生成
    	List<TotalEachFilter> totalList = new ArrayList<>();
    	
    	categoryRepository.findAll().forEach(category -> {
    		
			BigDecimal total = itemRepository.findByCategoryIdOrderByPurchasedAtDesc(category.getId()).stream()
					.map(item -> item.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    		totalList.add(new TotalEachFilter(category.getId(), category.getName(), total));
    	});
    	
    	return totalList;
    }
}
