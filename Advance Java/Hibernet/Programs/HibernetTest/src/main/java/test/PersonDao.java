package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonDao {

	public static void main(String[] args) {
		// Step 1: Read hibernate.cfg.xml
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        // Step 2: Build SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // Step 3: Open Session
        Session session = factory.openSession();

        // Step 4: Begin Transaction
        Transaction tx = session.beginTransaction();

        // Step 5: Create Entity Object
        Person person = new Person("Raj","Pune",50000);

        // Step 6: Save object
        session.save(person);

        // Step 7: Commit transaction
        tx.commit();

        // Step 8: Close resources
        session.close();
        factory.close();

        System.out.println("Details Added Successfully ✅");
	}

}
