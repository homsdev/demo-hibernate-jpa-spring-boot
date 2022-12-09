package com.homsdev.demohibernatejpaspringboot.repository;

import com.homsdev.demohibernatejpaspringboot.DemoHibernateJpaSpringBootApplication;
import com.homsdev.demohibernatejpaspringboot.model.Passport;
import com.homsdev.demohibernatejpaspringboot.model.Student;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = DemoHibernateJpaSpringBootApplication.class)
class StudentRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testFindStudentByIdEAGER(){
        Student student = studentRepository.findById(201L);
        Assertions.assertEquals("Tifa",student.getName());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void testFindStudentByIdLazy(){
        Student student = studentRepository.findById(201L);
        String pass= student.getPassport().getNumber();
        Assertions.assertEquals("401LTF",pass);
    }

    @Transactional//This annotation when using Entity Manager
    public void testFindStudentByIdUsingEM(){
        Student student=entityManager.find(Student.class,201L);
        Assertions.assertEquals("Tifa",student.getName());
    }
}