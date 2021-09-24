package com.metanet.educationSystem.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.CommentsMapper;
import com.metanet.educationSystem.model.CommentsVO;


@Service
public class CommentsServiceImpl implements CommentsService{
	@Autowired
	private CommentsMapper commentsMapper;


	@Override
	public List<CommentsVO> getCommentsList(String noticeNO) {
		
		return commentsMapper.getCommentsList(noticeNO);
	}

}
