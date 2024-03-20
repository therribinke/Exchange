package com.example.demo.dao.repos;

import com.example.demo.dao.model.ValueNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface ValueNamesRepo extends JpaRepository<ValueNames, Long> {
    List<ValueNames> findByValuenameLike(String valuename);
}
