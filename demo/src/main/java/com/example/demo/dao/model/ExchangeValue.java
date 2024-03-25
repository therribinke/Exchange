package com.example.demo.dao.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@Entity(name="exchangesvalue")
@Table(name = "exchange_value")
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long exchangeId;
    private Long titleGive;
    private Long titleReceive;
    private Float valueGive;
    private Float valueReceive;
}
