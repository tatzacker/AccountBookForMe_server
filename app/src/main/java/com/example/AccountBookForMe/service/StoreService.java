package com.example.AccountBookForMe.service;

import com.example.AccountBookForMe.entity.Store;
import com.example.AccountBookForMe.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    /**
     * idをキーにして名前を返す
     * @param id
     * @return
     */
    public String getNameById(Long id) {

        Store store = storeRepository.findById(id).orElse(null);

        // もし見つからなかったら空文字を返す
        return store == null ? "" : store.getName();
    }
}
