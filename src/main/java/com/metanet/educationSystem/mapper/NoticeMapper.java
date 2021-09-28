package com.metanet.educationSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;

@Repository
@Mapper
public interface NoticeMapper {

	public List<NoticeVO> getNoticeList() throws Exception;

	public NoticeVO getNotice(String noticeNO) throws Exception;

	public List<NoticeFileVO> getNoticeFile(String noticeNO) throws Exception;

	public NoticeFileVO downloadNoticeFile(NoticeFileVO noticeFileVO) throws Exception;

	public int deleteNotice(String noticeNO) throws Exception;

}
