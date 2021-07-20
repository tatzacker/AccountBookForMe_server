package com.example.AccountBookForMe.service;

import com.example.AccountBookForMe.entity.ExpenseDetail;
import com.example.AccountBookForMe.entity.ExpensePaymentMethod;
import com.example.AccountBookForMe.entity.PaymentListItem;
import com.example.AccountBookForMe.repository.ExpensePaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpensePaymentMethodService {

    @Autowired
    private ExpensePaymentMethodRepository epmRepository;
    
    @Autowired
    private PaymentMethodService pmService;

    /**
     * 支出IDからその支出に紐付いた支払方法ID、名称と小計のリストを返す
     * @param expenseId
     * @return
     */
    public List<PaymentListItem> getByExpenseId(Long expenseId) {

        List<PaymentListItem> paymentList = new ArrayList<PaymentListItem>();
        PaymentListItem paymentListItem = new PaymentListItem();

        List<ExpensePaymentMethod> expensePaymentMethods = epmRepository.findByExpenseId(expenseId);
        expensePaymentMethods.forEach(epm -> {

            paymentListItem.setId(epm.getPaymentMethodId());
            paymentListItem.setName(pmService.getNameById(epm.getPaymentMethodId()).orElse(""));
            paymentListItem.setSubTotal(epm.getSubTotal());

            paymentList.add(paymentListItem);
        });

        return paymentList;
    }

    /**
     * 支出を作成するときに同時に作成する
     * @param expenseDetail: 支出詳細と支払方法IDのリストのセット
     */
    public void create(ExpenseDetail expenseDetail) {

        ExpensePaymentMethod epm = new ExpensePaymentMethod();

        expenseDetail.getPaymentMethods().forEach(pm -> {

            epm.setExpenseId(expenseDetail.getExpense().getId());
            epm.setPaymentMethodId(pm.getId());
            epm.setSubTotal(pm.getSubTotal());

            epmRepository.save(epm);
        });
    }

    /**
     * 支出を更新するときに同時に更新する
     * @param expenseDetail: 支出詳細と支払方法IDのリストのセット
     */
    public void update(ExpenseDetail expenseDetail) {

        // 該当の支出に紐付いた既存のレコードを削除する
        delete(expenseDetail.getExpense().getId());

        // あらためて新規作成する
        create(expenseDetail);
    }

    /**
     * 支出を削除するときに同時に削除する
     * @param expenseId: 支出詳細ID
     */
    public void delete(Long expenseId) {

        List<ExpensePaymentMethod> listToDelete = epmRepository.findByExpenseId(expenseId);
        listToDelete.forEach(item -> epmRepository.delete(item));
    }
}
