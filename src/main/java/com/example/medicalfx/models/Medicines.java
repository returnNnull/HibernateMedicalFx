package com.example.medicalfx.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Medicines {
    private int id;
    private String code;
    private String name ;
    private String manufacturer ;
    private String price ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicines medicines = (Medicines) o;
        return id == medicines.id && Objects.equals(code, medicines.code) && Objects.equals(name, medicines.name) && Objects.equals(manufacturer, medicines.manufacturer) && Objects.equals(price, medicines.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, manufacturer, price);
    }
}
