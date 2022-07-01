package com.springstarter.demo;

import com.springstarter.demo.model.student;
import com.springstarter.demo.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		student stu1 = new student();
		stu1.setFname("James");
		stu1.setLname("Willer");
		studentRepository.save(stu1);

		student stu2 = new student();
		stu2.setFname("Betty");
		stu2.setLname("Frank");
		studentRepository.save(stu2);
	}
}
