package com.studentportalbackend.service;

import com.studentportalbackend.model.User;

public interface ContributionLogService {

    void makeLoginContributionLog(User user, Integer contributionPoints);

}
