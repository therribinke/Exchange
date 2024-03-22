package com.example.demo.dao.repos;

import com.example.demo.dao.model.ExchangesValues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeValuesRepo extends JpaRepository<ExchangesValues,Long> {
    List<ExchangesValues> findByExchangenameLikeAndValuename1AndValuename2
            (String exchangename,Long valuename1,Long valuename2);
}
