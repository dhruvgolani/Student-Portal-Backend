package com.studentportalbackend.model;

import com.studentportalbackend.model.enums.AccountTypeEnum;

import java.util.Date;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue
	@Column (name = "user_id")
	private Integer userId;
	
	@Column (name = "full_name" ,nullable = false)
	private String fullName;
	
	@Column (name = "college_id",nullable = false, updatable = false, unique = true)
	private String collegeId;
	
	@Column (name = "email_id",nullable = false)
	private String emailId;
	
	@Column (name = "branch")
	private String branch;
	
	@Column (name = "passout_batch")
	private String passoutBatch;
	
	@Column (name = "contact_number")
	private String contactNumber;
	
	@Column (name = "contribution_points")
	private Integer contributionPoints;
	
	@Column (name = "register_otp")
	private String registerOtp;
	
	@Column (name = "token")
	private String token;
	
	@Column (name = "token_expiry")
	private Date tokenExpiry;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "verified")
	private Boolean verified;

	@Enumerated(EnumType.STRING)
	@Column (name = "account_type" , nullable = false)
	private AccountTypeEnum accountType;
	
	@Column (name = "created_at" , nullable = false , updatable = false)
	private Date createdAt;
	
	@Column (name = "last_login")
	private Date lastLogin;

	@PrePersist
	void prePersist(){
		this.createdAt = new Date();
		this.lastLogin = new Date();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getPassoutBatch() {
		return passoutBatch;
	}

	public void setPassoutBatch(String passoutBatch) {
		this.passoutBatch = passoutBatch;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getContributionPoints() {
		return contributionPoints;
	}

	public void setContributionPoints(Integer contributionPoints) {
		this.contributionPoints = contributionPoints;
	}

	public String getRegisterOtp() {
		return registerOtp;
	}

	public void setRegisterOtp(String registerOtp) {
		this.registerOtp = registerOtp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenExpiry() {
		return tokenExpiry;
	}

	public void setTokenExpiry(Date tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = AccountTypeEnum.parse(accountType);
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
}
