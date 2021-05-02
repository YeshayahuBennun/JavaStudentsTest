package com.jb.javaTest.data.entity;

import java.util.List;

/**
 * This file is a part of javaTest project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 16/09/2020
 */
public class ClassroomStatus {
    private String title;
    private int totalApproved;
    private int totalFailed;
    private double bestGrade;
    private List<String> studentsBestGradeInfo;

    public ClassroomStatus() {
        /*Empty*/
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalApproved() {
        return totalApproved;
    }

    public void setTotalApproved(int totalApproved) {
        this.totalApproved = totalApproved;
    }

    public int getTotalFailed() {
        return totalFailed;
    }

    public void setTotalFailed(int totalFailed) {
        this.totalFailed = totalFailed;
    }

    public double getBestGrade() {
        return bestGrade;
    }

    public void setBestGrade(double bestGrade) {
        this.bestGrade = bestGrade;
    }

    public List<String> getStudentsBestGradeInfo() {
        return studentsBestGradeInfo;
    }

    public void setStudentsBestGradeInfo(List<String> studentsBestGradeInfo) {
        this.studentsBestGradeInfo = studentsBestGradeInfo;
    }
}
