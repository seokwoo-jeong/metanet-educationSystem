package com.metanet.educationSystem.service.professor;

import java.util.HashMap;
import java.util.List;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;

public interface ProfessorService {
	
	public ClassVO getMemberVO() throws Exception;

	public List<ClassVO> professorGetClassList(String professorNO) throws Exception;
	
	

}
