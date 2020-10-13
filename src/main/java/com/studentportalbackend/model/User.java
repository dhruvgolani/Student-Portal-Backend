package com.studentportalbackend.model;

import com.studentportalbackend.model.enums.AccountTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Users")
@Accessors(chain = true)
@Data
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
	public void prePersist(){
		this.createdAt = new Date();
		this.lastLogin = new Date();
	}

	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = AccountTypeEnum.parse(accountType);
	}

}
