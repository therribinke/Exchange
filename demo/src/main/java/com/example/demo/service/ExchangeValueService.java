package com.example.demo.service;

import com.example.demo.dao.model.ExchangeValue;
import com.example.demo.dao.repos.ExchangeValuesRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeValueService {
    private final ExchangeValuesRepo exchangeValuesRepo;

    @Transactional
    public List<ExchangeValue> getAllExchangeValues() {
        return exchangeValuesRepo.findAll();
    }

    @Transactional
    public ExchangeValue getExchangeValue(Long id) {
        return exchangeValuesRepo.getReferenceById(id);
    }

    @Transactional
    public ExchangeValue getExchangeValueByValueNames(Long string, Long name1, Long name2) {
        List<ExchangeValue> list = exchangeValuesRepo.findByExchangeIdAndTitleGiveAndTitleReceive
                (string,name1, name2);
        return list.getFirst();
    }

    @Transactional
    public ExchangeValue saveExchangeValue(ExchangeValue exchangeValueRequest) {
        return exchangeValuesRepo.save(exchangeValueRequest);
    }

    @Transactional
    public ExchangeValue updateExchangeValue(Long id, ExchangeValue exchangeValueRequest) {
        if (exchangeValuesRepo.existsById(id)) {
            exchangeValueRequest.setId(id);
            return exchangeValuesRepo.save(exchangeValueRequest);
        }
        throw new EntityNotFoundException("ExchangeValue with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteExchangeValue(Long id) {
        exchangeValuesRepo.deleteById(id);
    }
}
