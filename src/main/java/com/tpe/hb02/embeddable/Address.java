package com.tpe.hb02.embeddable;

import javax.persistence.Embeddable;


@Embeddable // bu classa karsilik bir tablo olusturma, baska bir tabloya bu classtaki fieldlar baksa bir tabloya eklenebilir
public class Address {

    private String street;

    private String city;

    private String country;

    private String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    //dataları fetch(getirirken) ettiğinde Hibernate parametresiz const. kullanır.
    // Eger biz bir parametreli bir constructor yazarsak bu parametresiz default constructor ezer,
    // bu sebepten parametresiz constructor 'i biz elle yazmaliyiz yoksa get() methodlarimiz dogru calismaz
    /*
    🔹 Hibernate ve Constructor Kullanımı
Hibernate, veritabanından bir entity'yi getirirken (örneğin get(), find(), load() gibi methodlarla), Java Reflection API kullanır. Bu API sayesinde Hibernate, sınıfınızın nesnesini parametresiz (no-arg) constructor üzerinden oluşturur.

🔸 Parametreli Constructor Yazarsanız Ne Olur?
Java'da siz herhangi bir constructor (parametreli) yazdığınızda, Java artık otomatik olarak default (parametresiz) constructor sağlamaz. Bu durumda:

Eğer siz parametreli bir constructor yazdıysanız,

Ve ayrıca parametresiz constructor kendiniz yazmazsanız,

Hibernate, bu entity'yi oluşturamaz ve get() gibi methodlar çalışmaz (örneğin org.hibernate.InstantiationException hatası alırsınız).
     */

    public Address() {
    }

    //parametreli constructor
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
