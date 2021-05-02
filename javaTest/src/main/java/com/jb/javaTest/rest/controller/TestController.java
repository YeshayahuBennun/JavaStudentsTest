package com.jb.javaTest.rest.controller;

import com.jb.javaTest.data.entity.Average;
import com.jb.javaTest.data.entity.ClassroomStatus;
import com.jb.javaTest.data.entity.Test;
import com.jb.javaTest.service.student.StudentService;
import com.jb.javaTest.service.test.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 15/09/2020
 */
@RestController
@RequestMapping("/api")
public class TestController {
    private final TestService testService;
    private final StudentService studentService;

    @Autowired
    public TestController(TestService service, StudentService studentService) {
        this.testService = service;
        this.studentService = studentService;
    }

    @PostMapping("tests/add")
    public ResponseEntity<Test> testSubmit(@RequestParam String firstName, @RequestParam String lastName,
            @RequestParam int age, @RequestParam char q1, @RequestParam char q2, @RequestParam char q3,
            @RequestParam char q4, @RequestParam char q5) {

        Test test = testService.createTest(q1, q2, q3, q4, q5);
        studentService.createStudent(firstName, lastName, age, test);

        return ResponseEntity.ok(test);

    }

    @GetMapping("tests/get-average")
    public ResponseEntity<Average> getTotalAverage() {

        return ResponseEntity.ok(testService.getTotalAverage());
    }

    @GetMapping("tests/get-average-by-age")
    public ResponseEntity<Average> getTotalAverageByAge(@RequestParam int age) {

        return ResponseEntity.ok(testService.getTotalAverageByAge(age));
    }

    @GetMapping("tests/get-status")
    public ResponseEntity<ClassroomStatus> getClassroomStatus() {
        return ResponseEntity.ok(testService.getClassroomStatus());
    }
}
