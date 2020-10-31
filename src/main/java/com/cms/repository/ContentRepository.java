package com.cms.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.ContentEntity;

public interface ContentRepository extends JpaRepository<ContentEntity, Long>{

	List<ContentEntity> findAllBySortOrSort(Pageable pageable, String string, String string2);
	Long countBySortOrSort(String s1,String s2);

}
