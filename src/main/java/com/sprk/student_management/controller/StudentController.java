package com.sprk.student_management.controller;

import com.sprk.student_management.entity.Student;
import com.sprk.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Find All Students
    @GetMapping("/student")
    public List<Student> getAllStudents(){
        List<Student> students = studentService.findAllStudents();
        return students;
    }

    // Find Student By Roll No
    @GetMapping("/student/{rollNo}")
    public Student getStudentByRollNo(@PathVariable int rollNo){
        Student existingStudent = studentService.findStudentByRollNo(rollNo);

        return existingStudent;
    }

    // Find Student By Gender
    // /student?gender=Male
    @GetMapping("/gender-student")
    public List<Student> getAllByGender(@RequestParam String gender)
    {
        List<Student> student = studentService.findAllByGender(gender);
        return student;
    }

}
