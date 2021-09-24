package com.metanet.educationSystem.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.NoticeMapper;
import com.metanet.educationSystem.model.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public List<NoticeVO> getNoticeList() throws Exception {
		return noticeMapper.getNoticeList();
	}

	@Override
	public NoticeVO getNoticedetail(String noticeNO) {
		return noticeMapper.getNotice(noticeNO);
	}
	
	
}
