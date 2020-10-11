package com.studentportalbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentportalbackend.model.User;
import com.studentportalbackend.repository.UserRepository;
import com.studentportalbackend.util.Util;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Util util;
	
	
	public boolean registerUser(User user) {
		String collegeID = user.getCollegeID();
		
		User existingUser = userRepository.findByCollegeID(collegeID);
		if(existingUser != null && existingUser.isVerified()) {
			return false;
		}
		if(existingUser != null && ! existingUser.isVerified()) {
			userRepository.deleteById(existingUser.getId());
		}
		
		user.setEmailId(util.getEmailFromCollegeId(collegeID));
		user.setBranch(util.getBranchFromCollegeID(collegeID));
		user.setPassoutBatch(util.getPassoutBatchFromCollegeID(collegeID));
		user.setContributionPoints(50);
		user.setRegisterOTP(util.getOTP());
		user.setToken(null);
		user.setTokenExpiry(null);
		user.setVerified(false);
		user.setAccountType("user");
		user.setRegisteredAt(null);
		user.setLastLogin(null);
		userRepository.save(user);
		
		return true;
	}
	
	public boolean verifyOTP(String collegeID, String receivedOTP) {
		User user = userRepository.findByCollegeID(collegeID);
		if(user == null) {
			return false;
		}
		if(user.getRegisterOTP().equals(receivedOTP)) {
			user.setRegisterOTP(null);
			user.setVerified(true);
			userRepository.save(user);
			return true;
		}
		return false;
	}
	
	public User login(String collegeID, String password) {
		User user = userRepository.findByCollegeID(collegeID);
		if(user == null) {
			return null;
		}
		if(user.isVerified() && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
	
}
