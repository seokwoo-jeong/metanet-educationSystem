package com.metanet.educationSystem.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;

@Repository
@Mapper
public interface StudentMapper {

	public MemberVO getMemberVO() throws Exception;

	public List<HashMap<String, Object>> getClassList() throws Exception;

}
