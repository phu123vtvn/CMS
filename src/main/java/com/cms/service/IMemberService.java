package com.cms.service;

import com.cms.dto.MemberDTO;

public interface IMemberService {
	void register(MemberDTO dto);
	boolean findOneByEmail(String email);
	MemberDTO updateMem(MemberDTO dto);
}
