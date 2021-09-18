package com.metanet.educationSystem.service.student;

import java.util.HashMap;
import java.util.List;

import com.metanet.educationSystem.model.MemberVO;

public interface StudentService {

	public MemberVO getMemberVO() throws Exception;

	public List<HashMap<String, Object>> getClassList() throws Exception;
	
	public List<HashMap<String, Object>> getStudentClassList(String memberNO) throws Exception;
	
	public boolean checkClassApply(String classNO, String memberNO) throws Exception;

	public boolean checkClassPersonnel(String classNO) throws Exception;

	public boolean checkClassCredit(String classNO, String memberNO) throws Exception;

	public void studentApplyClass(String classNO, String memberNO) throws Exception;

	public void studentDeleteClass(String classNO, String memberNO) throws Exception;

	public int getCurrentStudentCredit(String memberNO) throws Exception;

	

	


}
