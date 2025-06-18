package com.tpe.hb01.annotation;

import javax.persistence.*;

@Entity// Bu classtan olusturdugumuz objelerin database'de kalici hale getirmek icin class ismi ile ayni isimde bir tablo olusturur.
@Table(name= "t_student01")//Eger tabloya custom bir isim vermek istersek; tabloya custom bir isim vermemizi saglar.
// HQL: Student01 -> java kodlarindan anlar bu sebepten SQL sorgularinda class ismini kullaniriz
//SQL: t_student01  -> native sql sorgularini kullandigi icin burda ise osrgularimizda database'deki tablo ve field isimlerini kullanmaliyiz.
public class Student01 {


    @Id // @Entity kullanildiginda kullanimi zorunludur. Primery Key ihtiyac oldugundan @Id annatattionu kullanilmalidir.
    @Column(name = "std_id")
    private int id;


    @Column(name = "std_name", length =100, nullable = false, unique=true)
    private String name;

    private int grade;


    @Transient // bu fiel'da karsilik age isminde bir sütun database'de  olmusturmaz
    private int age;

    // BLOB data tipini kullaniyoruz büyük datalar icin (resim, ses, video gibi)

 // @Lob // Büyük boyutlu datalari tutmak icin byte array'i kullanilir ve bu annatation ile bunu hibernate bildiririz
 //  private byte [] imageFile;

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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                '}';
    }

}
