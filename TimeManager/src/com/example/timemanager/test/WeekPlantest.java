package com.example.timemanager.test;

import com.example.timemanager.activity.WeekPlanActivity;
import com.example.timemanager.dao.WeekPlanServer;

import android.test.AndroidTestCase;

public class WeekPlantest extends AndroidTestCase {
	private WeekPlanServer server = new WeekPlanServer(getContext());
	public void testAdd(){
//		server.add(0, "周计划", "调整时间");
		System.out.println("插入成功");
	}
}
