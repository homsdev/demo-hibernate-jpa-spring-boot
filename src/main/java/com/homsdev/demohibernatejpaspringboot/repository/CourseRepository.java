package com.homsdev.demohibernatejpaspringboot.repository;

import com.homsdev.demohibernatejpaspringboot.model.Course;
import com.homsdev.demohibernatejpaspringboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional //Add this annotation to indicate every method inside is transactional
/**
 * Add this annotation @Transactional to indicate every method inside is transactional
 * If Something fails everything must be rolled back
 * Creates one "Persistence Context" (Session) From Begin to end
 */
public class CourseRepository {

    @Autowired
    private EntityManager em;

    /**
     * Principal CRUD operations in EntityManager
     * Persist: save actual state to dB
     * Merge: update actual state to dB
     * Find: retrieve state from dB
     * Remove: remove from dB
     */

    public void createCourse(Course course){
        em.persist(course);
    }
    public Course readById(Long id){
        return em.find(Course.class,id);
    }

    public Course updateCourse(Long id, Course course){
        Course courseToUpdate = readById(id);
        courseToUpdate.setName(course.getName());
        return em.merge(courseToUpdate);
    }

    public void deleteById(Long id){
        Course course = readById(id);
        em.remove(course);
    }

}
