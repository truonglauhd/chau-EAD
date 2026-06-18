package com.example.sis.service;

import com.example.sis.DTO.StudentScoreTableDTO;
import com.example.sis.DTO.ScoreViewDTO;
import com.example.sis.DTO.StudentViewDTO;
import com.example.sis.entity.Student;
import com.example.sis.entity.StudentScore;
import com.example.sis.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private String convertToLetterGrade(double grade) {

        if (grade >= 8.5) return "A";
        else if (grade >= 7.0) return "B";
        else if (grade >= 5.5) return "C";
        else if (grade >= 4.0) return "D";
        else return "F";
    }

    public List<StudentScoreTableDTO> getStudentTable() {

        List<Student> students = studentRepository.findAll();

        List<StudentScoreTableDTO> result = new ArrayList<>();

        for (Student st : students) {

            if (st.getStudentScores() == null) continue;

            for (StudentScore sc : st.getStudentScores()) {

                StudentScoreTableDTO dto = new StudentScoreTableDTO();

                dto.setId(st.getStudentId());
                dto.setStudentId(st.getStudentCode());
                dto.setStudentName(st.getFullName());

                dto.setSubjectName(sc.getSubject().getSubjectName());
                dto.setCredit(sc.getSubject().getCredit());

                double s1 = sc.getScore1() == null ? 0 : sc.getScore1().doubleValue();
                double s2 = sc.getScore2() == null ? 0 : sc.getScore2().doubleValue();

                dto.setScore1(s1);
                dto.setScore2(s2);

                double grade = s1 * 0.3 + s2 * 0.7;

                dto.setGrade(grade);
                dto.setLetterGrade(convertToLetterGrade(grade));

                result.add(dto);
            }
        }

        return result;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<StudentViewDTO> getAllStudents() {

        return studentRepository.findAll().stream().map(student -> {

            StudentViewDTO dto = new StudentViewDTO();

            dto.setStudentId(student.getStudentId());
            dto.setStudentCode(student.getStudentCode());
            dto.setFullName(student.getFullName());
            dto.setAddress(student.getAddress());

            List<ScoreViewDTO> scoreDTOs =
                    student.getStudentScores() == null
                            ? List.of()
                            : student.getStudentScores().stream().map(sc -> {

                        ScoreViewDTO s = new ScoreViewDTO();

                        // subject info
                        s.setSubjectName(sc.getSubject().getSubjectName());
                        s.setCredit(sc.getSubject().getCredit());

                        // scores
                        double score1 = sc.getScore1() == null ? 0 : sc.getScore1().doubleValue();
                        double score2 = sc.getScore2() == null ? 0 : sc.getScore2().doubleValue();

                        s.setScore1(sc.getScore1());
                        s.setScore2(sc.getScore2());

                        // numeric grade
                        double grade = score1 * 0.3 + score2 * 0.7;
                        s.setGrade(grade);

                        // letter grade (IMPORTANT PART YOU WERE MISSING)
                        s.setLetterGrade(convertToLetterGrade(grade));

                        return s;

                    }).toList();

            dto.setScores(scoreDTOs);

            return dto;

        }).toList();
    }
}