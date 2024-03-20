package com.example.demo.dao.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="exchangesvalues")
@AllArgsConstructor
@NoArgsConstructor
@Table
@Builder
public class ExchangesValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="exchangename")
    private String exchangename;
    @ManyToOne
    @JoinColumn(name="valuename1")
    private ValueNames valuename1;
    @ManyToOne
    @JoinColumn(name="valuename2")
    private ValueNames valuename2;
    private Float value1;
    private Float value2;
}
