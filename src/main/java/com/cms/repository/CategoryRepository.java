package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByTitle(String code);
}
