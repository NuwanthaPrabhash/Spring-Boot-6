package com.nuwantha.springboot.securityConfigurations.repository;

import com.nuwantha.springboot.securityConfigurations.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
