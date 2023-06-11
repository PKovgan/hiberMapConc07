package com.pk.main;

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
		
			Manager manager1 = new Manager("qwerrt", "Alex", 10000);
			Manager manager2 = new Manager("asdffg", "Andrew", 15000);
			
			Employee employee1 = new Employee("123456", "Bredly", manager1);
			Employee employee2 = new Employee("234567", "Bob", manager1);
			
			manager1.getEmployees().add(employee1);
			manager1.getEmployees().add(employee2);
			
			session.beginTransaction();
			session.persist(manager1);
			session.persist(manager2);
//			Manager manager = (Manager) session.get(Manager.class, 23L);
//			System.out.println(manager.toString());
//			Employee employee = (Employee) session.get(Employee.class, 21L);
//			System.out.println(employee.toString());
//			manager.getEmployees().add(employee);
//			manager.setSalary(12000);
//			employee.setManager(manager);
//			manager.addEmployee(employee);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
	}

}
