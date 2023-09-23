package com.tpe.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student02.class);
        SessionFactory sf =cfg.buildSessionFactory();
         Session session = sf.openSession();
          Transaction tx = session.beginTransaction();

       Address address1 = new Address("Apple St.", "Newyork", "Us", "54321");
       Address address2 = new Address("Orange St.", "Newyork", "Us", "654321");

          Student02 student1 = new Student02();
          student1.setName("Fevzi");
          student1.setId(1001);
          student1.setGrade(100);
          student1.setAddress(address1);

        Student02 student2 = new Student02();
        student2.setName("Emre");
        student2.setId(1002);
        student2.setGrade(90);
        student2.setAddress(address2);

        session.persist(student1);
        session.persist(student2);



          tx.commit();
          session.close();
          sf.close();

    }
}
