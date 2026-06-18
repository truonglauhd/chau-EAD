package com.example.sis.controller;

import com.example.sis.entity.Subject;
import com.example.sis.service.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/add")
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject);
    }
}