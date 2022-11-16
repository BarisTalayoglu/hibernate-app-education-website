package com.byrsh.hibernate.demo.CRUD;

import com.byrsh.hibernate.demo.entity.Course;
import com.byrsh.hibernate.demo.entity.Instructor;
import com.byrsh.hibernate.demo.entity.InstructorDetail;
import com.byrsh.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How to Score Millions");
            tempCourse.addReview(new Review("This is awesome course!!"));
            tempCourse.addReview(new Review("Course very helpfulLLL!"));
            tempCourse.addReview(new Review("Who would buy this course awefulL!!"));
            session.save(tempCourse);
            session.getTransaction().commit();

            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());


        }finally {
            session.close();
            factory.close();
        }


    }
}
