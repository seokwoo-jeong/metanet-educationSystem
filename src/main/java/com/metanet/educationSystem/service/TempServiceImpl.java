package com.metanet.educationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.TempMapper;
import com.metanet.educationSystem.model.DeptVO;

@Service
public class TempServiceImpl implements TempService{
	
	 @Autowired
	 private TempMapper tempMapper;

	@Override
	public DeptVO getAll() {
		// TODO Auto-generated method stub
		return tempMapper.getAll();
	}

}
