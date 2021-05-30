package com.carbon.apicarbon.repositories;

import com.carbon.apicarbon.models.ItemType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
    
}
