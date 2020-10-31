package com.cms.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.MemberDTO;
import com.cms.service.IMemberService;

@RestController(value = "registerAPIofWeb")
public class RegisterAPI {

	@Autowired
	private IMemberService imemberService;
	
	@PostMapping("/api-register")
	public void registerMember(@RequestBody MemberDTO dto)
	{
		if(imemberService.findOneByEmail(dto.getEmail()))
		{
			imemberService.register(dto);
		}
		else
		{
			MemberDTO dtoo=null;
			imemberService.register(dtoo);
		}
	}
}
