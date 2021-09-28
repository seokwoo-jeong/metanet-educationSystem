package com.metanet.educationSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.MemberVO;


@Repository
@Mapper
public interface LoginMapper {	
	
	public MemberVO readMember(String memberNO) throws UsernameNotFoundException;
	public List<String> readAuthority(String username) throws Exception;
	public MemberVO getPassword(MemberVO user) throws Exception;
}