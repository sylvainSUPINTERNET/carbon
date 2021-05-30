package com.carbon.apicarbon.repositories;

import com.carbon.apicarbon.models.Effect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectRepository extends JpaRepository<Effect, Long> {
    
}

