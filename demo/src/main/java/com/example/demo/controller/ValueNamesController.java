package com.example.demo.controller;

import com.example.demo.Converter.ValueNamesConverter;
import com.example.demo.dao.model.ValueNames;
import com.example.demo.dto.ValueNamesRequest;
import com.example.demo.dto.ValueNamesResponse;
import com.example.demo.service.ValueNamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/valuename")
public class ValueNamesController {
    private final ValueNamesService valueNamesService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ValueNamesResponse> getAllValueNames() {
        return ValueNamesConverter.valueNamesCollictionToList(valueNamesService.getValueNames());
    }
    @GetMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public ValueNamesResponse getValueNames(@PathVariable Long id) {
        return ValueNamesConverter.valueNamesToValueNamesResponse(valueNamesService.getValueName(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ValueNamesResponse addValueName(@RequestBody ValueNamesRequest valueNamesRequest) {
        ValueNames addValueName = valueNamesService.saveValueName
                (ValueNamesConverter.valueNamesRequestToValueNames(valueNamesRequest));
        return ValueNamesConverter.valueNamesToValueNamesResponse(addValueName);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ValueNamesResponse addValueName(@PathVariable Long id, @RequestBody ValueNamesRequest valueNamesRequest) {
        ValueNames updateValueName = valueNamesService.updateValueName
                (id,ValueNamesConverter.valueNamesRequestToValueNames(valueNamesRequest));
        return ValueNamesConverter.valueNamesToValueNamesResponse(updateValueName);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void deleteValueNames(@PathVariable Long id){
        valueNamesService.deleteValueNames(id);
    }
}
