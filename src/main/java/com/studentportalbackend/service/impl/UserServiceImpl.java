package com.studentportalbackend.service.impl;

import com.studentportalbackend.dto.ResponseModel;
import com.studentportalbackend.exception.UserAlreadyExistsException;
import com.studentportalbackend.exception.UserNotFoundException;
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
    public User login(String collegeID, String password) {
        User user = userRepository.findByCollegeId(collegeID);

        if(user == null || !user.getVerified()){
            throw new UserNotFoundException(collegeID);
        }
        else if(!user.getPassword().equals(password)) {
            return null;
        }
        else{
            String loginToken = GeneratorUtil.getToken();
            user.setToken(loginToken);
            userRepository.save(user);
            return user;
        }
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

    public Boolean registerNewUser(User user) {
        String collegeId = user.getCollegeId();
        User existingUser = userRepository.findByCollegeId(collegeId);

        if(existingUser != null){
            if(existingUser.getVerified()){
                throw new UserAlreadyExistsException(collegeId);
            }
            else userRepository.delete(existingUser);
        }
        populateNewUser(user);
        userRepository.save(user);
        return true;
    }

    @Override
    public User verifyNewUser(String collegeId, String receivedOtp) {
        User user = userRepository.findByCollegeId(collegeId);

        if(user == null) {
            throw new UserNotFoundException(collegeId);
        }
        else if(user.getVerified()){
            throw new UserAlreadyExistsException(collegeId);
        }
        else if(user.getRegisterOtp().equals(receivedOtp)) {
            contributionLogService.makeLoginContributionLog(user, INITIAL_CONTRIBUTION_POINTS);
            user.setContributionPoints(INITIAL_CONTRIBUTION_POINTS);
            user.setRegisterOtp(null);
            user.setVerified(true);

            String loginToken = GeneratorUtil.getToken();
            user.setToken(loginToken);
            userRepository.save(user);

            return user;
        }
        else{
            return null;
        }
    }
}
