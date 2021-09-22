package com.metanet.educationSystem.service.student;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.StudentMapper;
import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.ScoreVO;
import com.metanet.educationSystem.constant.Constant;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;


	@Override
	public List<HashMap<String, Object>> getClassList() throws Exception {
		
		return studentMapper.getClassList();
	}
	
	@Override
	public List<HashMap<String, Object>> getStudentClassList(String memberNO) throws Exception {
		
		return this.studentMapper.getStudentClassList(memberNO);
	}
	
	@Override
	public boolean checkClassApply(String classNO, String memberNO) throws Exception {
		HashMap<String,Object> classNOAndMemberNO = new HashMap<>();
		classNOAndMemberNO.put("classNO", classNO);
		classNOAndMemberNO.put("memberNO", memberNO);
		if(this.studentMapper.checkClassApply(classNOAndMemberNO) == 0) {
			System.out.println("checkClassApply: checkDoneClassApply");
			return true;
		}
		System.out.println("student Already apply for this Class");
		return false;
	}

	@Override
	public boolean checkClassPersonnel(String classNO) throws Exception {
		System.out.println("--------------------------");
		//해당 과목 총 인원 data get
		int classPersonnel = this.studentMapper.getClassPersonnel(classNO);
		System.out.println("checkClassPersonnel: class Personnel: " + classPersonnel);
		//해당 과목 현재 인원 data get
		int currentClassPersonnel = this.studentMapper.getCurrentClassPersonnel(classNO);
		
		System.out.println("checkClassPersonnel: current class Personnel: " + currentClassPersonnel);
		
		if (currentClassPersonnel < classPersonnel) {
			System.out.println("checkClassPersonnel: checkDoneClassPersonnel");
			return true;
		}
		System.out.println("Class is Full");
		return false;
	}

	@Override
	public boolean checkClassCredit(String classNO, String memberNO) throws Exception {
		System.out.println("--------------------------");
		// 현재 학생 총 몇학점 신청했는지 get
		int currentStudentCredit = this.studentMapper.getCurrentStudentCredit(memberNO);
		
		// 신청원하는 수업 학점 get
		int classCredit = this.studentMapper.getClassCredit(classNO);
		System.out.println("currentStudentCredit + classCredit: " + currentStudentCredit);
		// 현재 학생 학점 + 신청원하는 수업 학점 < 18학점
		if (currentStudentCredit + classCredit <= Constant.studentAllowCredit){
			System.out.println("checkClassCredit: checkDoneClassCredit");
			return true;
		}
		System.out.println("student credit is Full");
		return false;
	}

	@Override
	public void studentApplyClass(String classNO, String memberNO) throws Exception {
		HashMap<String,Object> classNOAndMemberNO = new HashMap<>();
		classNOAndMemberNO.put("classNO", classNO);
		classNOAndMemberNO.put("memberNO", memberNO);
		this.studentMapper.studentApplyClass(classNOAndMemberNO);
		
	}

	@Override
	public void studentDeleteClass(String classNO, String memberNO) throws Exception {
		HashMap<String,Object> classNOAndMemberNO = new HashMap<>();
		classNOAndMemberNO.put("classNO", classNO);
		classNOAndMemberNO.put("memberNO", memberNO);
		this.studentMapper.studentDeleteClass(classNOAndMemberNO);
		
	}

	@Override
	public int getCurrentStudentCredit(String memberNO) throws Exception {
		
		return this.studentMapper.getCurrentStudentCredit(memberNO);
	}

	@Override
	public HashMap<String, Object> getClassInfo(String classNO) throws Exception {
		return this.studentMapper.getClassInfo(classNO);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HashMap<String, Object>> getStudentScoreList(String memberNO) throws Exception {
		return this.studentMapper.getStudentScoreList(memberNO);
	}

	

	
	

}
