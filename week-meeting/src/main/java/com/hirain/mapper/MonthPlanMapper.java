package com.hirain.mapper;

import com.hirain.pojo.MonthPlan;

public interface MonthPlanMapper {

	int insert(MonthPlan record);

	int insertSelective(MonthPlan record);

}