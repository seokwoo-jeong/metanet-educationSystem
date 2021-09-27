package com.metanet.educationSystem.service.comment;

import java.util.HashMap;
import java.util.List;


public interface CommentsService {

	List<HashMap<String, Object>> getCommentsList(String noticeNO);

	int insertComments(String noticeNO, String memberNO, String commentContent);

	int deleteComments(String commentNO);

}
