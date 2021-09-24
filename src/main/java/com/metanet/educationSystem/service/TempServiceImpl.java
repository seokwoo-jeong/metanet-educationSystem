package com.metanet.educationSystem.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.metanet.educationSystem.common.FileUtils;

import com.metanet.educationSystem.mapper.TempMapper;
import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;

@Service
public class TempServiceImpl implements TempService{
	
	@Autowired
	private TempMapper tempMapper;
	
	@Autowired
	private FileUtils fileUtils;

	@Override
	public void insertNotice(NoticeVO noticeVO,HttpServletRequest request, MultipartHttpServletRequest multipartHttpServeltRequest)
			throws Exception {
		//tempMapper.insertNotice(noticeVO);
		
		List<NoticeFileVO> noticeFileList = fileUtils.parseFileInfo(noticeVO.getNoticeNO(), request,multipartHttpServeltRequest);
		if(CollectionUtils.isEmpty(noticeFileList) == false) {
			String fileNO = tempMapper.getFileNO();
			if (fileNO == null) {
				fileNO = "1";
			}else {
				fileNO = Integer.toString(Integer.parseInt(fileNO) + 1);
			}
			for (NoticeFileVO list: noticeFileList) {
				list.setFileNO(fileNO);
			}
			tempMapper.insertNoticeFileList(noticeFileList);
		}
		
		
		
	}

	@Override
	public List<NoticeFileVO> getFile(String noticeNO) throws Exception {
		return this.tempMapper.getFile(noticeNO);
		
	}

	@Override
	public NoticeFileVO downloadNoticeFile(NoticeFileVO noticeFileVO) throws Exception {
		return this.tempMapper.downloadNoticeFile(noticeFileVO);
	}

}
