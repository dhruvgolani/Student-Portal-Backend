package com.studentportalbackend.controller;

import java.util.HashMap;
import java.util.Map;

import com.studentportalbackend.dto.ResponseModel;
import com.studentportalbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.studentportalbackend.model.User;
import com.studentportalbackend.service.UserService;

@RequestMapping("/api/user")
@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/test")
	public String test(){
		return "Server is live";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseModel register(@RequestBody User user){
		if(userService.registerNewUser(user)){
			return new ResponseModel(true, "", "", new HashMap<>());
		}
		else{
			return new ResponseModel(false, "", "", new HashMap<>());
		}
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/verifyOtp")
    public ResponseModel verifyOtp(@RequestBody Map<String, String> req){
		String collegeId = req.get("collegeId");
		String receivedOtp = req.get("otp");
        User user = userService.verifyNewUser(collegeId, receivedOtp);
        if(user == null){
        	return new ResponseModel(false, "", "OTP incorrect. Please check your mail.", new HashMap<>());
		}
        else{
			Map<Object, Object> data = new HashMap<>();
			data.put("user", user);
			data.put("token", user.getToken());
			return new ResponseModel(true, "", "", data);
		}
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseModel login(@RequestBody Map<String, String> req){
		String collegeId = req.get("collegeId");
		String password = req.get("password");
        User user = userService.login(collegeId, password);
        if(user == null){
			return new ResponseModel(false, "", "Invalid Credentials", new HashMap<>());
		}
        else{
			Map<Object, Object> data = new HashMap<>();
			data.put("user", user);
			data.put("token", user.getToken());
			return new ResponseModel(true, "", "", data);
		}
    }
}
