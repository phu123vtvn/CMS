package com.cms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "createdate")
	@CreatedDate
	private Date createDate;
	
	@Column(name = "updatetime")
	@LastModifiedDate
	private Date updateTime;

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Long getId() {
		return id;
	}
	
}
