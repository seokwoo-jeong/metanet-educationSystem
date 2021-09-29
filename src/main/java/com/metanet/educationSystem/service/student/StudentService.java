package com.metanet.educationSystem.service.student;

import java.util.HashMap;
import java.util.List;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.ScoreVO;

public interface StudentService {

	public List<HashMap<String, Object>> getClassList() throws Exception;
	
	public List<HashMap<String, Object>> getStudentClassList(String memberNO) throws Exception;
	
	public boolean checkClassApply(String classNO, String memberNO) throws Exception;

	public boolean checkClassPersonnel(String classNO) throws Exception;

	public boolean checkClassCredit(String classNO, String memberNO) throws Exception;

	public void studentApplyClass(String classNO, String memberNO) throws Exception;

	public void studentDeleteClass(String classNO, String memberNO) throws Exception;

	public int getCurrentStudentCredit(String memberNO) throws Exception;

	public HashMap<String, Object> getClassInfo(String classNO) throws Exception;

	public List<HashMap<String, Object>> getStudentScoreList(String memberNO) throws Exception;

	public HashMap<String, Object> getStudentInfo(String memberNO);

	

	


}
