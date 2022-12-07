package com.homsdev.demohibernatejpaspringboot;

import com.homsdev.demohibernatejpaspringboot.model.Course;
import com.homsdev.demohibernatejpaspringboot.repository.CourseRepository;
import com.homsdev.demohibernatejpaspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHibernateJpaSpringBootApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoHibernateJpaSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        //Create new course
        Course newCourse = new Course("React for beginners");
        courseRepository.createCourse(newCourse);
        //Read course
        Course course = courseRepository.readById(1L);
        System.out.println(course);
        //Update course
        course.setName("JPA beginner friendly-updated");
        Course updatedCourse = courseRepository.updateCourse(1L,course);
        System.out.println(updatedCourse);
        //Remove course
        courseRepository.deleteById(1L);
         */
        studentRepository.insertDummyStudentWithPassport();
    }
}
