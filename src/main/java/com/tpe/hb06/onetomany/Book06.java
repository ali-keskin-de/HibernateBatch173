package com.tpe.hb06.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book06 {

    @Id
    private int id;

    private String name;


    // Parametresiz constructor
    public Book06() {
    }

    //param const
    public Book06(int id, String name) {
        this.id = id;
        this.name = name;
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
    //toString

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}