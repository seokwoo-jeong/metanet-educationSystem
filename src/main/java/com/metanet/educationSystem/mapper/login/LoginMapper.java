package com.metanet.educationSystem.mapper.login;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.MemberVO;


@Repository
@Mapper
public interface LoginMapper {
	
	public MemberVO getPassword(MemberVO user);

	
}
