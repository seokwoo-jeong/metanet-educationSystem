package com.metanet.educationSystem.service.notice;

import java.util.List;

import com.metanet.educationSystem.model.NoticeVO;

public interface NoticeService {
	List<NoticeVO> getNoticeList() throws Exception;

	NoticeVO getNoticedetail(String noticeNO);

}
