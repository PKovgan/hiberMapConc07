package com.pk.main;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.pk.entities.Child;
import com.pk.entities.CompositeKey;
import com.pk.entities.Parent;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		configuration.addAnnotatedClass(Parent.class);
		configuration.addAnnotatedClass(Child.class);
		Session session = configuration.buildSessionFactory(serviceRegistry).openSession();
		
		CompositeKey ck = new CompositeKey("Tom", "Kruz");
		Parent parent = new Parent(ck);
		
		Child ch1 = new Child();
		ch1.setName("Albert");
		Child ch2 = new Child();
		ch2.setName("Gregory");
		
		parent.addChild(ch1);
		parent.addChild(ch2);
			
		try {
		
			session.beginTransaction();
			
			session.persist(parent);

			session.getTransaction().commit();
			
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
	}

}
