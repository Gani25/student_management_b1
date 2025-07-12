package com.sprk.student_management.service.impl;

import com.sprk.student_management.dto.StudentDto;
import com.sprk.student_management.entity.Student;
import com.sprk.student_management.exception.EmailAlreadyExists;
import com.sprk.student_management.exception.StudentRollNoMismatch;
import com.sprk.student_management.exception.StudentRollNoNotFound;
import com.sprk.student_management.repository.StudentRepository;
import com.sprk.student_management.service.StudentService;
import com.sprk.student_management.util.StudentMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    // Field Injection
//    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        // Find if email already exisst then throw Exception -> Error Request Code
        if(studentRepository.existsByEmail(studentDto.getEmail())){
            String msg = "Email = "+studentDto.getEmail()+" already exists";
            throw new EmailAlreadyExists(msg, HttpStatus.CONFLICT);
        }
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
    public Student findStudentByRollNo(String rollNo) {
        // Check if rollNo contains only numbers
        if(!Pattern.matches("^[\\d]+$",rollNo))
        {

            throw new StudentRollNoMismatch("Enter Roll No In Integer Only", HttpStatus.BAD_REQUEST);
        }
        int rollNoInt = Integer.parseInt(rollNo);

        return studentRepository
                .findById(rollNoInt)
                .orElseThrow(() -> {
                    return new StudentRollNoNotFound(String.format("Student With Roll No = %d Not Found", rollNoInt), HttpStatus.NOT_FOUND);
                });
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
