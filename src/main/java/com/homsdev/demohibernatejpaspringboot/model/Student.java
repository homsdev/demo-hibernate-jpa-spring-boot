package com.homsdev.demohibernatejpaspringboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    /**
     * The Entity with the data owns the relation
     * All OneToOne Mappings apply eager strategy on fetching resources
     */
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    /**
     * In ManyToMany relationships if owner is no specified two tables will be created
     * The owner of the relationship could be whichever of both entities
     */
    @ManyToMany
    private List<Course> courses;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course){
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
