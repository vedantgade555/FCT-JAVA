package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchData {
	public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
// Step 2
        SessionFactory factory = conf.buildSessionFactory();
        // Step 3
        Session session = factory.openSession();
       
        // Step 4
        TypedQuery<Employee> q1 = session.createQuery("from Employee e");
        
        List<Employee> l1 = q1.getResultList();
        
        Iterator<Employee> itr = l1.iterator();
        
        while(itr.hasNext()) {
        	Employee emp = itr.next();
        	System.out.println(emp.getEmpId());
        	System.out.println(emp.getEmpName());
        	System.out.println(emp.getDepartment());
        }
        
        session.close();
        factory.close();

        System.out.println("Details Added Successfully");
    }
}
