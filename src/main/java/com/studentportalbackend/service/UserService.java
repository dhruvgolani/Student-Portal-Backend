package com.studentportalbackend.service;

import com.studentportalbackend.dto.ResponseModel;
import com.studentportalbackend.model.User;

public interface UserService {

    ResponseModel login(String collegeID, String password);

    ResponseModel registerNewUser(User user);

    ResponseModel verifyNewUser(String collegeId, String receivedOtp);


}
