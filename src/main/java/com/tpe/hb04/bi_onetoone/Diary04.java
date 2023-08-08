package com.tpe.hb04.bi_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary04 { // owner of relation, iliski sahibi class

    @Id // PK
    private int id;

    private String name;


    @JoinColumn(name = "std_id", unique = true)// opsionale
    @OneToOne // Student tablosunun pk sütununu kullanaarak fk sütunu olusturur. Buraya bir sütun ekler defaulta: student_id olur. burdaki student field ismine _id ekliyor
    private Student04 student;

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


    public void setStudent(Student04 student) {
        this.student = student;
    }

    public Student04 getStudent() {
        return student;
    }
    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
              /*  ", student=" + student +

               */
                '}';
    }
}
