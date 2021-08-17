package com.example.AccountBookForMe.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AccountBookForMe.dto.ExpenseDetail;
import com.example.AccountBookForMe.dto.ExpenseListItem;
import com.example.AccountBookForMe.dto.TotalEachFilter;
import com.example.AccountBookForMe.entity.Expense;
import com.example.AccountBookForMe.entity.ExpensePayment;
import com.example.AccountBookForMe.entity.Item;
import com.example.AccountBookForMe.exception.AbfmNotFoundException;
import com.example.AccountBookForMe.repository.ExpensePaymentRepository;
import com.example.AccountBookForMe.repository.ExpenseRepository;
import com.example.AccountBookForMe.repository.ItemRepository;
import com.example.AccountBookForMe.repository.PaymentRepository;
import com.example.AccountBookForMe.repository.StoreRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Autowired
    private ExpensePaymentRepository epRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ItemService itemService;
    
    @Autowired
    private ExpensePaymentService epService;

    /**
     * リスト表示用のデータを全件取得
     * @return リスト表示用のデータ
     */
	public List<ExpenseListItem> findAll() {

		List<ExpenseListItem> expenseList = new ArrayList<>();

		expenseRepository.findAllByOrderByPurchasedAtDesc().forEach(expense -> {

			String storeName = expense.getStoreName() == null
					? storeRepository.findById(expense.getStoreId()).get().getName()
					: expense.getStoreName();
			expenseList.add(new ExpenseListItem(expense.getId(), storeName, expense.getPurchasedAt(),
					calcTotal(expense.getId())));
		});

		return expenseList;
	}

    /**
     * 支出IDをもとに詳細表示用のデータを取得
     * @param id : 支出ID
     * @return 詳細表示用のデータ
     */
    public ExpenseDetail findById(Long id) {
    	
    	Expense expense = expenseRepository.findById(id).orElseThrow(() -> new AbfmNotFoundException("Not found expense id: " + id));

    	ExpenseDetail ed = new ExpenseDetail();
    	
		ed.setId(expense.getId());
		ed.setStoreName(
				expense.getStoreName() == null ? storeRepository.findById(expense.getStoreId()).get().getName()
						: expense.getStoreName());
		ed.setPurchasedAt(expense.getPurchasedAt());
		ed.setStoreId(expense.getStoreId());
		ed.setNote(expense.getNote());
		ed.setItemList(itemService.findByExpenseId(id));
		ed.setPaymentList(epService.findByExpenseId(id));
		
		return ed;
    }

    /**
     * 新規作成
     * @param expenseDetail
     */
    @Transactional
    public void create(ExpenseDetail expenseDetail) {
    	
    	// Expense作成
        Expense expense = new Expense();
        edit(expense, expenseDetail);
		expenseRepository.save(expense);

        // Item作成
        expenseDetail.getItemList().forEach(ili -> {
        	
        	Item item = new Item(ili);
        	item.setExpenseId(expense.getId());
        	itemRepository.save(item);
        });

        // ExpensePayment作成
        expenseDetail.getPaymentList().forEach(pli -> {
        	
        	ExpensePayment ep = new ExpensePayment(pli);
        	ep.setExpenseId(expense.getId());
        	epRepository.save(ep);
        });
    }

    /**
     * 更新
     * @param expenseDetail
     */
    @Transactional
    public void update(ExpenseDetail expenseDetail) {
    	
		// Expense取得
		Expense expense = expenseRepository.findById(expenseDetail.getId())
				.orElseThrow(() -> new AbfmNotFoundException("Not found expense id: " + expenseDetail.getId()));
		edit(expense, expenseDetail);
		expenseRepository.save(expense);
		
		expenseDetail.getItemList().forEach(ili -> {
			
			if (ili.isDeleted()) {
				// isDeletedがtrueなら削除する
				itemRepository.deleteById(ili.getId());

				return;
			}
			
			if (ili.getId() == null) {
				// アイテムIDがなければ新規作成して終わり
				Item item = new Item(ili);
	        	item.setExpenseId(expense.getId());
	        	itemRepository.save(item);

	        	return;
			}
			
			// Item取得
			Item item = itemRepository.findById(ili.getId())
					.orElseThrow(() -> new AbfmNotFoundException("Not found item id: " + ili.getId()));

			// expenseIdが不一致の場合もNot Found扱いにする
			if (item.getExpenseId() != ili.getExpenseId()) {
				throw new AbfmNotFoundException("Not found item id: " + ili.getId());
			}

			item.setName(ili.getName());
			item.setPrice(ili.getPrice());
			item.setCategoryId(ili.getCategoryId());
			itemRepository.save(item);
		});
		
		expenseDetail.getPaymentList().forEach(pli -> {
			
			if (pli.isDeleted()) {
				// isDeletedがtrueなら削除する
				epRepository.deleteById(pli.getId());

				return;
			}
			
			if (pli.getId() == null) {
				// ExpensePaymentIDがなければ新規作成して終わり
	        	ExpensePayment ep = new ExpensePayment(pli);
	        	ep.setExpenseId(expense.getId());
	        	epRepository.save(ep);

	        	return;
			}

			// ExpensePayment取得
			ExpensePayment ep = epRepository.findById(pli.getId())
					.orElseThrow(() -> new AbfmNotFoundException("Not found expensePayment id: " + pli.getId()));

			// expenseIdが不一致の場合もNot Found扱いにする
			if (ep.getExpenseId() != pli.getExpenseId()) {
				throw new AbfmNotFoundException("Not found item id: " + pli.getId());
			}

			ep.setTotal(pli.getTotal());
			ep.setPaymentId(pli.getPaymentId());
			epRepository.save(ep);
		});
    }
    
    /**
     * expenseDetailをもとにexpenseの値を編集する
     * @param expense
     * @param expenseDetail
     */
    private void edit(Expense expense, ExpenseDetail expenseDetail) {

    	expense.setStoreId(expenseDetail.getStoreId());
        // 登録済み店舗を選んでいた場合はstoreNameの値はnullにする
        expense.setStoreName(expenseDetail.getStoreId() != null ? null : expenseDetail.getStoreName());
        expense.setPurchasedAt(expenseDetail.getPurchasedAt());
        expense.setNote(expenseDetail.getNote());
    }

    /**
     * 削除
     * @param id
     */
    @Transactional
    public void delete(Long id) {
    	
    	// Expense削除
    	if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);    		
    	} else {
			throw new AbfmNotFoundException("Not found expense id: " + id);	
    	}
        
        // Item削除
        itemRepository.deleteByExpenseId(id);

        // ExpensePayment削除
        epRepository.deleteByExpenseId(id);
    }

    /**
     * 決済方法IDに紐づいて、リスト表示用のデータを全件取得
     * @param paymentId : 決済方法ID
     * @return リスト表示用のデータ
     */
    public List<ExpenseListItem> findByPaymentId(Long paymentId) {

		List<ExpenseListItem> expenseList = new ArrayList<>();
		
		epRepository.findByPaymentIdOrderByPurchasedAtDesc(paymentId).forEach(ep -> {

			Expense expense = expenseRepository.findById(ep.getExpenseId()).get();
			String storeName = expense.getStoreName() == null
					? storeRepository.findById(expense.getStoreId()).get().getName()
					: expense.getStoreName();

			expenseList.add(new ExpenseListItem(expense.getId(), storeName, expense.getPurchasedAt(), ep.getTotal()));
		});

		return expenseList;
    }

    /**
     * 店舗IDに紐づいて、リスト表示用のデータを全件取得
     * @param storeId : 店舗ID
     * @return リスト表示用のデータ
     */
    public List<ExpenseListItem> findByStoreId(Long storeId) {

		List<ExpenseListItem> expenseList = new ArrayList<>();
		
		expenseRepository.findByStoreIdOrderByPurchasedAtDesc(storeId).forEach(expense -> {

			String storeName = expense.getStoreName() == null
					? storeRepository.findById(expense.getStoreId()).get().getName()
					: expense.getStoreName();

			expenseList.add(new ExpenseListItem(expense.getId(), storeName, expense.getPurchasedAt(),
					calcTotal(expense.getId())));
		});

		return expenseList;
    }

    /**
     * 決済方法ごとの合計金額を返す
     * @return リスト表示用のデータ
     */
    public List<TotalEachFilter> getTotalEachPayment() {
    	
    	// 返却用のリスト生成
    	List<TotalEachFilter> totalList = new ArrayList<>();
    	
    	paymentRepository.findAll().forEach(payment -> {
    		
			BigDecimal total = epRepository.findByPaymentIdOrderByPurchasedAtDesc(payment.getId()).stream().map(ep -> ep.getTotal())
					.reduce(BigDecimal.ZERO, BigDecimal::add);
    		totalList.add(new TotalEachFilter(payment.getId(), payment.getName(), total));
    	});
    	
    	return totalList;
    }

    /**
     * 店舗ごとの合計金額を返す
     * @return リスト表示用のデータ
     */
    public List<TotalEachFilter> getTotalEachStore() {
    	
    	// 返却用のリスト生成
    	List<TotalEachFilter> totalList = new ArrayList<>();
    	
    	// 登録済みじゃない店舗の合計金額（storeIdは0Lとしておく）
    	// TODO: 0Lと"その他"は定数化する
		BigDecimal totalOfOthers = expenseRepository.findByNotRegisteredStoresOrderByPurchasedAtDesc().stream()
				.map(expense -> calcTotal(expense.getId())).reduce(BigDecimal.ZERO, BigDecimal::add);
		totalList.add(new TotalEachFilter(0L, "その他", totalOfOthers));
    	
    	
    	// 登録済み店舗ごとの合計金額
    	storeRepository.findAll().forEach(store -> {
    		
			BigDecimal total = expenseRepository.findByStoreId(store.getId()).stream()
					.map(expense -> calcTotal(expense.getId())).reduce(BigDecimal.ZERO, BigDecimal::add);
    		totalList.add(new TotalEachFilter(store.getId(), store.getName(), total));
    	});
    	
    	return totalList;
    }
    
    /**
     * 支出IDをもとに支出額を計算
     * @param id : 支出ID
     * @return 支出額
     */
	private BigDecimal calcTotal(Long id) {
		return epRepository.findByExpenseId(id).stream().map(ep -> ep.getTotal()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}
}
