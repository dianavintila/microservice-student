package com.dianavintila.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo repo;

    public void saveStudent(Student student){
        repo.save(student);
    }

    public List<Student> findAllStudents(){
        return repo.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return repo.findAllBySchoolId(schoolId);
    }
}
