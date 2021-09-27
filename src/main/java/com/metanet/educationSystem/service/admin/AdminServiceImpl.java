package com.metanet.educationSystem.service.admin;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.metanet.educationSystem.common.FileUtils;
import com.metanet.educationSystem.mapper.AdminMapper;
import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private FileUtils fileUtils;

//memberInsert - student, professor	

	@Override
	public void memberInsert(MemberVO memberVO) throws Exception {
		System.out.println(memberVO.toString() + "서비스입니다.");
		adminMapper.memberInsert(memberVO);
	}

	@Override
	public int checkMemberNO(String memberNO) throws Exception {
		String checkMemberNO = this.adminMapper.checkMemberNO(memberNO);
		int isExist = 0;
		if (checkMemberNO != null) {
			isExist = 1;
		}
		return isExist;
	}

//classInsert
	@Override
	public void classInsert(ClassVO classVO) throws Exception {
		System.out.println(classVO.toString() + "수업 입력입니다.");
		adminMapper.classInsert(classVO);

	}

	@Override
	public int checkClassNO(String classVO) throws Exception {
		return 0;
	}

//noticeInsert

	public void noticeInsert(NoticeVO noticeVO, HttpServletRequest request,
			MultipartHttpServletRequest multipartHttpServeltRequest) throws Exception {
		String noticeNO = adminMapper.getNoticeNO();
		noticeVO.setNoticeNO(noticeNO);
		adminMapper.noticeInsert(noticeVO);
		
		List<NoticeFileVO> noticeFileList = fileUtils.parseFileInfo(noticeVO.getNoticeNO(), request,
				multipartHttpServeltRequest);
		if (CollectionUtils.isEmpty(noticeFileList) == false) {
			String fileNO = adminMapper.getFileNO();
			for (NoticeFileVO list : noticeFileList) {
				list.setFileNO(fileNO);
				fileNO = Integer.toString((Integer.parseInt(fileNO)+1));
			}
			this.adminMapper.insertNoticeFileList(noticeFileList);
		}
		
	}

	@Override
	public int checkNoticeNO(String noticeVO) throws Exception {
		return 0;
	}

}
