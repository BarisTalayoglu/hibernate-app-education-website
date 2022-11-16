package com.byrsh.hibernate.demo.CRUD;

import com.byrsh.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMarrydemo {
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

            Student tempStudent = session.get(Student.class,2);
            System.out.println(tempStudent.getCourses());

            Course tempCourse1 = new Course("Java Development - How to become Java Master");

            tempCourse1.addStudent(tempStudent);

            session.save(tempCourse1);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }


    }
}
