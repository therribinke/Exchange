package com.example.demo.dao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity(name="user")
@Table(name="user_data",schema = "public")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    private List<Long> balance;
}

