package com.metanet.educationSystem.service.comment;

import java.util.List;

import com.metanet.educationSystem.model.CommentsVO;

public interface CommentsService {

	List<CommentsVO> getCommentsList(String noticeNO);

}
