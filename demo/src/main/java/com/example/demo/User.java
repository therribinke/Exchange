package com.example.demo;


import jakarta.persistence.*;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="userss")
@Table(name="userss",schema = "public")
public class User {
    @Id
    private String login;
    private String password;
    private String email;
}

