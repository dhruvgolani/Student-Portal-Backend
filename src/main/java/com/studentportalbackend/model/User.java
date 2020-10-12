package com.studentportalbackend.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column (name = "id")
	private Integer id;
	
	@Column (name = "full_name")
	private String fullName;
	
	@Column (name = "college_id")
	private String collegeId;
	
	@Column (name = "email_id")
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
	private Timestamp tokenExpiry;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "verified")
	private Boolean verified;
	
	@Column (name = "account_type")
	private String accountType;
	
	@Column (name = "registered_at")
	private Timestamp registeredAt;
	
	@Column (name = "last_login")
	private Timestamp lastLogin;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setCollegeId(String collegeID) {
		this.collegeId = collegeID;
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
	public int getContributionPoints() {
		return contributionPoints;
	}
	public void setContributionPoints(int contributionPoints) {
		this.contributionPoints = contributionPoints;
	}
	public String getRegisterOtp() {
		return registerOtp;
	}
	public void setRegisterOtp(String registerOtp) { this.registerOtp = registerOtp; }
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getTokenExpiry() {
		return tokenExpiry;
	}
	public void setTokenExpiry(Timestamp tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Timestamp getRegisteredAt() {
		return registeredAt;
	}
	public void setRegisteredAt(Timestamp registeredAt) {
		this.registeredAt = registeredAt;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
}
