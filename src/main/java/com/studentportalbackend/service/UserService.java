package com.studentportalbackend.service;

import com.studentportalbackend.model.User;

public interface UserService {

    User login(String collegeID, String password);

    User registerNewUser(User user);

    User verifyNewUser(String collegeId, String receivedOtp);


}
