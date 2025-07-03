package com.tpe.hb07bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student07")
public class Student07 {//ONE

    @Id
    private int id;

    private String name;

    private int grade;

    // Burada oneToMany bir iliski olmasina ragmen iliskiler her iki taraftada tanimlandigindan
    // dolayi JoinColumn yazmak zorunlulugumuz kalmiyor opsional duruma geliyor.
    // mappedBy = "student" diyerek Book07 tablosunda Student göre set etdemektir.
    // böyleleikle sadece book tablosunda fk sütunu olusmaktadir.

    //  @OneToMany(mappedBy = "student",cascade = CascadeType.REMOVE)
    @OneToMany(mappedBy = "student",orphanRemoval = true)
    private List<Book07> bookList=new ArrayList<>();//MANY
    //orphanRemoval default false'tur ancak true cekildiginde iliskili obje'yi sillersen cocuklarinida sil demek;
    // yani ögrenciyi sillersen kitaplarida sil--> CascadeType.REMOVE  ile ayni isi yapar ve bu ancak hibernate ait tir.

    //mappedBy = "student": Bu özellik, ilişkiyi "Book07" varlığında "Öğrenci" varlığına geri bağlamak için kullanılan alanın
    // veya özelliğin adını belirtir. Başka bir deyişle, "Book07" varlığındaki "student" alanı,
    // her kitabın hangi öğrenciye ait olduğunu belirlemek için kullanılır.


    public Student07() {
    }

    //param const

    public Student07(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


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

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    //toString

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
