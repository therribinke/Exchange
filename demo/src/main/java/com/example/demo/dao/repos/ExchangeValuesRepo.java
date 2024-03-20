package com.example.demo.dao.repos;

import com.example.demo.dao.model.ExchangesValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValuesRepo extends JpaRepository<ExchangesValues,Long> {
}
