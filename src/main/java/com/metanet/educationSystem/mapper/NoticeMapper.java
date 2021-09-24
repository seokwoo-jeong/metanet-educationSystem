package com.metanet.educationSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.NoticeVO;

@Repository
@Mapper
public interface NoticeMapper {

	List<NoticeVO> getNoticeList();

	NoticeVO getNotice(String noticeNO);

}
