package com.example.sis.DTO;

import java.util.List;

public class StudentViewDTO {

    private Integer studentId;
    private String studentCode;
    private String fullName;
    private String address;

    private List<com.example.sis.DTO.ScoreViewDTO> scores;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public List<ScoreViewDTO> getScores() {
        return scores;
    }

    public void setScores(List<ScoreViewDTO> scores) {
        this.scores = scores;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}