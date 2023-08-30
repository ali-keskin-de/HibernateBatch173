package com.tpe.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch11 {

    public static void main(String[] args) {

        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student11.class);


        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // id=2 olan student'i isimini güncelleyelim

  //     Student11 studnet = session.get(Student11.class,2);
  //     studnet.setName("Updated "+ studnet.getName());
        //session.update(studnet);
        // grade i 30 den kücük olanlari ögrencilerin grade'ini 50 yapalim

        String hql = "UPDATE FROM Student11 s SET s.grade=:newValue WHERE s.grade < :oldValue";
       Query query = session.createQuery(hql);
       query.setParameter("newValue",50);
       query.setParameter("oldValue",30);
        int updatedRecord= query.executeUpdate();

        System.out.println("updatedRecord " + updatedRecord);



        tx.commit();
        session.close();
        sf.close();

    }
}
