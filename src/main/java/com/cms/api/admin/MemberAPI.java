package com.cms.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.MemberDTO;
import com.cms.repository.MemberRepository;
import com.cms.service.IMemberService;

@RestController(value = "apiOfMember")
public class MemberAPI {
	
	@Autowired
	private IMemberService imemberService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@PutMapping("/api-member")
	public MemberDTO updateMember(@RequestBody MemberDTO dto)
	{
		return imemberService.updateMem(dto);
	}
}
