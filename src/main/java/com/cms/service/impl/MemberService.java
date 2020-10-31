package com.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.converter.MemberConverter;
import com.cms.dto.MemberDTO;
import com.cms.entity.MemberEntity;
import com.cms.repository.MemberRepository;
import com.cms.service.IMemberService;

@Service
public class MemberService implements IMemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberConverter memberConverter;

	@Override
	@Transactional
	public void register(MemberDTO dto) {
		MemberEntity memberEntity=new MemberEntity();
		memberEntity=memberConverter.toEntity(dto);
		memberRepository.save(memberEntity);
	}
	@Override
	public boolean findOneByEmail(String email) {
		 MemberEntity entities= new MemberEntity();
		 entities = memberRepository.findOneByEmail(email);
		 if(entities==null)
		 {
			 return true;
		 }
		return false;
	}
	@Override
	public MemberDTO updateMem(MemberDTO dto) {
		MemberEntity entity=memberRepository.findOne(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPhone(dto.getPhone());
		entity.setDescription(dto.getDescription());
		return memberConverter.toDTO(memberRepository.save(entity));
	}
}
