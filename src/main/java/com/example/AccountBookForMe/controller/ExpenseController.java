package com.example.AccountBookForMe.controller;

import com.example.AccountBookForMe.entity.Expense;
import com.example.AccountBookForMe.entity.ExpenseDetail;
import com.example.AccountBookForMe.entity.PaymentListItem;
import com.example.AccountBookForMe.service.ExpensePaymentMethodService;
import com.example.AccountBookForMe.service.ExpenseService;
import com.example.AccountBookForMe.service.StoreService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ExpensePaymentMethodService expensePaymentMethodService;

    @Autowired
    private StoreService storeService;

    @GetMapping("")
    List<Expense> findAll() {
        return expenseService.findAll();
    }

    @GetMapping("/{id}")
    ExpenseDetail findById(@PathVariable Long id) {

        ExpenseDetail expenseDetail = new ExpenseDetail();
        try {
            Expense expense = expenseService.findById(id);

            if (expense.getStoreName() == null) {
                // 店舗をリストから選択していた場合、storeIdから名前を取得してセットする
                expense.setStoreName(storeService.getNameById(expense.getStoreId()));
            }

            List<PaymentListItem> paymentList = expensePaymentMethodService.getByExpenseId(id);

            expenseDetail.setExpense(expense);
            expenseDetail.setPaymentMethods(paymentList);

        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return expenseDetail;
    }

    /**
     * 支出の新規作成
     * @param expenseDetail
     * @return
     */
    @PostMapping("")
    Expense save(@RequestBody ExpenseDetail expenseDetail) {

        Expense e = expenseService.save(expenseDetail.getExpense());

        // 関連するexpenses_payment_methodsも新規作成する
        expensePaymentMethodService.create(expenseDetail);

        return e;
    }

    /**
     * 支出の更新
     * @param id
     * @param expenseDetail
     * @return
     */
    @PutMapping("/{id}")
    Expense update(@PathVariable Long id, @RequestBody ExpenseDetail expenseDetail) {

        Expense expense = expenseDetail.getExpense();
        expense.setId(id);
        Expense e = expenseService.update(expense);

        // 関連するexpenses_payment_methodsも更新する
        expensePaymentMethodService.update(expenseDetail);

        return e;
    }

    /**
     * 支出の削除
     * @param id
     */
    @DeleteMapping("/{id}")
    Long delete(@PathVariable Long id) {

        expenseService.delete(id);

        // 関連するexpenses_payment_methodsも削除する
        expensePaymentMethodService.delete(id);

        return id;
    }
}
