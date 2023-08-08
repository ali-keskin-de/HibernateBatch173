package com.tpe.hb04.bi_onetoone;

import javax.persistence.*;

@Table(name = "t_student04")
@Entity
public class Student04 {

    @Id//entity annotasyonu kullanıldığında kullanımı zorunludur, PK sütununun belirlenmesini sağlar
    private int id;

    @Column(name = "std_name",length = 100,nullable = false,unique = true)//opsiyonel
    private String name;

    private int grade;

    public Student04() {

    }

    @OneToOne(mappedBy = "student")//sadece diary tablosunda FK olusturulur. mapped by kullanilmazsa iki tabloda Fk olur.
    private Diary04 diary;


        //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



}
