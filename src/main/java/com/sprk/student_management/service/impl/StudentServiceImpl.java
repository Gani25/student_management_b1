package com.sprk.student_management.service.impl;

import com.sprk.student_management.dto.StudentDto;
import com.sprk.student_management.entity.Student;
import com.sprk.student_management.repository.StudentRepository;
import com.sprk.student_management.service.StudentService;
import com.sprk.student_management.util.StudentMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    // Field Injection
//    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        // Write the Logic For DTO to Entity
        Student student = StudentMapper.mappedStudentDtoToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);

        StudentDto savedStudentDto = StudentMapper.mappedStudentToStudentDto(savedStudent);

        return savedStudentDto;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByRollNo(int rollNo) {
        return studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException(String.format("Student With Roll No = %d Not Found", rollNo)));
    }

    @Override
    public List<Student> findAllByGender(String gender) {
        return studentRepository.findByGender(gender);
    }

    @Override
    public boolean deleteStudent(int rollNo) {
        // Step 1: Check if student with roll no exists or not
        Student existingStudent = studentRepository.findById(rollNo).orElse(null);

        // Step 2: If exists then only delete the student
        if (existingStudent != null) {
            // Delete
            // studentRepository.deleteById(rollNo);
            studentRepository.delete(existingStudent);

            return true;
        }
        return false;
    }

    @Override
    public Student updateStudent(int rollNo, Student student) {
        // Step 1: Check if student with roll no exists or not
        Student existingStudent = studentRepository.findById(rollNo).orElse(null);

        // Step 2: If exists then only update the student
        if (existingStudent != null) {
            // Update
            student.setRollNo(rollNo);
           
            Student updatedStudent = studentRepository.save(student);

            return updatedStudent;
        }
        return existingStudent;
    }

    /*
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    */
}
