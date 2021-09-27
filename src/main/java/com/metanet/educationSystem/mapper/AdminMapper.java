package com.metanet.educationSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;

// @Repository의 역할 : mapper.xml 에서 해당 이름의 쿼리문을 실행할 수 있도록 함
@Repository
@Mapper
public interface AdminMapper {

//member Insert - student, professor
	void memberInsert(MemberVO memberVO) throws Exception;
	String checkMemberNO(String memberNO) throws Exception;
	
//class Insert
	void classInsert(ClassVO classVO) throws Exception;
	String checkClassNO(String classNO) throws Exception;

//notice Insert
	public void noticeInsert(NoticeVO noticeVO) throws Exception;
	public String checkNoticeNO(String noticeNO) throws Exception;
	public String getFileNO() throws Exception;
	public void insertNoticeFileList(List<NoticeFileVO> noticeFileList) throws Exception;

}
