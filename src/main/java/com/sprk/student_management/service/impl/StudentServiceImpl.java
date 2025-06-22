package com.sprk.student_management.service.impl;

import com.sprk.student_management.entity.Student;
import com.sprk.student_management.repository.StudentRepository;
import com.sprk.student_management.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    // Field Injection
//    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    /*
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    */
}
