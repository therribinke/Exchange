package com.example.demo.dao.model;

import com.example.demo.HibernateSession;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Exchange {

    @Id
    @Column(name="exchangename")
    private String exchangename;
    private String description;
}
