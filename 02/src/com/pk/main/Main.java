package com.pk.main;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.pk.entities.InsurenceCode;
import com.pk.entities.Person;

public class Main {
	public static void main(String...strings) {
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(InsurenceCode.class);
		Session session = configuration.buildSessionFactory(serviceRegistry).openSession();
		try {
		
		InsurenceCode ic = new InsurenceCode();
		ic.setInsurenceCode("123456789");
		Person person = new Person();
		person.setName("Chuck");
		person.setIc(ic);
		
		
			session.beginTransaction();
			session.persist(person);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
 		
	}
}
