package com.studentportalbackend.service.impl;

import com.studentportalbackend.model.User;
import com.studentportalbackend.repository.UserRepository;
import com.studentportalbackend.service.UserService;
import com.studentportalbackend.util.CollegeUtil;
import com.studentportalbackend.util.GeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Value("${initial.contribution.points}")
    private Integer INITIAL_CONTRIBUTION_POINTS;


    @Override
    public User login(String collegeID, String password) {
        User user = userRepository.findByCollegeId(collegeID);
        if(user == null) {
            return null;
        }
        if(user.isVerified() && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


    // Function Associated with new user

    private void populateNewUser(User user){
        String collegeId = user.getCollegeId();
        user.setEmailId(CollegeUtil.getEmailFromCollegeId(collegeId));
        user.setBranch(CollegeUtil.getBranchFromCollegeId(collegeId));
        user.setPassoutBatch(CollegeUtil.getPassoutBatchFromCollegeId(collegeId));
        user.setContributionPoints(INITIAL_CONTRIBUTION_POINTS);
        user.setRegisterOtp(GeneratorUtil.getOtp());
        user.setToken(null);
        user.setTokenExpiry(null);
        user.setVerified(false);
        user.setAccountType("user");
        user.setRegisteredAt(null);
        user.setLastLogin(null);
    }

    public User registerNewUser(User user) {
        String collegeId = user.getCollegeId();
        User existingUser = userRepository.findByCollegeId(collegeId);
        if(existingUser != null){
            if(existingUser.isVerified()){
                // TODO : Throw Exception
                return null;
            }
            else userRepository.delete(existingUser);
        }
        populateNewUser(user);
        return userRepository.save(user);
    }

    @Override
    public User verifyNewUser(String collegeId, String receivedOtp) {
        User user = userRepository.findByCollegeId(collegeId);
        if(user == null) {
            return null;
        }
        if(user.getRegisterOtp().equals(receivedOtp)) {
            user.setRegisterOtp(null);
            user.setVerified(true);
            return userRepository.save(user);
        }
        return null;
    }
}
