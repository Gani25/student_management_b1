package com.sprk.student_management.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentDto {

    private int rollNo;

    private String firstName;

    private String lastName;

    private int age;

    private String gender;

    private String address;

    private double percentage;
}
