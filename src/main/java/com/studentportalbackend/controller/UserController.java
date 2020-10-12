package com.studentportalbackend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studentportalbackend.model.User;
import com.studentportalbackend.service.UserService;

@RestController("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
    public boolean register(@RequestBody User user){
        return userService.registerUser(user);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/verifyOTP")
    public boolean verifyOTP(@RequestBody Map<String, String> req){
		String collegeID = req.get("collegeID");
		String receivedOTP = req.get("otp");
        return userService.verifyOTP(collegeID, receivedOTP);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
    public User login(@RequestBody Map<String, String> req){
		String collegeID = req.get("collegeID");
		String password = req.get("password");
        return userService.login(collegeID, password);
    }
}
