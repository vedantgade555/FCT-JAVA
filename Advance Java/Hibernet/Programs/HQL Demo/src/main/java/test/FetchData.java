package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchData {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List<Student> list =
                    session.createQuery("from Student", Student.class).list();

            for (Student s : list) {
                System.out.println("Name: " + s.getName());
                System.out.println("Age : " + s.getAge());
                System.out.println("------------------");
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

        System.out.println("Details Fetched Successfully");
    }
}
