package com.example.AccountBookForMe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AccountBookForMe.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByExpenseId(Long expenseId);
    
    List<Item> findByCategoryId(Long categoryId);
    
    void deleteByExpenseId(Long expenseId);
    
    void deleteByCategoryId(Long categoryId);

}
