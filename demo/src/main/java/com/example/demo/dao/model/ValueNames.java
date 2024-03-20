package com.example.demo.dao.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Getter
@Setter
@Accessors(chain = true)
@Entity(name = "valuenames")
@Table(name = "valuenames")
public class ValueNames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false,name = "valuename")
    private String valuename;
}
