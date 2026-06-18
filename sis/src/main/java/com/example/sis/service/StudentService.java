package com.example.sis.service;

import com.example.sis.DTO.StudentScoreTableDTO;
import com.example.sis.DTO.StudentViewDTO;
import com.example.sis.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<StudentViewDTO> getAllStudents();

    List<StudentScoreTableDTO> getStudentTable();
}