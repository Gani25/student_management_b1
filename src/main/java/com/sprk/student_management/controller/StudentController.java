package com.sprk.student_management.controller;

import com.sprk.student_management.entity.Student;
import com.sprk.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sprk")
public class StudentController {

    // Injecting Service
    private final StudentService studentService;

    // Insert student
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        // Service Call
        Student savedStudent = studentService.saveStudent(student);
        return savedStudent;
    }


}
