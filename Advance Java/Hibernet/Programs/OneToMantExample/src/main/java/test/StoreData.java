package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Department (ONE)
        Department d = new Department();
        d.setDeptName("IT");

        // Employee 1
        Employee e1 = new Employee();
        e1.setEmpName("Nitin Arora");
//        e1.setEmail("nitin@example.com");
        e1.setDepartment(d);

        // Employee 2
        Employee e2 = new Employee();
        e2.setEmpName("Raj Patil");
//        e2.setEmail("raj@example.com");
        e2.setDepartment(d);

        // Set employees to department (IMPORTANT)
        Set<Employee> empSet = new HashSet<>();
        empSet.add(e1);
        empSet.add(e2);

        d.setEmployees(empSet);

        // Save ONLY department
        session.persist(d);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Details Added Successfully");
    }
}
