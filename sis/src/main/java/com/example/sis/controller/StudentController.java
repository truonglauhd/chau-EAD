package com.example.sis.controller;

import com.example.sis.DTO.StudentScoreTableDTO;
import com.example.sis.DTO.StudentViewDTO;
import com.example.sis.entity.Student;
import com.example.sis.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/all")
    public List<StudentViewDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/table")
    public List<StudentScoreTableDTO> getTable() {
        return studentService.getStudentTable();
    }
}