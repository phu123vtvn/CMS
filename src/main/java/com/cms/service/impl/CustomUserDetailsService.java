package com.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cms.dto.MyUser;
import com.cms.entity.MemberEntity;
import com.cms.repository.MemberRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MemberEntity memberEntity = memberRepository.findOneByEmail(email);
		if (memberEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		// put thông tin vào security để duy trì thông tin khi user login vào hệ thống
		MyUser user = new MyUser(memberEntity.getUserName(), memberEntity.getPassWord(), true, true, true, true,
				authorities);
		convert(user, memberEntity);
		return user;
	}

	public void convert(MyUser user,MemberEntity memberEntity)
	{
		user.setEmail(memberEntity.getEmail());
		user.setUsername(memberEntity.getUserName());
		user.setDesciption(memberEntity.getDescription());
		user.setFirstname(memberEntity.getFirstName());
		user.setLastname(memberEntity.getLastName());
		user.setPhone(memberEntity.getPhone());
		user.setId(memberEntity.getId());
	}
}
