package com.metanet.educationSystem.service.admin;

import com.metanet.educationSystem.model.MemberVO;

public interface AdminService {

	void memberInsert(MemberVO memberVO) throws Exception;

	int checkMemberNO(String memberNO) throws Exception;

}
