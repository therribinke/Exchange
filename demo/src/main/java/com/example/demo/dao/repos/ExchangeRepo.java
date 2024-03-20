package com.example.demo.dao.repos;

import com.example.demo.dao.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepo extends JpaRepository<Exchange,Long> {

}
