package com.tpe.hb05.manytoone_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {


        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student05.class).
                addAnnotatedClass(University.class);


        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //id:1001 olan öğrencinin tüm bilgilerini yazdıralım.
        Student05 student = session.get(Student05.class, 1001);// id verdigimiz bütün datalari getiriyor ancak biz toString() methodunda görmek istedigimiz verileri görürüz
        System.out.println(student);
        System.out.println(student.getUniversity());

        //HQL ile id:11 olan university e giden tüm öğrencileri listeleyelim.
        // Bunu kullanamayiz cünkü bizim iliskimiz tek tarafli.
        //      University university= session.get(University.class,11);
        //      university.getStudent()

        //hql SELECT yazmaya gerek kalmiyor. Eger yazmak isteerseniz asagidaki gibi yazabilirsiniz.
        String hql = "SELECT s FROM Student05 s Where s.university.id=11";
        List<Student05> studentList = session.createQuery(hql, Student05.class).getResultList();

        // yukardaki ifadede hql den sonraki "Student05.class" bu ifade geriye bu sorgu bana bir object dönecek ve tipide Student05 olacagini belirtir,
        // "getResultList()" bu sorgu bize birden fazla object döneceginde sonucu liste ile dön demek.
        // Hql select all ifadesi yerine SELECT s FROM bu kullanilir "s" burda bize ailen ile dönecek sonuclarin Student05 object'inin tüm field lari ile bir object dönecegini belirtir.
        studentList.forEach(System.out::println); // method referans kullanilmistir.

        //üniye giden öğrencilerin isimlerini, notlarını ve üniversitelerinin isimlerini yazdıralım
        String hql2 = "SELECT s.name,s.grade, u.name FROM Student05 s INNER JOIN University u ON s.university.id= u.id";
        List<Object[]> resultList2 = session.createQuery(hql2).getResultList();
        resultList2.forEach(t -> System.out.println(Arrays.toString(t)));


        tx.commit();
        session.close();
        sf.close();


    }
}
