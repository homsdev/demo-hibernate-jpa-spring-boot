package com.homsdev.demohibernatejpaspringboot.repository;

import com.homsdev.demohibernatejpaspringboot.model.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Transactional
    public void testFindCourseById(){
        Course course =courseRepository.readById(101L);
        course.getReviewList();
        logger.info("Reviews :{}",course.getReviewList());
    }

}