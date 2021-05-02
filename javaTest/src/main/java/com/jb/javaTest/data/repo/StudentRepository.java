package com.jb.javaTest.data.repo;

import com.jb.javaTest.data.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 16/09/2020
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
