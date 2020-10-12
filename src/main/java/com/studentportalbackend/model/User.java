package com.studentportalbackend.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	@Column (name = "ID")
	private int id;
	
	@Column (name = "Full_Name")
	private String fullName;
	
	@Column (name = "College_ID")
	private String collegeID;
	
	@Column (name = "Email_ID")
	private String emailId;
	
	@Column (name = "Branch")
	private String branch;
	
	@Column (name = "Passout_Batch")
	private String passoutBatch;
	
	@Column (name = "Contact_Number")
	private String contactNumber;
	
	@Column (name = "Contribution_Points")
	private int contributionPoints;
	
	@Column (name = "Register_OTP")
	private String registerOTP;
	
	@Column (name = "Token")
	private String token;
	
	@Column (name = "Token_Expiry")
	private Timestamp tokenExpiry;
	
	@Column (name = "Password")
	private String password;
	
	@Column (name = "Verified")
	private boolean verified;
	
	@Column (name = "Account_Type")
	private String accountType;
	
	@Column (name = "Registered_At")
	private Timestamp registeredAt;
	
	@Column (name = "Last_Login")
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
	public String getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(String collegeID) {
		this.collegeID = collegeID;
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
	public String getRegisterOTP() {
		return registerOTP;
	}
	public void setRegisterOTP(String registerOTP) {
		this.registerOTP = registerOTP;
	}
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
