package com.metanet.educationSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;

@Repository
@Mapper
public interface TempMapper {

	public void insertNotice(NoticeVO noticeVO) throws Exception;

	public void insertNoticeFileList(List<NoticeFileVO> noticeFileList)throws Exception;

	public String getFileNO() throws Exception;

	public List<NoticeFileVO> getFile(String noticeNO) throws Exception;

	public NoticeFileVO downloadNoticeFile(NoticeFileVO noticeFileVO) throws Exception;
	
	

}
