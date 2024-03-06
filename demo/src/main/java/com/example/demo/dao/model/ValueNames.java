package com.example.demo.dao.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "valuenames")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "valuenames")
public class ValueNames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,name = "valuename")
    private String valuename;
}
