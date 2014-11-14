package com.example.timemanager.activity;

import com.example.timemanager.R;
import com.example.timemanager.adapter.WeekPlanAdapter;

import android.app.Activity;
import android.os.Bundle;

public class WeekPlanActivity extends Activity{
	private WeekPlanAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.week_plan);
		
		adapter = new WeekPlanAdapter(this);
		
	}
}
