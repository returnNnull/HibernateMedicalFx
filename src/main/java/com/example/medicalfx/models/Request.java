package com.example.medicalfx.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Request {
    private int id;
    private String num;
    private String createDate;
    private String pharmacyNum;
    private String closeDate;
    private Purchase purchaseByNum;

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
    @Column(name = "num", insertable=false, updatable=false)
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Basic
    @Column(name = "create_date")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "pharmacy_num")
    public String getPharmacyNum() {
        return pharmacyNum;
    }

    public void setPharmacyNum(String pharmacyNum) {
        this.pharmacyNum = pharmacyNum;
    }

    @Basic
    @Column(name = "close_date")
    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id == request.id && Objects.equals(num, request.num) && Objects.equals(createDate, request.createDate) && Objects.equals(pharmacyNum, request.pharmacyNum) && Objects.equals(closeDate, request.closeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, createDate, pharmacyNum, closeDate);
    }

    @ManyToOne
    @JoinColumn(name = "num", referencedColumnName = "request_num", nullable = false)
    public Purchase getPurchaseByNum() {
        return purchaseByNum;
    }

    public void setPurchaseByNum(Purchase purchaseByNum) {
        this.purchaseByNum = purchaseByNum;
    }
}
