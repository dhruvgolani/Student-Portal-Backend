package com.studentportalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentportalbackend.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByCollegeId(String collegeId);
}
