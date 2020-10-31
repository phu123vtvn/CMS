package com.cms.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cms.dto.MemberDTO;
import com.cms.entity.MemberEntity;

@Component
public class MemberConverter {

	public MemberEntity toEntity(MemberDTO dto) {
		MemberEntity result = new MemberEntity();
		result.setUserName(dto.getUserName());
		result.setEmail(dto.getEmail());
		result.setPassWord(encode(dto.getPassWord()));
		return result;
	}
	
	public MemberDTO toDTO(MemberEntity entity) {
		MemberDTO result = new MemberDTO();
		result.setId(entity.getId());
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setPhone(entity.getPhone());
		result.setDescription(entity.getDescription());
		result.setUserName(entity.getUserName());
		result.setEmail(entity.getEmail());
		result.setPassWord(encode(entity.getPassWord()));
		return result;
	}

	public String encode(String pass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12 
		String encodedPassword =encoder.encode(pass);
		return encodedPassword;
	}

}
