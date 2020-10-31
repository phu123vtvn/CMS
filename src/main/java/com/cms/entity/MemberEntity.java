package com.cms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Biến 1 class thành Entity
@Table(name = "member")
public class MemberEntity extends BaseEntity{
	
	@Column(name = "firstname",columnDefinition = "nvarchar(255)")
	private String firstName;
	
	@Column(name = "lastname",columnDefinition = "nvarchar(255)")
	private String lastName;
	
	@Column(name = "username",nullable = false)
	private String userName;
	
	@Column(name = "password",nullable = false)
	private String passWord;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	@Column(name = "description",columnDefinition = "ntext")
	private String description;
	
	@OneToMany(mappedBy = "member")
	private List<ContentEntity> listcontent = new ArrayList<>();
	

	public List<ContentEntity> getListcontent() {
		return listcontent;
	}

	public void setListcontent(List<ContentEntity> listcontent) {
		this.listcontent = listcontent;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
