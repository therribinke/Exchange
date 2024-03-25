package com.example.demo.dao.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity(name = "userbalance")
@Table(name="user_balance",schema = "public")
public class UserBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long titleId;
    private Float value;

}
