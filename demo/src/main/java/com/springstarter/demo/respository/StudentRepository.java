package com.springstarter.demo.respository;

import com.springstarter.demo.model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<student, Integer> {
    //This will get all the crud database methods
}
