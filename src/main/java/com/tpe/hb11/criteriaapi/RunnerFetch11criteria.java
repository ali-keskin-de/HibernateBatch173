package com.tpe.hb11.criteriaapi;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class RunnerFetch11criteria {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student11.class);


        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //Criteria API
        //SQL-HQL string bazlı-->hataya açık
        //criteria api:java kodlarını kullanarak programatik sorgulama
        //hatalar azalır ve derleme anında hata almamızı sağlar
        //Hibernate criteria api deprecate oldu JPA criteria api
        //Read:CriteriaQuery
        //Update:CriteriaUpdate
        //Delete:CriteriaDelete

        //hql Java bileşenlerini kullanarak sorgu yazdığı için sql den avantajlıdır..
// ancak her ikisinde de String ifade seklinde yazılır ve syntax hatada CTE vermez.. hatalı kod calısınca EXCEPTION gelir
//SQL-HQL string bazlı-->hataya açık
//criteria api: JAva kodlarını kullanarak programatik(javaca) sorgulama yapmamızı sağlar.
        // string dısında bır yazım olduğu için hatalar azalır; derleme anında hata verir
//hibernate criteria api geliştirilmiş ancak su an deprecate oldu. JPA CRITERIA API ile uyum sağlandı
//Read:  select sorguları için CriteriaQuery
//Update:  update sorguları için CriteriaUpdate
//Delete:  delete sorguları için CriteriaDelete


        CriteriaBuilder cb = session.getCriteriaBuilder();



        tx.commit();
        session.close();
        sf.close();

    }


}
