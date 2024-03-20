package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductJava {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private String cc;
    private String heHe;

    public ProductJava() {
    }

    public ProductJava(String cc, String image) {
        this.image = image;
        this.cc = cc;
    }

    public ProductJava(int id, String image, String cc, String heHe) {
        this.id = id;
        this.image = image;
        this.cc = cc;
        this.heHe = heHe;
    }

    public String getHeHe() {
        return heHe;
    }

    public void setHeHe(String heHe) {
        this.heHe = heHe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public ProductJava(int id, String image, String cc) {
        this.id = id;
        this.image = image;
        this.cc = cc;
    }
}
