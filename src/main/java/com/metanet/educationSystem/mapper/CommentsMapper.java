package com.metanet.educationSystem.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.CommentsVO;

@Repository
@Mapper
public interface CommentsMapper {

	List<HashMap<String, Object>> getCommentsList(String noticeNO);

	int insertComments(String noticeNO, String memberNO, String commentContent);

	int deleteComments(String commentNO);

}
