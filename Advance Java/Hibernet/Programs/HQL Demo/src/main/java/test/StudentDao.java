package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao {
	public static void main(String[] args) {

		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
// Step 2
		SessionFactory factory = conf.buildSessionFactory();
		// Step 3
		Session session = factory.openSession();
		// Step 4

		Transaction tx = session.beginTransaction();

		session.save(new Student("Raghav", 32));
		session.save(new Student("Rama", 30));
		session.save(new Student("Rahul", 31));
		session.save(new Student("Rohan", 33));
		session.save(new Student("Raj", 34));

		tx.commit();
		session.close();
		factory.close();

		System.out.println("Details Added Successfully");
	}
}
