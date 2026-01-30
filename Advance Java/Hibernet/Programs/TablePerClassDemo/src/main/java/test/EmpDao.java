package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class EmpDao {
	public static void main(String[] args) {
		//Step 1
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		//Step 2
		SessionFactory factory = conf.buildSessionFactory();
		
		// Step 3
		
		Session session = factory.openSession();
		
		// Step 4
		
		Transaction tx = session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setName("Vivek");
		
		
		RegEmp e2=new RegEmp();
		e2.setName("Ayush");
		e2.setSalary(50000);
		e2.setBonus(5);

		ContractEmp e3=new ContractEmp();
		e3.setName("Vinay");
		e3.setPay_per_hour(10);
		e3.setContract_period("15 Hours");

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);
		
		
		tx.commit();
		session.close();
		factory.close();

		System.out.println("Details Added Successfully");
		
	}
}
