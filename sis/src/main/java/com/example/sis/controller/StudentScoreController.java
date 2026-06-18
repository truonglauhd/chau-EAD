package com.example.sis.controller;

import com.example.sis.entity.StudentScore;
import com.example.sis.service.StudentScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class StudentScoreController {

    private final StudentScoreService scoreService;

    public StudentScoreController(StudentScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/add")
    public StudentScore addScore(@RequestBody StudentScore score) {
        return scoreService.addScore(score);
    }
}