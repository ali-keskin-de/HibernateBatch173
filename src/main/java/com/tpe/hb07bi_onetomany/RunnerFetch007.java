package com.tpe.hb07bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch007 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);


        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //tüm studentları silebilir miyiz?EVET ama aşamalı olarak silebiliriz
        //öncelikle tüm kitapları silelim
//        String hql="DELETE FROM Book07";
//        int numOfRecord=session.createQuery(hql).executeUpdate();
//        System.out.println("silinen kayıt sayısı : " + numOfRecord);
//
//        String hql2="DELETE FROM Student07";
//        int numOfRecord2=session.createQuery(hql2).executeUpdate();
//        System.out.println("silinen kayıt sayısı : " + numOfRecord2);
//
//        //name:C++ Book olan kitabı silelim.
//        String hql3="DELETE FROM Book07 b WHERE b.name='C++ Book'";
//        int numOfRecord3=session.createQuery(hql2).executeUpdate();
//        System.out.println("silinen kayıt sayısı : " + numOfRecord3);


        //--------------------------------------------------------------------------------------

        //kitabı olan bir öğrenciyi silmek istersek bunun icin iki secenek var hibernate'te
        /*
        1-öğrencinin ilişkili olduğu kitapları silip sonra öğrenciyi silebiliriz.
        2-cascade = CascadeType.REMOVE/orphanRemoval=true bunun ikiside ayni islevi görmektedir.
         @OneToMany (mappedBy= "student", orphanRemoval=true) veya @OneToMany (mappedBy= "student", cascade = CascadeType.REMOVE)

        NOTE: Yukaradaki code'larimiz ile sunu yapmis olduk;
        eger bir student object'tini silmek istersek önce bu ögrencinin önce iliskide oldugu book object'tini siliyor sonra student silmektedir.

         */


        //id:1001 olan studentı silelim.
//        Student07 student1=session.get(Student07.class,1001);
//        session.delete(student1);

        Student07 student2 = session.get(Student07.class, 1002);
        student2.getBookList().remove(0);//103,104,105-->104,105
        System.out.println(student2.getBookList());

        // *** orphanRemoval= true in farki nedir cascade = CascadeType.Remove dan farki nedir?**************************
        /*
        1- orphanRemoval sadece onetomany de var
        2- collectionından bir eleman silinirse, yada null olarak
        3- set edilirse orphanRemoval referansı olmayan bu nesneyi tablodan da kaldırır.

         */
        /*
        müşteri-sipariş-->müşteri siparişi iptal edince
                       -->sipariş listesinden siparişi sileriz
                        -->sipariş listeden silinince tablodan da silinsin isteriz
        orphanRemoval kullanılabilir.

         */


        tx.commit();
        session.close();
        sf.close();


    }
}