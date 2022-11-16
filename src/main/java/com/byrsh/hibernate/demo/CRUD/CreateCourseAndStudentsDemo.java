package com.byrsh.hibernate.demo.CRUD;

import com.byrsh.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How to get 1Mil score");
            session.save(tempCourse);

            Student tempStudent1 = new Student("John", "Doe","jd@hotmail.com");
            Student tempStudent2 = new Student("Marry", "Public","mp@hotmail.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println(tempCourse.getStudents());

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }


    }
}
