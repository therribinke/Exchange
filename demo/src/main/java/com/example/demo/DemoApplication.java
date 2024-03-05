package com.example.demo;



import com.example.demo.dao.model.Exchange;


import com.example.demo.dao.model.ExchangesValues;
import com.example.demo.service.ExchangeService;
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
		List<ExchangesValues> list = exchangeService.getCourse("Рубль","USD");
		System.out.println(list);*/
	}

}
