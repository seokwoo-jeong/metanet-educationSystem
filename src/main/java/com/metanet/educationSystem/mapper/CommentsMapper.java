package com.metanet.educationSystem.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.CommentsVO;

@Repository
@Mapper
public interface CommentsMapper {

	public List<HashMap<String, Object>> getCommentsList(String noticeNO) throws Exception;

	public int insertComments(String noticeNO, String memberNO, String commentContent) throws Exception;

	public int deleteComments(String commentNO) throws Exception;

}
