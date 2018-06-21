package com.hirain.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hirain.pojo.Plan;

public interface PlanMapper {

	@Insert("insert into plan (userId,lastWeek,currentWeek,problem,date) values(#{userid},#{lastweek},#{currentweek},#{problem},#{date})")
	int insert(Plan plan);

	@Select("select * from plan where userId=#{userid} and date=#{date}")
	Plan findPlanByUserIdAndData(Map<String, Object> map);

	@Update("update plan set userId=#{userid},lastWeek=#{lastweek},currentWeek=#{currentweek},problem=#{problem},date=#{date} where userId=#{userid} and date=#{date}")
	int update(Plan plan);

}