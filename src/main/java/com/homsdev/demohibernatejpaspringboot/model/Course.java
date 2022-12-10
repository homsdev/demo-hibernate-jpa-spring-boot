package com.homsdev.demohibernatejpaspringboot.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    /**
     * mappedBy must be on the Non-owner side of the relation
     * @OneToMany relationships use a lazy strategy when fetching the data
     */
    //mappedBy must be on the Non-Owner side of the relationship
    @OneToMany(mappedBy = "course")
    private List<Review> reviewList;

    /**
     * In ManyToMany relationships if owner is no specified two tables will be created
     * The owner of the relationship could be whichever of both entities
     */
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addReview(Review review){
        reviewList.add(review);
    }

    public void removeReview(Review review){
        reviewList.remove(review);
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
