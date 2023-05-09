package com.arjunshaji.awt.demo.controller;

import com.arjunshaji.awt.demo.entity.Student;
import com.arjunshaji.awt.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Object saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
