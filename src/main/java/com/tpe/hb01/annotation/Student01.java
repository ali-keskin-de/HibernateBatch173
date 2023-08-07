package com.tpe.hb01.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity// Bu classtan olusturdugumuz objelerin database'de kalici hale getirmek icin class ile ayni isimde bir tablo olusturur.
@Table(name= "t_student01")//Eger tabloya custom bir isim vermek istersek; tabloya custom bir isim vermemizi saglar
public class Student01 {


    @Id // @Entity kullanildiginda kullanimi zorunludur Primery Key ihtiyac oldugunda @Id annatattionu kullanilmalidir.
    private int id;

    @Column(name = "std_name", length =100, nullable = false, unique=true)
    private String name;
    private int grade;

// getter setter

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
