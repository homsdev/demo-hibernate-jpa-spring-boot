package com.homsdev.demohibernatejpaspringboot.repository;

import com.homsdev.demohibernatejpaspringboot.model.Course;
import com.homsdev.demohibernatejpaspringboot.model.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    public void testFindById(){
       Review review = reviewRepository.findById(501L);
       Course course =review.getCourse();
       logger.info(course.getName());
    }

    @Test
    @Transactional
    public void testSaveReview(){
        Review review = new Review(5,"Excellent course");
        reviewRepository.saveReview(103L,review);
    }
}