package com.metanet.educationSystem.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.ScoreVO;

@Repository
@Mapper
public interface StudentMapper {
	public List<HashMap<String, Object>> getClassList() throws Exception;

	public int checkClassApply(HashMap<String, Object> classNOAndMemberNO) throws Exception;

	public int getClassPersonnel(String classNO) throws Exception;

	public int getCurrentClassPersonnel(String classNO) throws Exception;

	public int getCurrentStudentCredit(String memberNO) throws Exception;

	public int getClassCredit(String classNO) throws Exception;

	public List<HashMap<String, Object>> getStudentClassList(String memberNO) throws Exception;

	public void studentApplyClass(HashMap<String, Object> classNOAndMemberNO) throws Exception;

	public void studentDeleteClass(HashMap<String, Object> classNOAndMemberNO) throws Exception;

	public HashMap<String, Object> getClassInfo(String classNO) throws Exception;

	public List<HashMap<String, Object>> getStudentScoreList(String memberNO) throws Exception; 

}
