package com.example.demo.dao.repos;

import com.example.demo.dao.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeValuesRepo extends JpaRepository<ExchangeValue, Long> {
    List<ExchangeValue> findByExchangeIdAndTitleGiveAndTitleReceive
            (Long exchangeName, Long titleGive, Long titleReceive);
}
