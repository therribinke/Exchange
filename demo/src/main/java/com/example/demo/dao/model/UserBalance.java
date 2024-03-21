package com.example.demo.dao.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity(name = "userbalance")
@Table(name="userbalance",schema = "public")
public class UserBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long valuename;
    private Float value;

}
