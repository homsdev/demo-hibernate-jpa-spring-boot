package com.homsdev.demohibernatejpaspringboot.model;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String number;

    /**
     * To ensure not to have duplicated info in Tables
     * we specify Student as the owner of this relationship using mappedBy
     * by specifying the field that owns the relationship in the Non-owning Entity
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;
    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
