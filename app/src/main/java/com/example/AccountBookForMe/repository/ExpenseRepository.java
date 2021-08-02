package com.example.AccountBookForMe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.AccountBookForMe.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	List<Expense> findByStoreId(Long storeId);
	
	@Query(value = "SELECT * FROM expenses WHERE store_id IS NULL", nativeQuery = true)
	List<Expense> findByNotRegisteredStores();
}
