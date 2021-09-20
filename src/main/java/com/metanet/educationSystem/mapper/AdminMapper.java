package com.metanet.educationSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.MemberVO;

// @Repository의 역할 : mapper.xml 에서 해당 이름의 쿼리문을 실행할 수 있도록 함
@Repository
@Mapper
public interface AdminMapper {

	void memberInsert(MemberVO memberVO);

}
