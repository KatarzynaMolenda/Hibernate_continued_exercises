package _1_;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Department department1 = new Department("HR", "Warsaw");
        Department department2 = new Department("IT", "Gdansk");
        Person person1 = new Person("Adam", "Adamski");
        Person person2 = new Person("Kasia", "Kasiowska");
        Job job1 = new Job("specialist", 4200);
        Job job2 = new Job("director", 7000);
        Employee employee1 = new Employee(person1, 1988, department1, job1, "ul. Strumykowa 14, Warszawa");
        Employee employee2 = new Employee(person2, 1982, department2, job2, "ul. Piękna 12, Gdańsk");
        Project project1 = new Project("servicing temporary workers", 120000);
        Project project2 = new Project("implementation of new system", 500000);
        session.save(department1);
        session.save(department2);
        session.save(job1);
        session.save(job2);
        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
