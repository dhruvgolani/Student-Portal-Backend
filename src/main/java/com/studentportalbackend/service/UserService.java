package com.studentportalbackend.service;

import com.studentportalbackend.dto.ResponseModel;
import com.studentportalbackend.model.User;

public interface UserService {

    User login(String collegeID, String password);

    Boolean registerNewUser(User user);

    User verifyNewUser(String collegeId, String receivedOtp);


}
