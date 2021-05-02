package com.jb.javaTest.service.test;

import com.jb.javaTest.data.entity.Average;
import com.jb.javaTest.data.entity.ClassroomStatus;
import com.jb.javaTest.data.entity.Test;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 16/09/2020
 */
public interface TestService {
    /**
     * Creates a test.
     *
     * @param q1
     * @param q2
     * @param q3
     * @param q4
     * @param q5
     *
     * @return
     */
    Test createTest(char q1, char q2, char q3, char q4, char q5);

    /**
     * Gets the total average.
     *
     * @return
     */
    Average getTotalAverage();

    /**
     * Gets total average by a specific age.
     *
     * @param age
     *
     * @return
     */
    Average getTotalAverageByAge(int age);

    /**
     * Gets the classroom status.
     *
     * @return
     */
    ClassroomStatus getClassroomStatus();
}
