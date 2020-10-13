package com.studentportalbackend.repository;

import com.studentportalbackend.model.ContributionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionLogRepository  extends JpaRepository<ContributionLog, Integer> {
}
