package com.hirain.mapper;

import com.hirain.pojo.PlanWithBLOBs;

public interface PlanMapper {

	int insert(PlanWithBLOBs record);

	int insertSelective(PlanWithBLOBs record);

}