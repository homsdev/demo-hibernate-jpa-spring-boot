package com.homsdev.demohibernatejpaspringboot.repository;

import com.homsdev.demohibernatejpaspringboot.model.Passport;
import com.homsdev.demohibernatejpaspringboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Add this annotation @Transactional to indicate every method inside is transactional
 * If Something fails everything must be rolled back
 * Creates one "Persistence Context" (Session) From Begin to end in every method
 */
@Repository
@Transactional
public class StudentRepository {
    @Autowired
    private EntityManager em;

    public void createStudent(Student student) {
        em.persist(student);
    }

    //@Transactional //If no added persistence context start an closes when E.M. finishes the task
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student updateStudent(Long id, Student student){
        Student studentToUpdate = findById(id);
        studentToUpdate.setName(student.getName());
        return em.merge(studentToUpdate);
    }

    public void deleteById(Long id){
        Student studentToRemove = findById(id);
        em.remove(studentToRemove);
    }

    /**
     * Before linking an entity from another table it needs
     * to be already in te Persistence Context
     */
    public void insertDummyStudentWithPassport(){
        Student student = new Student("Jacob");
        Passport passport = new Passport("XLXXX1");
        em.persist(passport);
        student.setPassport(passport);
        em.persist(student);
    }
}
