package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {


    public static void main(String[] args) {
        Student01 student1 = new Student01();
        student1.setName("Ali Keskin");
        student1.setId(1001);
        student1.setGrade(98);
        student1.setAge(25);

        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("John White");
        student2.setAge(29);
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Max Book");
        student3.setAge(27);
        student3.setGrade(80);

        Student01 student4 = new Student01();
        student4.setId(1004);
        student4.setName("Ahmet Book");
        student4.setAge(29);
        student4.setGrade(70);

        Student01 student5 = new Student01();
        student4.setId(1005);
        student4.setName("MEHMET Book");
        student4.setAge(29);
        student4.setGrade(70);

        // hibernate.cfg.xml dosyamizdaki bilgilere ve Student01 classindaki annotation'lara göre configuration yapilir.
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        //addAnnotatedClass ile Entity class'imizi hibernaete gösteriyoruz.

        // Hibernate SessionFactory interface ile DB ile ilgili islemleri yönetmemizi saglayan interfacetir.
        // tüm uygulamada sadece bir kez sf olusturulur. Fakat farkli islemler icin birden fazla session acilabilir.
       SessionFactory sf= configuration.buildSessionFactory(); // Database ile ilgili islemlerin yönetimini saglar.

        Session session = sf.openSession();// Database'de CRUD operasyanlari icin ve sorgulari calistirmak icin methodlar icerir.

        // hibernate auto-commit: false Hibernate'te default'ta false'tir bu sebepten commit islemlerini bir transaction icerisinde yapmaliyiz.
        // hibernate auto-commit: false oldugundan transaction'in baslatilmasi gerekmektedir.
        Transaction tx = session.beginTransaction(); // DB'de bir transaction baslatir.

        // Insert into
        //session.persist(student01);// data'yi database ekledik
       // session.persist(student2);
        //session.persist(student3);
        session.persist(student4); // session'in persist method'u objemizin databasede hibernate tarafindan kalici olarak kaydetmeye yarar.


        tx.commit(); // yukarda basladigimiz transaction'i onaylamak icin commit() kullanilir. böylelikle database'deki islemleri kalici olarak kaydetmis oluruz.
        session.close();
        sf.close();

    }
}
