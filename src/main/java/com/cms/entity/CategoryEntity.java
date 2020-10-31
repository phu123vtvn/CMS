package com.cms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

	@Column(name = "title",columnDefinition = "nvarchar(255)")
	private String title;
	
	@OneToMany(mappedBy = "category")
	private List<ContentEntity> listcontent = new ArrayList<>();

	
	
	public List<ContentEntity> getListcontent() {
		return listcontent;
	}

	public void setListcontent(List<ContentEntity> listcontent) {
		this.listcontent = listcontent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
