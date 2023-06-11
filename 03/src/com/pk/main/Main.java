package com.pk.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.pk.entities.Employee;
import com.pk.entities.Manager;


public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		configuration.addAnnotatedClass(Manager.class);
		configuration.addAnnotatedClass(Employee.class);
		Session session = configuration.buildSessionFactory(serviceRegistry).openSession();
		try {
		
//			Manager manager = new Manager();
//			manager.setName("Arcadiy");
//			manager.setManagerId("123456789");
//			manager.setSalary(10000);
			Query query = session.createQuery("select manager from Manager as manager where manager.id=14");
			List <Manager> manager = query.getResultList();
			System.out.println(manager.toString());
			Employee employee = new Employee();
			employee.setName("Chuck");
			employee.setWorkId("234567890");
			employee.setManager(manager.get(0));
//			employee.setManager(manager);
			
			session.beginTransaction();
			session.persist(employee);
			session.remove(employee);
			session.getTransaction().commit();
			
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
	}

}
