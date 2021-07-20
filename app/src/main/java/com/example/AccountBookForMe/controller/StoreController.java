package com.example.AccountBookForMe.controller;

import com.example.AccountBookForMe.entity.Store;
import com.example.AccountBookForMe.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("")
    List<Store> findAll() {
        return storeService.findAll();
    }

}
