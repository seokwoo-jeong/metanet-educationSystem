package com.metanet.educationSystem.service.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.CommentsMapper;

@Service
public class CommentsServiceImpl implements CommentsService {
	@Autowired
	private CommentsMapper commentsMapper;

	@Override
	public List<HashMap<String, Object>> getCommentsList(String noticeNO) throws Exception{
		List<HashMap<String, Object>> parseData = commentsMapper.getCommentsList(noticeNO);
		for (HashMap<String, Object> entry : parseData) {
			Date commentDate = (Date) entry.get("commentDate");
			String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(commentDate);
			entry.put("commentDate", formattedDate);
			System.out.println(entry);
		}
		return parseData;
	}

	@Override
	public int insertComments(String noticeNO, String memberNO, String commentContent) throws Exception{
		return commentsMapper.insertComments(noticeNO, memberNO, commentContent);
	}

	@Override
	public int deleteComments(String commentNO) throws Exception{
		return commentsMapper.deleteComments(commentNO);
	}

}
