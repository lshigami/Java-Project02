package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@ManyToMany
//	@JoinTable(
//	  name = "user_role", 
//	  joinColumns = @JoinColumn(name = "userid",nullable=false), 
//	  inverseJoinColumns = @JoinColumn(name = "roleid"))
//	List<RoleEntity>roleEntities=new ArrayList<RoleEntity>();
//	
	@OneToMany(mappedBy = "userEntity",fetch = FetchType.LAZY)
	List<UserRoleEntity> userRoles = new ArrayList<>();
	
	
	
	
	
	
	public List<UserRoleEntity> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}

	@Column(name ="username")
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	@Column(name ="password")
	private String password;

	@Column(name ="fullname")
	private String fullname;

	@Column(name ="phone")
	private String phone;

	@Column(name ="email")
	private String email;

	@Column(name ="status")
	private String status;

	@Column(name ="createddate")
	private String createddate;

	@Column(name ="modifieddate")
	private String modifieddate;

	@Column(name ="createdby")
	private String createdby;

	@Column(name ="modifiedby")
	private String modifiedby;

}
