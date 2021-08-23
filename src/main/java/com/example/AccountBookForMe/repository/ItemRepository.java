package com.example.AccountBookForMe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AccountBookForMe.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query(value = "SELECT i.* FROM items i"
			+ "	LEFT JOIN expenses"
			+ "	ON i.expense_id = expenses.id"
			+ "	WHERE expense_id = :expenseId"
			+ "	ORDER BY expenses.purchased_at DESC;" , nativeQuery = true)
	List<Item> findByExpenseIdOrderByPurchasedAtDesc(@Param("expenseId") Long expenseId);

	@Query(value = "SELECT i.* FROM items i"
			+ "	LEFT JOIN expenses"
			+ "	ON i.expense_id = expenses.id"
			+ "	WHERE category_id = :categoryId"
			+ "	ORDER BY expenses.purchased_at DESC;" , nativeQuery = true)
    List<Item> findByCategoryIdOrderByPurchasedAtDesc(@Param("categoryId") Long categoryId);
    
    void deleteByExpenseId(Long expenseId);
    
    void deleteByCategoryId(Long categoryId);

}
