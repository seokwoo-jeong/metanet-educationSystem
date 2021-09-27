package com.metanet.educationSystem.service.professor;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.ProfessorMapper;
import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.ScoreVO;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorMapper professorMapper;
	
	@Override
	public List<ClassVO> professorGetClassList(String professorNO) throws Exception {
	//System.out.println(professorMapper.professorGetClassList(professorNO).get(0).getClassNO());	
		System.out.println(professorMapper.professorGetClassList(professorNO)+"매퍼실행");
		System.out.println(professorNO+"넘버실행");
		
		return professorMapper.professorGetClassList(professorNO);
		
		
	}
	@Override
	public List<HashMap<String, Object>> professorGetStudentList(String classNO) throws Exception {
		System.out.println(professorMapper.professorGetStudentList(classNO).size() + "dsf");
		return professorMapper.professorGetStudentList(classNO);
	}


	@Override
	public ClassVO getMemberVO() throws Exception {
		return null;
	}
	@Override
	public ScoreVO inputScoreVO() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void inputStudentScore(ScoreVO scoreVO) throws Exception {
		professorMapper.inputStudentScore(scoreVO);

	}
	@Override
	public List<ScoreVO> getstudentScore(String classNOO, String studentNO) throws Exception {
		System.out.println(professorMapper.getstudentScore(classNOO,  studentNO)+"scoreVO불러오기 서비스임플 실행됨");
		// TODO Auto-generated method stub
		return professorMapper.getstudentScore(classNOO, studentNO);
	}

}
