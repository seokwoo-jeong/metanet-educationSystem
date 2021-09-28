package com.metanet.educationSystem.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;

@Repository
@Mapper
public interface AdminMapper {

//member Insert - student, professor
	public void memberInsert(MemberVO memberVO) throws Exception;
	public String checkMemberNO(String memberNO) throws Exception;
	
//class Insert
	public void classInsert(ClassVO classVO) throws Exception;
	public String checkClassNO(String classNO) throws Exception;

//notice Insert
	public void noticeInsert(NoticeVO noticeVO) throws Exception;
	public String checkNoticeNO(String noticeNO) throws Exception;
	public String getFileNO() throws Exception;
	public void insertNoticeFileList(List<NoticeFileVO> noticeFileList) throws Exception;
	public String getNoticeNO()throws Exception;
	

//classPage
	public List<HashMap<String, Object>> getClassList() throws Exception;
	public void adminDeleteClass(String classNO) throws Exception;



}
