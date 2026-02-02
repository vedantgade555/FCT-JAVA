package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {

        // Step 1: Load configuration
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        // Step 2: Build SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // Step 3: Open Session
        Session session = factory.openSession();

        // Step 4: Begin Transaction
        Transaction tx = session.beginTransaction();

        // Employee 1
        Employee e1 = new Employee();
        e1.setName("Nitin Arora");
        e1.setEmail("nitin@example.com");

        Address a1 = new Address();
        a1.setAddressline1("Pune PCMC Phase 3");
        a1.setCity("Pune");
        a1.setState("Maharashtra");
        a1.setCountry("India");
        a1.setPincode(411039);

        e1.setAddress(a1);

        // Employee 2
        Employee e2 = new Employee();
        e2.setName("Akhilesh Yadav");
        e2.setEmail("akhilesh@example.com");

        Address a2 = new Address();
        a2.setAddressline1("Mumbai Andheri East");
        a2.setCity("Mumbai");
        a2.setState("Maharashtra");
        a2.setCountry("India");
        a2.setPincode(400069);

        e2.setAddress(a2);

        // Save data
        session.persist(e1);
        session.persist(e2);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Details Added Successfully");
    }
}
