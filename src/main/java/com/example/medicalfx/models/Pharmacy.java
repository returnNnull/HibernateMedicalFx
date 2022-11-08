package com.example.medicalfx.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Pharmacy {
    private int id;
    private String number;
    private String name;
    private String phone;
    private String address;

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
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return id == pharmacy.id && Objects.equals(number, pharmacy.number) && Objects.equals(name, pharmacy.name) && Objects.equals(phone, pharmacy.phone) && Objects.equals(address, pharmacy.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name, phone, address);
    }
}
