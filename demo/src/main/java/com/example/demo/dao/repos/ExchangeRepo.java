package com.example.demo.dao.repos;

import com.example.demo.dao.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRepo extends JpaRepository<Exchange, Long> {
    List<Exchange> findByExchangenameLike(String string);

}
