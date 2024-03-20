package com.example.demo.dao.repos;

import com.example.demo.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
