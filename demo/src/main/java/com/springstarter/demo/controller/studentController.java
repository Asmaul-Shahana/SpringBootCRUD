package com.springstarter.demo.controller;

import com.springstarter.demo.exception.ResourceNotFoundException;
import com.springstarter.demo.model.student;
import com.springstarter.demo.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/allstudents")
public class studentController {

    @Autowired
    private StudentRepository studentRepository;

    //View all students
    @GetMapping
    public List<student> getAllStudents(){
        return studentRepository.findAll();
    }

    //build CREATE a student REST API
    @PostMapping
    public student createStudent(@RequestBody student stu)
    {
        return studentRepository.save(stu);
    }

    //build GET a student by id REST API
    @GetMapping("{id}")
    public ResponseEntity<student> getStudentbyID(@PathVariable int id){
        student stu = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student doesn't exist with id: "+ id));
        return ResponseEntity.ok(stu);
    }

    //build UPDATE student REST API
    @PutMapping("{id}")
    public ResponseEntity<student> updateStudent(@PathVariable int id,@RequestBody student updateStudentDetails)
    {
        student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student does'nt exist with id: "+ id));

        updateStudent.setFname(updateStudentDetails.getFname());
        updateStudent.setLname(updateStudentDetails.getLname());

        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }

    //build DELETE a student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id){

        student stu = studentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student doesn't exist with id: "+id));
    studentRepository.delete(stu);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
