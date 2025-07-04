package com.tpe.hb05.manytoone_uni;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {// Many olan taraf

    @Id
    private int id;

    private String name;



    private int grade;

    private LocalDateTime creatOn;

    // bu class objesi persist edilmeden yani kalici hale getirilmeden  (DB'e eklenmeden) önce bu method cagirilir.
    // böylelikle bu methodun icinde bulunduğu creatOn field’ti Bu class’ta create edilen object DB kayit olmadan hem önce bu method sayesinde seslenmiş olur.
    @PrePersist
    public void prePersist(){
        this.creatOn =LocalDateTime.now();
    }

    @ManyToOne// Student tablosunda FK olusturur, default isimi: university_id, custom bir isim olusturmak isterseniz @JoinColumn(name = "uni_id")
    @JoinColumn(name = "uni_id")
    private University university;//one

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", creatOn=" + creatOn +
                ", university=" + university +
                '}';
    }

    public Student05(int id, String name, int grade, University university) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.university = university;
    }

    public Student05() {
    }

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

    public LocalDateTime getCreatOn() {
        return creatOn;
    }

/*    public void setCreatOn(LocalDateTime creatOn) {
        this.creatOn = creatOn;
    }
    // Bu method set islemleri manuel olarak gerceklesmeyeceginden setter method'una ihtiyac yoktur.
 */

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }



}
