package com.jb.javaTest.service.test;

import com.jb.javaTest.data.entity.AnswerKey;
import com.jb.javaTest.data.entity.Average;
import com.jb.javaTest.data.entity.ClassroomStatus;
import com.jb.javaTest.data.entity.Student;
import com.jb.javaTest.data.entity.Test;
import com.jb.javaTest.data.repo.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 16/09/2020
 */
@Service
public class TestServiceImpl implements TestService {
    private static final double APPROVED = 60.0;
    private final TestRepository testRepo;

    @Autowired
    public TestServiceImpl(TestRepository testRepo) {
        this.testRepo = testRepo;
    }


    @Override
    public Test createTest(char q1, char q2, char q3, char q4, char q5) {

        Test test = new Test();

        test.setQ1(q1);
        test.setQ2(q2);
        test.setQ3(q3);
        test.setQ4(q4);
        test.setQ5(q5);

        double grade = processGrade(test);
        test.setGrade(grade);

        return testRepo.save(test);
    }

    private double processGrade(Test test) {

        char[] responses = AnswerKey.responses();

        char[] studentResponses = { test.getQ1(), test.getQ2(), test.getQ3(), test.getQ4(), test.getQ5() };

        double points = 0;

        for (int i = 0; i < responses.length; ++i) {
            if (studentResponses[i] == responses[i]) {
                ++points;
            }
        }
        return points * 20;
    }

    @Override
    public Average getTotalAverage() {

        List<Test> tests = testRepo.findAll();

        double totalGrades = 0;

        for (Test t : tests) {
            totalGrades += t.getGrade();
        }

        Average totalAverage = new Average();

        totalAverage.setCourse("Java Full stack");
        totalAverage.setTitle("Classroom average.");
        totalAverage.setAverage(totalGrades / tests.size());

        return totalAverage;
    }

    @Override
    public Average getTotalAverageByAge(int age) {

        List<Test> tests = testRepo.findAllTestsByAge(age);

        double totalGrades = 0;

        for (Test t : tests) {
            totalGrades += t.getGrade();
        }

        Average average = new Average();
        average.setCourse("--Java FullStack--");
        average.setTitle("Average by Age");
        average.setAverage(totalGrades / tests.size());

        return average;
    }

    @Override
    public ClassroomStatus getClassroomStatus() {
        List<Test> tests = testRepo.findAll();

        int approved = 0;
        int failed = 0;

        for (Test test : tests) {

            if (test.getGrade() >= APPROVED) {
                ++approved;
            } else {
                ++failed;
            }
        }

        Student bestGrade = new Student();

        double swap = 0;

        for (Test test : tests) {
            if (test.getGrade() >= swap) {
                swap = test.getGrade();
            }
        }


        List<String> info = new ArrayList<>();

        for (Test t : tests) {
            StringBuilder sb = new StringBuilder();
            if (t.getGrade() == swap) {
                sb.append("name=");
                sb.append(t.getStudent().getFirstName());
                sb.append(" ");
                sb.append(t.getStudent().getLastName());
                sb.append(" ");
                sb.append("age=");
                sb.append(t.getStudent().getAge());
                info.add(sb.toString());
            }
        }

        ClassroomStatus status = new ClassroomStatus();

        status.setTitle("--Classroom Status--");
        status.setTotalApproved(approved);
        status.setTotalFailed(failed);
        status.setBestGrade(swap);
        status.setStudentsBestGradeInfo(info);

        return status;
    }
}
