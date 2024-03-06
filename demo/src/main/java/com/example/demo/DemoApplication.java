package com.example.demo;



import com.example.demo.dao.model.Exchange;


import com.example.demo.dao.model.ExchangesValues;
import com.example.demo.dao.model.UserBalance;
import com.example.demo.dao.model.ValueNames;
import com.example.demo.service.ExchangeService;
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


	}

}
