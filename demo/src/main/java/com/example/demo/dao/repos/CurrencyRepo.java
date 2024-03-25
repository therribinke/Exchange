package com.example.demo.dao.repos;

import com.example.demo.dao.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {
    List<Currency> findByTitleLike(String title);
}
