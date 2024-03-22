package com.example.demo.service;

import com.example.demo.dao.repos.ValueNamesRepo;
import com.example.demo.dao.model.ValueNames;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ValueNamesService {

    private final ValueNamesRepo valueNamesRepo;
    @Transactional
    public List<ValueNames> getValueNames(){
        return valueNamesRepo.findAll();
    }
    @Transactional
    public ValueNames getValueName(Long id){
        return valueNamesRepo.getReferenceById(id);
    }

    @Transactional
    public ValueNames getValueNameByValueName(String valuename){
        List<ValueNames> list = valueNamesRepo.findByValuenameLike(valuename);
        return list.getFirst();
    }

    @Transactional
    public ValueNames saveValueName(ValueNames valueNamesRequest){
        return valueNamesRepo.save(valueNamesRequest);
    }

    @Transactional
    public ValueNames updateValueName(Long id,ValueNames valueNamesRequest){
        if(valueNamesRepo.existsById(id)){
            valueNamesRequest.setId(id);
            return valueNamesRepo.save(valueNamesRequest);
        }
        throw new EntityNotFoundException("ValueNames with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteValueNames (Long id){
        valueNamesRepo.deleteById(id);
    }
}
