package com.arjunshaji.awt.demo.service;

import com.arjunshaji.awt.demo.entity.Student;
import com.arjunshaji.awt.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Object saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }
}
