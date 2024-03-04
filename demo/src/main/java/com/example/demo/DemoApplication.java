package com.example.demo;



import com.example.demo.dao.model.User;



import com.example.demo.dao.model.User;
import com.example.demo.service.UserService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		UserService userService = new UserService();
		System.out.println(userService.checkSameLogin("0"));
	}

}
