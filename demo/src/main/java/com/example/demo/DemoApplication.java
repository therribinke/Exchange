package com.example.demo;


import com.example.demo.dao.model.User;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Configuration configuration = new Configuration();
		configuration.configure();

		try (SessionFactory sessionFactory = configuration.buildSessionFactory();
			 Session session = sessionFactory.openSession()) {
			session.getTransaction().begin();
			User user = User.builder()
					.login("123")
					.login("112312")
					.password("213")
					.email("412")
					.build();

			session.save(user);
			session.getTransaction().commit();
		}
	}

}
