package com.metanet.educationSystem.service.student;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.StudentMapper;
import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public MemberVO getMemberVO()  throws Exception{
		return studentMapper.getMemberVO();
		
	}

	@Override
	public List<HashMap<String, Object>> getClassList() throws Exception {
		
		return studentMapper.getClassList();
	}
	

}
