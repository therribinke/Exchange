package com.example.demo.dao;

import com.example.demo.dao.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepo extends JpaRepository<Exchange,Integer> {

}
