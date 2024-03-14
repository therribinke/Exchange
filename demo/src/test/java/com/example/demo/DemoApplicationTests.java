package com.example.demo;

import com.example.demo.dao.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	private  UserService userService  = new UserService();
	@Test
	void contextLoads() {
		/*ExchangeService exchangeService = new ExchangeService();
		SessionFactory sessionFactory = HibernateSession.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<ValueNames> queryrub = session.createQuery("FROM valuenames WHERE valuename=:valuename", ValueNames.class);
		Query<ValueNames> queryusd = session.createQuery("FROM valuenames WHERE valuename=:valuename", ValueNames.class);
		Query<ValueNames> queryaed = session.createQuery("FROM valuenames WHERE valuename=:valuename", ValueNames.class);
		Query<ValueNames> querycny = session.createQuery("FROM valuenames WHERE valuename=:valuename", ValueNames.class);
		String s = "Рубль";
		String s1 = "USD";
		String s2 = "AED";
		String s3 = "CNY";
		queryrub.setParameter("valuename",s);
		ValueNames valueNamesrub = queryrub.getSingleResult();
		queryusd.setParameter("valuename",s1);
		ValueNames valueNamesusd = queryusd.getSingleResult();
		queryaed.setParameter("valuename",s2);
		ValueNames valueNamesaed = queryaed.getSingleResult();
		querycny.setParameter("valuename",s3);
		ValueNames valueNamescny = querycny.getSingleResult();
		ExchangesValues exchangesValues = ExchangesValues.builder()
				.exchangename("Сбербанк")
				.valuename1(valueNamesrub)
				.valuename2(valueNamesusd)
				.value1(91.80F)
				.value2(1F)
				.build();

		exchangeService.saveExchangeCourse(exchangesValues);
		exchangesValues = ExchangesValues.builder()
				.exchangename("Сбербанк")
				.valuename1(valueNamesusd)
				.valuename2(valueNamesrub)
				.value1(1F)
				.value2(89F)
				.build();
		exchangeService.saveExchangeCourse(exchangesValues);
		exchangesValues = ExchangesValues.builder()
				.exchangename("Сбербанк")
				.valuename1(valueNamesrub)
				.valuename2(valueNamescny)
				.value1(12.58F)
				.value2(1F)
				.build();
		exchangeService.saveExchangeCourse(exchangesValues);
		exchangesValues = ExchangesValues.builder()
				.exchangename("Сбербанк")
				.valuename1(valueNamescny)
				.valuename2(valueNamesrub)
				.value1(1F)
				.value2(12.41F)
				.build();
		exchangeService.saveExchangeCourse(exchangesValues);
		exchangesValues = ExchangesValues.builder()
				.exchangename("Сбербанк")
				.valuename1(valueNamesrub)
				.valuename2(valueNamesaed)
				.value1(25.37F)
				.value2(1F)
				.build();
		exchangeService.saveExchangeCourse(exchangesValues);
		exchangesValues = ExchangesValues.builder()
				.exchangename("Сбербанк")
				.valuename1(valueNamesaed)
				.valuename2(valueNamesrub)
				.value1(1F)
				.value2(24.45F)
				.build();
		exchangeService.saveExchangeCourse(exchangesValues);*/
		/*ExchangeService exchangeService = new ExchangeService();
		List<ExchangesValues> list = exchangeService.getAllCourses();
		for (ExchangesValues list1 :list){
			System.out.println(list1);
		}*/
		/*ExchangeService exchangeService;*/


		/*User user= User.builder()
				.login("123")
				.password("123")
				.email("123")
				.build();
		System.out.println(user);
		userService.saveUser(user);*/

	}

	/*@Test
	void testinffff(){
		SessionFactory sessionFactory = HibernateSession.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		*//*Query <ValueNames> query = session.createQuery("FROM valuenames WHERE valuename =:valuename",ValueNames.class);
		String s="Рубль";
		query.setParameter("valuename",s);*//*
		*//*ValueNames valueNames = query.getSingleResult();
		System.out.println(valueNames);*//*

		*//*UserBalance userBalance = UserBalance.builder()
				.login("12223")
				.valuename(query.getSingleResult())
				.build();*//*
		ValueNames valueNames = ValueNames.builder()
				.valuename("AED")
				.build();
		session.save(valueNames);
		 valueNames = ValueNames.builder()
				.valuename("USD")
				.build();
		session.save(valueNames);
		 valueNames = ValueNames.builder()
				.valuename("CNY")
				.build();
		session.save(valueNames);
		session.getTransaction().commit();
	}*/

}
