package com.example.timemanager.activity;

import java.sql.Time;

import com.example.timemanager.R;
import com.example.timemanager.adapter.WeekPlanAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class WeekPlanActivity extends Activity{
	private WeekPlanAdapter adapter;
	private GridView gv_week_plan;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.week_plan);
		
		gv_week_plan = (GridView) findViewById(R.id.gv_week_plan);
		adapter = new WeekPlanAdapter(this);
		gv_week_plan.setAdapter(adapter);
		gv_week_plan.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
