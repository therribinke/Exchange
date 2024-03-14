package com.example.demo;



import com.example.demo.dao.model.*;


import com.example.demo.service.ExchangeService;
import com.example.demo.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*UserService userService = new UserService();
		System.out.println(userService.checkSameLogin("1"));*/
		/*ExchangeService exchangeService = new ExchangeService();
		List<ExchangesValues> list = exchangeService.getAllCourses();
		System.out.println(list);*/
/*		 UserService userService = new UserService();
		User user= User.builder()
				.login("123")
				.password("123")
				.email("123")
				.build();
		System.out.println(user);
		userService.saveUser(user);*/

	}

}
