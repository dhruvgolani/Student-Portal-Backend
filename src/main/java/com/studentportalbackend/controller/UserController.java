package com.studentportalbackend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.studentportalbackend.model.User;
import com.studentportalbackend.service.UserService;

@RestController("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/test")
	public String test(){
		return "Server is live";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
    public User register(@RequestBody User user){
	    return userService.registerNewUser(user);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/verifyOtp")
    public User verifyOtp(@RequestBody Map<String, String> req){
		String collegeID = req.get("collegeID");
		String receivedOTP = req.get("otp");
        return userService.verifyNewUser(collegeID, receivedOTP);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
    public User login(@RequestBody Map<String, String> req){
		String collegeId = req.get("collegeId");
		String password = req.get("password");
        return userService.login(collegeId, password);
    }
}
