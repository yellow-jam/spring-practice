package com.example.practice.controller;

import com.example.practice.entity.Student;
import com.example.practice.repository.StudentRepository;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/api/student")
    public String student(Model model) { // html 리턴 예 @Controller
        model.addAttribute("attributeName", "값");

        return "index";  // src/resources/templates/index.html 반환
    }

    @GetMapping("/api/getStudent/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable long id) {

        Student student = studentService.getStudent(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(student);

    }

    @PostMapping("/api/insertStudent")
    public ResponseEntity<Object> insertStudent(@RequestBody Student student) {

        studentService.join(student);

        return ResponseEntity.status(HttpStatus.OK).body("추가됨");
    }
}
