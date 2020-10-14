package com.studentportalbackend.service.impl;

import com.studentportalbackend.dto.ResponseModel;
import com.studentportalbackend.model.User;
import com.studentportalbackend.repository.UserRepository;
import com.studentportalbackend.service.ContributionLogService;
import com.studentportalbackend.service.UserService;
import com.studentportalbackend.util.CollegeUtil;
import com.studentportalbackend.util.GeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContributionLogService contributionLogService;

    @Value("${initial.contribution.points}")
    private Integer INITIAL_CONTRIBUTION_POINTS;


    @Override
    public ResponseModel login(String collegeID, String password) {
        User user = userRepository.findByCollegeId(collegeID);
        ResponseModel response = new ResponseModel();

        if(user == null) {
            response.setSuccess(false);
            response.setError("Sorry no user found with this College ID");
        }
        else if(!user.getVerified()){
            response.setSuccess(false);
            response.setError("Sorry user with this College ID is not yet verified");
        }
        else if(!user.getPassword().equals(password)) {
            response.setSuccess(false);
            response.setError("Invalid Credentials");
        }
        else{
            String loginToken = GeneratorUtil.getToken();
            user.setToken(loginToken);
            userRepository.save(user);

            Map<Object, Object> data = new HashMap<>();
            data.put("user", user);
            data.put("token", loginToken);
            response.setSuccess(true);
            response.setData(data);
        }
        return response;
    }


    // Function Associated with new user

    private void populateNewUser(User user){
        String collegeId = user.getCollegeId();
        user
                .setEmailId(CollegeUtil.getEmailFromCollegeId(collegeId))
                .setBranch(CollegeUtil.getBranchFromCollegeId(collegeId))
                .setPassoutBatch(CollegeUtil.getPassoutBatchFromCollegeId(collegeId))
                .setContributionPoints(0)
                .setRegisterOtp(GeneratorUtil.getOtp())
                .setVerified(false)
                .setAccountType("USER");
    }

    public ResponseModel registerNewUser(User user) {
        String collegeId = user.getCollegeId();
        User existingUser = userRepository.findByCollegeId(collegeId);
        ResponseModel response = new ResponseModel();

        if(existingUser != null){
            if(existingUser.getVerified()){
                // TODO : Throw Exception
                response.setSuccess(false);
                response.setError("User with this College Id already exists.");
                return response;
            }
            else userRepository.delete(existingUser);
        }
        populateNewUser(user);
        userRepository.save(user);
        response.setSuccess(true);
        return response;
    }

    @Override
    public ResponseModel verifyNewUser(String collegeId, String receivedOtp) {
        User user = userRepository.findByCollegeId(collegeId);
        ResponseModel response = new ResponseModel();

        if(user == null) {
            response.setSuccess(false);
            response.setError("Sorry user not found");
        }
        else if(user.getVerified()){
            response.setSuccess(false);
            response.setError("User already verified");
        }
        else if(user.getRegisterOtp().equals(receivedOtp)) {
            contributionLogService.makeLoginContributionLog(user, INITIAL_CONTRIBUTION_POINTS);
            user.setContributionPoints(INITIAL_CONTRIBUTION_POINTS);
            user.setRegisterOtp(null);
            user.setVerified(true);

            String loginToken = GeneratorUtil.getToken();
            user.setToken(loginToken);
            userRepository.save(user);

            Map<Object, Object> data = new HashMap<>();
            data.put("user", user);
            data.put("token", loginToken);
            response.setSuccess(true);
            response.setData(data);
        }
        else{
            response.setSuccess(false);
            response.setError("OTP incorrect. Please try again");
        }
        return response;
    }
}
