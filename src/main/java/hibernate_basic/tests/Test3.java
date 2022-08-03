package hibernate_basic.tests;

import hibernate_basic.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> emps = session.createQuery("from Employee")
//                                            .getResultList();

//            List<Employee> emps = session.createQuery("from Employee where name = 'Oleg'")
//                    .getResultList();

            List<Employee> emps = session.createQuery("from Employee where name = 'Oleg' OR salary > 400")
                    .getResultList();


            for (Employee e:
                 emps) {
                System.out.println(e);
            }
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
        System.out.println("Done!");
    }
}