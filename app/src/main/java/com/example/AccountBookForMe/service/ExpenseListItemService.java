package com.example.AccountBookForMe.service;

import com.example.AccountBookForMe.entity.ExpenseListItem;
import com.example.AccountBookForMe.repository.ExpenseListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExpenseListItemService {

    @Autowired
    private ExpenseListItemRepository expenseListItemRepository;

    /**
     * Expenses画面に表示する値のセットをリストで返す
     * @return
     */
    public List<ExpenseListItem> getExpenseList() {

        List<ExpenseListItem> list = expenseListItemRepository.getExpenseList();

        list.forEach(item -> {
            // 日付をフォーマット変換して文字列に変換する
            String formattedDate = item.getFullPurchasedAt() == null ? "-" : formatDate(item.getFullPurchasedAt(), "E, d");
            item.setPurchasedAt(formattedDate);
        });

        return list;
    }

    /**
     * 日付をフォーマット変換して返す
     * @param localdate : LocalDate型の日付
     * @param pattern : フォーマッタ
     * @return
     */
    private String formatDate(LocalDate localdate, String pattern) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(localdate);
    }
}
