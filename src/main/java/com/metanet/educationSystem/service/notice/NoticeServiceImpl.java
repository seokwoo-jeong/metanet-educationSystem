package com.metanet.educationSystem.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.NoticeMapper;
import com.metanet.educationSystem.model.NoticeFileVO;
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
	public NoticeVO getNoticedetail(String noticeNO) throws Exception{
		return noticeMapper.getNotice(noticeNO);
	}
	
	@Override
	public int deleteNotice(String noticeNO) {
		return this.noticeMapper.deleteNotice(noticeNO);
	}
	

	@Override
	public List<NoticeFileVO> getNoticeFile(String noticeNO) throws Exception {
		return this.noticeMapper.getNoticeFile(noticeNO);
	}
	
	@Override
	public NoticeFileVO downloadNoticeFile(NoticeFileVO noticeFileVO) throws Exception {
		return this.noticeMapper.downloadNoticeFile(noticeFileVO);
	}


	
}
