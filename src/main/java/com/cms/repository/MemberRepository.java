package com.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{
	MemberEntity findOneByEmail(String mail);
	//List<MemberEntity> findOneByEmail(String mail);
}
