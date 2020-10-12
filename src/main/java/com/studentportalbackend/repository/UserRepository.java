package com.studentportalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentportalbackend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByCollegeID(String collegeID);
}
