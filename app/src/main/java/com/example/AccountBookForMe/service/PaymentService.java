package com.example.AccountBookForMe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AccountBookForMe.dto.Filter;
import com.example.AccountBookForMe.entity.Payment;
import com.example.AccountBookForMe.exception.AbfmNotFoundException;
import com.example.AccountBookForMe.repository.ExpensePaymentRepository;
import com.example.AccountBookForMe.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ExpensePaymentRepository epRepository;

    /**
     * リスト表示用のデータを全件取得
     * @return リスト表示用のデータ
     */
    public List<Filter> findAll() {
    	
    	List<Filter> paymentList = new ArrayList<>();
    	
    	paymentRepository.findAll().forEach(payment -> {
    		paymentList.add(new Filter(payment.getId(), payment.getName()));
    	});

    	return paymentList;
    }
    
    /**
     * 新規作成
     * @param name : 決済方法名
     */
    public void create(String name) {
    	paymentRepository.save(new Payment(name));
    }
    
    /**
     * 更新
     * @param filter : 決済方法ID、決済方法名
     */
    @Transactional
    public void update(Filter filter) {
    	
		Payment payment = paymentRepository.findById(filter.getId())
				.orElseThrow(() -> new AbfmNotFoundException("Not found payment id: " + filter.getId()));
		
		payment.setName(filter.getName());
		paymentRepository.save(payment);
    }
    
    /**
     * 削除
     * @param id : 決済方法ID
     */
    @Transactional
    public void delete(Long id) {
    	
    	if (paymentRepository.existsById(id)) {
    		paymentRepository.deleteById(id);

    		// 関連するExpensePaymentも消す
    		epRepository.deleteByPaymentId(id);

    	} else {
			throw new AbfmNotFoundException("Not found payment id: " + id);
    	}
    }
}
