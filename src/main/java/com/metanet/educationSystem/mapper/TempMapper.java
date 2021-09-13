package com.metanet.educationSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.educationSystem.model.DeptVO;

@Repository
@Mapper
public interface TempMapper {

	public DeptVO getAll();

}
