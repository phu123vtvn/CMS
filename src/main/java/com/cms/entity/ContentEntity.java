package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;

@Entity
@Table(name = "content")
public class ContentEntity extends BaseEntity{

	@Column(name = "title",columnDefinition = "ntext",nullable = false)
	private String title;
	
	@Column(name = "brief", columnDefinition = "ntext",nullable = false)
	private String brief;
	
	@Column(name = "content", columnDefinition = "ntext",nullable = false)
	private String content;
	
	@Column(name = "sort", columnDefinition = "nvarchar(255)")
	private String sort;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorid")
    private MemberEntity member;

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	
	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
}
