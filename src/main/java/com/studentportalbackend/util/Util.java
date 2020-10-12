package com.studentportalbackend.util;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class Util {

	final int OTP_LENGTH = 4;
	
	public String getEmailFromCollegeId(String collegeID) {
		return (collegeID + "@mnit.ac.in");
	}
	
	public String getPassoutBatchFromCollegeID(String collegeID) {
		return String.valueOf(Integer.valueOf(collegeID.substring(0, 4)) + 4) ;
	}
	
	public String getBranchFromCollegeID(String collegeID) {
		return collegeID.substring(5, 7);
	}
	
	public String getOTP() {
		String numbers = "0123456789"; 
	    String otp = "";
	    Random rand = new Random(); 
	    char[] digit = new char[OTP_LENGTH]; 
	    for (int i = 0; i<OTP_LENGTH; i++) 
	    { 
	        digit[i] = numbers.charAt(rand.nextInt(numbers.length())); 
	        otp = otp + digit[i];
	    } 

	    return otp; 
	}
}
