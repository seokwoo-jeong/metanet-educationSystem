package com.metanet.educationSystem.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.ScoreVO;

@Repository
@Mapper
public interface ProfessorMapper {
	
	public List<ClassVO> professorGetClassList(String professorNO) throws Exception;
	
	public List<HashMap<String, Object>> professorGetStudentList(String classNO) throws Exception;

	//public List<ScoreVO> inputStudentScore(ScoreVO scoreVO) throws Exception;
	public void inputStudentScore(ScoreVO scoreVO) throws Exception;

	public List<ScoreVO> getstudentScore(@Param("classNO") String classNO, @Param("studentNO") String studentNO) throws Exception;


}
