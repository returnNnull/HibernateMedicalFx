package com.example.medicalfx.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Purchase {
    private int id;
    private String requestNum;
    private String medicinesCode;
    private String count;

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
    @Column(name = "request_num")
    public String getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(String requestNum) {
        this.requestNum = requestNum;
    }

    @Basic
    @Column(name = "medicines_code")
    public String getMedicinesCode() {
        return medicinesCode;
    }

    public void setMedicinesCode(String medicinesCode) {
        this.medicinesCode = medicinesCode;
    }

    @Basic
    @Column(name = "count")
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id == purchase.id && Objects.equals(requestNum, purchase.requestNum) && Objects.equals(medicinesCode, purchase.medicinesCode) && Objects.equals(count, purchase.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestNum, medicinesCode, count);
    }
}
