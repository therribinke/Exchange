package com.example.demo.controller;

import com.example.demo.Converter.ExchangeConverter;
import com.example.demo.dao.model.Exchange;
import com.example.demo.dto.ExchangeRequest;
import com.example.demo.dto.ExchangeResponse;
import com.example.demo.service.ExchangeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public List<ExchangeResponse> getAllExchanges(){
        return ExchangeConverter.exchangeCollectionConvertToList(exchangeService.getExchanges());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ExchangeResponse addExchange(@RequestBody ExchangeRequest exchangeRequest){
        Exchange addExchange = exchangeService.saveExchange
                (ExchangeConverter.exchangeRequestConvertToExchange(exchangeRequest));
        return ExchangeConverter.exchangeConvertToExchangeResponse(addExchange);
    }

    @PutMapping(value = "/{id}",consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public ExchangeResponse updateExchange(@PathVariable Integer id,@RequestBody ExchangeRequest exchangeRequest){
        Exchange updateExchange = exchangeService.updateExchange
                (id,ExchangeConverter.exchangeRequestConvertToExchange(exchangeRequest));
        return ExchangeConverter.exchangeConvertToExchangeResponse(updateExchange);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public void deleteExchange(@PathVariable Integer id){
        exchangeService.deleteExchange(id);
    }
}
