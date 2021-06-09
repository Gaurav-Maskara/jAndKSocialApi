package com.negd.umang.jksocial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.negd.umang.jksocial.entity.Course;
import com.negd.umang.jksocial.entity.FullTimeEmployee;
import com.negd.umang.jksocial.entity.PartTimeEmployee;
import com.negd.umang.jksocial.entity.Review;
import com.negd.umang.jksocial.entity.Student;
import com.negd.umang.jksocial.repository.CourseRepository;
import com.negd.umang.jksocial.repository.EmployeeRepository;
import com.negd.umang.jksocial.repository.StudentRepository;

@SpringBootApplication
public class JandKSocialApiApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JandKSocialApiApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Course course = courseRepository.findById(10001L);
		logger.info("Course 10001 -> {}", course);
		studentRepository.saveStudentWithPassport();

		// repository.deleteById(10001L);

		// repository.save(new Course("Microservices in 100 Steps"));

        //List<Review> reviews = new ArrayList<Review>();
		//reviews.add(new Review("5", "Great Hands-on Stuff."));	
		//reviews.add(new Review("5", "Hatsoff."));

		//courseRepository.addReviewsForCourse(10003L, reviews );
		//studentRepository.insertHardcodedStudentAndCourse();
		
		//studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));
		
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("Full Time Employees -> {}", 
				employeeRepository.retrieveAllFullTimeEmployees());
		
		logger.info("Part Time Employees -> {}", 
				employeeRepository.retrieveAllPartTimeEmployees());


	}

}
