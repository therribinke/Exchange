package com.example.demo.dao.repos;

import com.example.demo.dao.model.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalanceRepo extends JpaRepository<UserBalance, Long> {
}
