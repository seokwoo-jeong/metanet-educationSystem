package com.metanet.educationSystem.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.ClassVO;

@Repository
@Mapper
public interface ProfessorMapper {
	
	public List<ClassVO> professorGetClassList(String professorNO) throws Exception;
	
	public List<HashMap<String, Object>> professorGetStudentList(String classNO) throws Exception;


}
