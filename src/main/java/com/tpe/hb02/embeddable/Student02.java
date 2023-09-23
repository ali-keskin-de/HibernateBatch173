package com.tpe.hb02.embeddable;

import javax.persistence.*;

@Table(name = "t_student02")
@Entity
public class Student02 {


    @Id
    private int id;

    @Column(name = "std_name", length =100, nullable = false,unique = true)
    private String name;

    private  int grade;

    @Embedded // kullanimi opsional, gömülü demektir. zaten biz bu annotation'u Address classinda class levelde kullanmis olduk.
    private Address address;
    // street, city, country, zipcode
    // Bu entity classinin db tarafinda olusacak tabloda yukardaki street, city, country, zipcode  columlari olacak.



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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }


}
