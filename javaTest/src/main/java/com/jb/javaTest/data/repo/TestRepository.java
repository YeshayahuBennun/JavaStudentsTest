package com.jb.javaTest.data.repo;

import com.jb.javaTest.data.entity.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 15/09/2020
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    /**
     * Finds all test by a specific age.
     *
     * @param age
     *
     * @return
     */
    @Query("select t from Test t where t.student.age=:age")
    List<Test> findAllTestsByAge(int age);
}
