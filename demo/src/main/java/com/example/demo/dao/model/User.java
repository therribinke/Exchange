package com.example.demo.dao.model;

import lombok.*;
import jakarta.persistence.*;
import java.lang.String;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="users")
@Table(name="users",schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
}

