package com.tpe.hb04.bi_onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student1 = new Student04();
        student1.setId(1001);
        student1.setName("Benna");
        student1.setGrade(100);


        Student04 student2 = new Student04();
        student2.setId(1002);
        student2.setName("Enes");
        student2.setGrade(99);

        Student04 student3 = new Student04();
        student3.setId(1003);
        student3.setName("Merve");
        student3.setGrade(98);


        Diary04 diary1=new Diary04();
        diary1.setId(11);
        diary1.setName("A Diary");
        diary1.setStudent(student1);

        Diary04 diary2=new Diary04();
        diary2.setId(22);
        diary2.setName("B Diary");
        diary2.setStudent(student2);

        Diary04 diary3=new Diary04();
        diary3.setId(33);
        diary3.setName("C Diary");
       // diary3.setStudent(student3);




        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf =cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // cift yönlü iliski olusturdugunuzda set islemini kesinlikle iliski sahibi olan yani FK icerecek tarafta set edilmeklli
        // iliski sahibi olan diary dir.

session.persist(student1);
session.persist(student2);
session.persist(student3);

session.persist(diary1);
session.persist(diary2);
session.persist(diary3);

        System.out.println("Student1'in diary'si : " + student1.getDiary());
        System.out.println("1.diary'nin sahibi : " + diary1.getStudent());


        tx.commit();
        sf.close();
        session.close();

    }


}
