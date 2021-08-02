package com.example.AccountBookForMe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Data
@MappedSuperclass
public class AbfmEntity {

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
    	LocalDateTime now = LocalDateTime.now();
    	setCreatedAt(now);
    	setUpdatedAt(now);
    }
    
    @PreUpdate
    private void onUpdate() {
    	setUpdatedAt(LocalDateTime.now());
    }

}
