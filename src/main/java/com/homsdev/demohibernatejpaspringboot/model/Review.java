package com.homsdev.demohibernatejpaspringboot.model;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int rating;
    private String description;

    /**
     * Because of design principle this table should be the owner of the relationship
     * In @ManyToOne relationships fetch type is EAGER by default
     */
    @ManyToOne
    private Course course;

    public Review() {
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", course=" + course +
                '}';
    }
}
