package com.tpe.hb11.criteriaapi;

import com.tpe.hb05.manytoone_uni.Student05;
import com.tpe.hb05.manytoone_uni.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave {

    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student11.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        Random random = new Random();
        for (int i = 1; i <21 ; i++) {

            Student11 student = new Student11();
            student.setName("Student "+ i);
            student.setGrade(random.nextInt(101));
            session.persist(student);

        }


        tx.commit();
        session.close();
        sf.close();




    }
}
