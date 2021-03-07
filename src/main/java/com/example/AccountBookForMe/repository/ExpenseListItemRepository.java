package com.example.AccountBookForMe.repository;

import com.example.AccountBookForMe.entity.ExpenseListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseListItemRepository extends JpaRepository<ExpenseListItem, Long> {

    @Query(value = "SELECT e.id AS expense_id, '' AS purchased_at, e.purchased_at AS full_purchased_at, " +
            "e.total_amount AS price, pm.name AS method, " +
            "CASE WHEN e.store_id IS NULL THEN e.store_name ELSE s.name END AS store " +
            "FROM expenses e LEFT OUTER JOIN stores s ON e.store_id = s.id " +
            "INNER JOIN expenses_payment_methods epm ON e.id = epm.expense_id " +
            "INNER JOIN payment_methods pm ON epm.payment_method_id = pm.id ORDER BY e.purchased_at;", nativeQuery = true)
    List<ExpenseListItem> getExpenseList();

}
