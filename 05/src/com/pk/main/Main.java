package com.pk.main;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.pk.entities.Employee;
import com.pk.entities.Manager;
import com.pk.entities.Project;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		configuration.addAnnotatedClass(Project.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Manager.class);
		Session session = configuration.buildSessionFactory(serviceRegistry).openSession();
		
//		Manager manager1 = new Manager("qwerrt", "Alex", 10000);
//		Manager manager2 = new Manager("asdffg", "Andrew", 15000);
//		
//		Employee employee1 = new Employee("123456", "Bredly", manager1);
//		Employee employee2 = new Employee("234567", "Bob", manager1);
//		
//		manager1.getEmployees().add(employee1);
//		manager1.getEmployees().add(employee2);
//		
//		Project project1 = new Project("SECAM", "QWERT");
//		Project project2 = new Project("PAL", "ASDFG");
//		project2.getEmployees().add(employee1);
//		project2.getEmployees().add(employee2);
//		project1.getEmployees().add(employee1);
			
		
		try {
		
			session.beginTransaction();
			
//			session.persist(project1);
			
			Project project = (Project) session.get(Project.class, 5L);
			Employee employee = (Employee) session.get(Employee.class, 4L);
//			employee.getProjects().add(project);//does not update join table
			project.getEmployees().add(employee);//updating

			session.getTransaction().commit();
			
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
	}

}
