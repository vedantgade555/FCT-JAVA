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

        // Courses
        Course c1 = new Course();
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourseName("Python");

        // Students
        Student s1 = new Student();
        s1.setName("Nitin");

        Student s2 = new Student();
        s2.setName("Raj");

        // Assign courses to students
        Set<Course> courses1 = new HashSet<>();
        courses1.add(c1);
        courses1.add(c2);
        s1.setCourses(courses1);

        Set<Course> courses2 = new HashSet<>();
        courses2.add(c1);
        s2.setCourses(courses2);

        // Assign students to courses (inverse side)
        Set<Student> studentsForC1 = new HashSet<>();
        studentsForC1.add(s1);
        studentsForC1.add(s2);
        c1.setStudents(studentsForC1);

        Set<Student> studentsForC2 = new HashSet<>();
        studentsForC2.add(s1);
        c2.setStudents(studentsForC2);

        // Save (only save students, cascade will handle courses)
        session.persist(s1);
        session.persist(s2);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Many-to-Many data saved successfully");
    }
}
