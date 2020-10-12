package com.studentportalbackend.util;

public class CollegeUtil {

    public static String getEmailFromCollegeId(String collegeId) {
        return (collegeId + "@mnit.ac.in");
    }

    public static String getPassoutBatchFromCollegeId(String collegeId) {
        return String.valueOf(Integer.parseInt(collegeId.substring(0, 4)) + 4) ;
    }

    public static String getBranchFromCollegeId(String collegeId) {
        return collegeId.substring(5, 7);
    }
}
