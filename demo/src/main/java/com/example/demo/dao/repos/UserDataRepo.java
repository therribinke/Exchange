package com.example.demo.dao.repos;

import com.example.demo.dao.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepo extends JpaRepository<UserData,Long> {

}
