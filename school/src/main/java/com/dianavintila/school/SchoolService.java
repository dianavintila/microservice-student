package com.dianavintila.school;

import com.dianavintila.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepo repo;

    private final StudentClient client;

    public void saveSchool(School school){
        repo.save(school);
    }

    public List<School> findAllSchools(){
        return repo.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repo.findById(schoolId)
                .orElse(
                        School.builder()
                            .name("NOT_FOUND")
                            .email("NOT_FOUND")
                            .build()
                );

        var students = client.findAllStudentsBySchool(schoolId); // find all students from the student microservice

        return FullSchoolResponse
                .builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
