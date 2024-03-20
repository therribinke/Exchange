package com.example.demo.dao.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@Entity(name="exchangesvalues")
@Table
public class ExchangesValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="exchangename")
    private String exchangename;
    private Long valuename1;
    private Long valuename2;
    private Float value1;
    private Float value2;
}
