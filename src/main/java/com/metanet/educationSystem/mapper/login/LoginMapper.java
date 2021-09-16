package com.metanet.educationSystem.mapper.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.MemberVO;


@Repository
@Mapper
public interface LoginMapper {	
	
	public MemberVO readMember(String memberNO);
	public List<String> readAuthority(String username);
	public MemberVO getPassword(MemberVO user);
}