package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {


        // configure()--> configurasyon dosyamizda defaalt isimlendirmeyi kullandigimizdan (hibernate.cfg.xml) method'a bu ismi yazmak zorunda degiliz.
        //Eger resource'da ki xml configuration dosyasina baska bir isim vermis olsaydik yazmak zorunda olurduk.
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student01.class);
        SessionFactory sf =configuration.buildSessionFactory();
         Session session = sf.openSession();
          Transaction tx = session.beginTransaction();

          // Database'den data cekmek icin 3 tane yol var.

       Student01 student1 = session.get(Student01.class, 1001);// select * from t_student01 where std_id =1001;
       Student01 student2 = session.get(Student01.class, 1002);// select * from t_student01 where std_id =1002;
       Student01 student3 = session.get(Student01.class, 1003);// select * from t_student01 where std_id =1003;

        System.out.println("-----------------------------Get Method'u---------------------------------");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        // 2.yol : SQL sorgusu ile database'den datqlarimizi getirebiliriz.

        String sql = "SELECT * FROM t_student01";
        List<Object[]> students=session.createSQLQuery(sql).getResultList();

        for (Object[] student: students){
              {
                  System.out.println(Arrays.toString(student));
              }

        }

        // 3.yol: Hibernate Query Language: java bilesenlerini kullanarak sorgu yazarak.
        // HQL: Student01
       //SQL: t_student01

        String hql = "FROM Student01";
        List<Student01> resultList=session.createQuery(hql,Student01.class).getResultList();

        for (Student01 student:resultList
             ) {
            System.out.println(student);

        }

        // ismi Max olan kaydi görüntüleyelim.
        //SQL
        String sql2 = "SELECT * FROM t_student01 WHERE std_name='Max Book'";
        Object [] studentMax = (Object[]) session.createSQLQuery(sql2).uniqueResult();
        System.out.println(Arrays.toString(studentMax));


        // HQl
        String hql2 = " FROM Student01 WHERE name= 'Max Book'";
        Student01 studentMaxHql =session.createQuery(hql2, Student01.class).uniqueResult();
        System.out.println(studentMaxHql);


        //  hql sorgusunda ALIAS kullanalim
        String hql3 = "SELECT id, name FROM Student01 s WHERE s.name= 'Ali Keskin'";
       Object [] studentAli = (Object[]) session.createQuery(hql3).uniqueResult(); // geriye [id, name] gelecek sadece.
        System.out.println(Arrays.toString(studentAli));


          tx.commit();
          session.close();
          sf.close();
    }
}
