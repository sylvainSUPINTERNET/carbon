package com.carbon.apicarbon.repositories;

import java.util.Optional;

import com.carbon.apicarbon.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public Optional<Users> findByEmail(String email);
}
