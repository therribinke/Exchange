package com.example.demo.dao.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="exchangesvalues")
@AllArgsConstructor
@NoArgsConstructor
@Table
public class ExchangesValues {

    @Id
    @Column(name="exchangename")
    private String exchangename;
    @Column(name="valuesname1")
    private String valuesname1;
    @Column(name="valuesname2")
    private String valuesname2;
    private Float values1;
    private Float values2;
}
