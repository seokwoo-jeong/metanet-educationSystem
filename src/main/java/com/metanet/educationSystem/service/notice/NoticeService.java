package com.metanet.educationSystem.service.notice;

import java.util.List;

import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> getNoticeList() throws Exception;

	public NoticeVO getNoticedetail(String noticeNO) throws Exception;

	public List<NoticeFileVO> getNoticeFile(String noticeNO) throws Exception;

	public NoticeFileVO downloadNoticeFile(NoticeFileVO noticeFileVO) throws Exception;


}
