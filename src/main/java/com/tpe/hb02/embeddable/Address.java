package com.tpe.hb02.embeddable;

import javax.persistence.Embeddable;


@Embeddable // bu classa karsilik bir tablo olusturma, baska bir tabloya bu classtaki fiellar baksa bir tabloya eklenebilir
public class Address {

    private String street;

    private String city;

    private String country;

    private String zipCode;

    public Address() {
    }//dataları fetch ettiğinde Hibernate parametresiz const. kullanır.


    //param const
    public Address(String street, String city, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


}
