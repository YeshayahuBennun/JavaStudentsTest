package com.jb.javaTest.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 15/09/2020
 */
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double grade;
    private char q1;
    private char q2;
    private char q3;
    private char q4;
    private char q5;
    @OneToOne(mappedBy = "test", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Student student;

    public Test() {
        /*Empty*/
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public char getQ1() {
        return q1;
    }

    public void setQ1(char q1) {
        this.q1 = q1;
    }

    public char getQ2() {
        return q2;
    }

    public void setQ2(char q2) {
        this.q2 = q2;
    }

    public char getQ3() {
        return q3;
    }

    public void setQ3(char q3) {
        this.q3 = q3;
    }

    public char getQ4() {
        return q4;
    }

    public void setQ4(char q4) {
        this.q4 = q4;
    }

    public char getQ5() {
        return q5;
    }

    public void setQ5(char q5) {
        this.q5 = q5;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
