package com.hirain.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirain.mapper.PlanMapper;
import com.hirain.pojo.Plan;
import com.hirain.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	PlanMapper planMapper;

	@Override
	public Boolean save(Map<String, Object> params) {
		try {
			for (Map.Entry<String, Object> param : params.entrySet()) {
				System.out.println(param.getKey() + ":" + param.getValue());
			}
			Plan plan = new Plan();
			Long userId = Long.valueOf(params.get("userId").toString());
			plan.setUserid(userId);
			plan.setLastweek(params.get("lastWeek").toString());
			plan.setCurrentweek(params.get("currentWeek").toString());
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = format.format(date);
			plan.setDate(dateString);
			Map<String, Object> map = new HashMap<>();
			map.put("userid", userId);
			map.put("date", dateString);
			Plan planByUserIdAndData = planMapper.findPlanByUserIdAndData(map);
			if (planByUserIdAndData == null) {
				planMapper.insert(plan);
			} else {
				planMapper.update(plan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//		MonthPlan monthPlan = new MonthPlan();
		//		monthPlan.set
		return null;
	}

}
