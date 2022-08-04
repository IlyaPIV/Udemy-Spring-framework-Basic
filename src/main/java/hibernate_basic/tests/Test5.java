package hibernate_basic.tests;

import hibernate_basic.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 1);
            session.delete(emp);

            session.createQuery("delete Employee where department = 'HR'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
        System.out.println("Done!");
    }
}
