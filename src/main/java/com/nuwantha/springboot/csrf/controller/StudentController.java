package com.nuwantha.springboot.csrf.controller;

import com.nuwantha.springboot.csrf.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    List<Student> studentList = new ArrayList<>(List.of(
            new Student(1, "Navin1", 68),
            new Student(2, "Navin2", 70)
    ));

    @GetMapping(value = "/getStudents")
    public List<Student> getStudents() {
        return studentList;
    }

    @PostMapping(value = "/addStudent")
    public Student addStudent(@RequestBody Student student) {
        studentList.add(student);
        return student;
    }

    @GetMapping(value = "/getCSRFToken")
    public CsrfToken getCSRFToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
