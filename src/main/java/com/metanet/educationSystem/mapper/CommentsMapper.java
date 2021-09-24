package com.metanet.educationSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.CommentsVO;

@Repository
@Mapper
public interface CommentsMapper {

	List<CommentsVO> getCommentsList(String noticeNO);

}
