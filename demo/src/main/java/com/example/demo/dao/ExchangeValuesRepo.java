package com.example.demo.dao;

import com.example.demo.dao.model.ExchangesValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValuesRepo extends JpaRepository<ExchangesValues,Integer> {
}
