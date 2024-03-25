package com.example.demo.dao.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Data
@Entity(name = "exchange")
@Table(name = "exchange",schema = "public")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="exchange_name")
    private String exchangename;
    private String description;
}
