package com.jb.javaTest.service.student;

import com.jb.javaTest.data.entity.Student;
import com.jb.javaTest.data.entity.Test;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 16/09/2020
 */
public interface StudentService {
    /**
     * Creates a student.
     *
     * @param firstName
     * @param lastName
     * @param age
     * @param test
     *
     * @return
     */
    Student createStudent(String firstName, String lastName, int age, Test test);
}
