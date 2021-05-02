package com.jb.javaTest.service.student;

import com.jb.javaTest.data.entity.Student;
import com.jb.javaTest.data.entity.Test;
import com.jb.javaTest.data.repo.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 16/09/2020
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepo) {this.studentRepo = studentRepo;}

    @Override
    public Student createStudent(String firstName, String lastName, int age, Test test) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setTest(test);

        return studentRepo.save(student);
    }
}
