package com.tpe.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

    public static void main(String[] args) {

        Configuration config=new Configuration().configure().addAnnotatedClass(Student02.class);


        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        //id:1001 olan studentı görelim.
       Student02 student=session.get(Student02.class,1001);
        System.out.println(student);
        System.out.println(student.getAddress());


        tx.commit();
        session.close();
        sf.close();


    }


}
