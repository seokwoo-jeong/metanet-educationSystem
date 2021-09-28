package com.metanet.educationSystem.service.comment;

import java.util.HashMap;
import java.util.List;

public interface CommentsService {

	public List<HashMap<String, Object>> getCommentsList(String noticeNO) throws Exception;

	public int insertComments(String noticeNO, String memberNO, String commentContent) throws Exception;

	public int deleteComments(String commentNO) throws Exception;

}
