package com.homsdev.demohibernatejpaspringboot.repository;

import com.homsdev.demohibernatejpaspringboot.model.Course;
import com.homsdev.demohibernatejpaspringboot.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ReviewRepository {

    @Autowired
    private EntityManager em;

    public Review findById(long id){
           return em.find(Review.class,id);
    }

    public void saveReview(Long courseId,Review review){
        Course course = em.find(Course.class,courseId);
        review.setCourse(course);
        em.persist(course);
    }
}
