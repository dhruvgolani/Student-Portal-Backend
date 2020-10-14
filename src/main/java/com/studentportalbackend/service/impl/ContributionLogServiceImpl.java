package com.studentportalbackend.service.impl;

import com.studentportalbackend.model.ContributionLog;
import com.studentportalbackend.model.User;
import com.studentportalbackend.repository.ContributionLogRepository;
import com.studentportalbackend.service.ContributionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContributionLogServiceImpl implements ContributionLogService {

    @Autowired
    ContributionLogRepository contributionLogRepository;

    @Override
    public void makeLoginContributionLog(User user, Integer contributionPoints) {
        ContributionLog contributionLog = new ContributionLog();
        contributionLog
                .setContributionPoints(contributionPoints)
                .setUserId(user.getUserId())
                .setComments("Initial Login Reward")
                .setContributionType("LOGIN");

        contributionLogRepository.save(contributionLog);
    }
}
