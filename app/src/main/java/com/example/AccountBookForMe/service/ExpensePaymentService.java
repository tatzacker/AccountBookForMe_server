package com.example.AccountBookForMe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AccountBookForMe.dto.PaymentListItem;
import com.example.AccountBookForMe.repository.ExpensePaymentRepository;

@Service
public class ExpensePaymentService {

    @Autowired
    private ExpensePaymentRepository epRepository;

    /**
     * 支出IDをもとに決済内容を取得
     * @param expenseId
     * @return 決済内容
     */
    public List<PaymentListItem> findByExpenseId(Long expenseId) {
    	
    	List<PaymentListItem> paymentList = new ArrayList<>();
    	
    	epRepository.findByExpenseId(expenseId).forEach(ep -> {
    		paymentList.add(new PaymentListItem(ep));
    	});
    	
    	return paymentList;
    }    
}
