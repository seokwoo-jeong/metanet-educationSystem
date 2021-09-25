package com.metanet.educationSystem.service.professor;

import java.util.HashMap;
import java.util.List;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.ScoreVO;

public interface ProfessorService {
	
	public ClassVO getMemberVO() throws Exception;
	
	public ScoreVO inputScoreVO() throws Exception;

	public List<ClassVO> professorGetClassList(String professorNO) throws Exception;

	public List<HashMap<String, Object>> professorGetStudentList(String classNO) throws Exception;

	//public List<ScoreVO> inputStudentScore(ScoreVO scoreVO) throws Exception;
	void inputStudentScore(ScoreVO scoreVO) throws Exception;

	public List<ScoreVO> getstudentScore(String classNOO, String studentNO) throws Exception;
	
	

}
