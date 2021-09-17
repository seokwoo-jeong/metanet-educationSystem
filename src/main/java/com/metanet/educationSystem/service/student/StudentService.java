package com.metanet.educationSystem.service.student;

import java.util.HashMap;
import java.util.List;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;

public interface StudentService {

	public MemberVO getMemberVO() throws Exception;

	public List<HashMap<String, Object>> getClassList() throws Exception;

}
