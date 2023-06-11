package com.pk.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.pk.entities.Address;
import com.pk.entities.Person;

public class Main {
	
	public static void main(String ... args) {
		
		final Logger logger = LogManager.getLogger(Main.class);
		
		Address address = new Address("Khreschatyck", "Kyiv", "001026");
		Person person = new Person("Valeriy", address);
		logger.debug("Some logger info");
	
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(Person.class);
		Session session = configuration.buildSessionFactory(serviceRegistry).openSession();
		
		
//		try {
//			session.beginTransaction();
//			session.persist(person);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			if (session.getTransaction() != null) session.getTransaction().rollback();
//		} finally {
//			if (session != null) session.close();
//		}
		
		
//		session = configuration.buildSessionFactory(serviceRegistry).openSession();
//		try {
//			Query query = session.createQuery("select person from Person as person");
////			Query query = session.createQuery("truncate table person");
//			List<Person> persons = query.getResultList();
//			for (Person per : persons)  {
//				System.out.println(per);
//				if (per.getId() == 3) {
//					Address addr = per.getAddress();
//					System.out.println(addr);
//				}
//			}			
//		} catch (Exception e) {
//		} finally {
//			if (session != null) session.close();
//		}
		
		try {
			Query query = session.createQuery("select person.id, person.name from Person as person");
			List<Object[]> resultList = query.getResultList();
			for (Object[] objects : resultList) {
				System.out.println("Object[] {objects[0]: " + objects[0] + ",objects[1]: " + objects[1] + "}");
			}
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
	}
}
