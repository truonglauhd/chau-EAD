package com.example.sis.service;

import com.example.sis.entity.StudentScore;
import com.example.sis.repository.StudentScoreRepository;
import com.example.sis.service.StudentScoreService;
import org.springframework.stereotype.Service;

@Service
public class StudentScoreServiceImpl implements StudentScoreService {

    private final StudentScoreRepository scoreRepository;

    public StudentScoreServiceImpl(StudentScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public StudentScore addScore(StudentScore score) {
        return scoreRepository.save(score);
    }
}