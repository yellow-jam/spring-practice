package com.example.practice.service;

import com.example.practice.entity.Student;
import com.example.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudent(long id) {
        return studentRepository.findById(id);
    }

    public void join(Student student) {
        studentRepository.save(student);
    }


}
