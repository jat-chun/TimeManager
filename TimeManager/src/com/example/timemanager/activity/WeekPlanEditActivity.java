package com.example.timemanager.activity;

import com.example.timemanager.R;
import com.example.timemanager.dao.WeekPlanServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WeekPlanEditActivity extends Activity{

	private EditText et_week_plan_item_edit_title;
	private EditText et_week_plan_item_edit_content;
	private String title;
	private String content;
	private WeekPlanServer server;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.week_plan_item_edit);

		server = new WeekPlanServer(this);
		et_week_plan_item_edit_title = (EditText) findViewById(R.id.et_week_plan_item_edit_title);
		et_week_plan_item_edit_content = (EditText) findViewById(R.id.et_week_plan_item_edit_content);
	}
	/**
	 * 把数据更新保存到数据库
	 * 然后回到上一层的activity显示周计划
	 * @param view
	 */
	public void save(View view){

		//数据库的保存操作
		title = et_week_plan_item_edit_title.getText().toString();
		content = et_week_plan_item_edit_content.getText().toString();
//		server.add(id, title, content);
		
		//回到上一层的activity显示周计划
		Intent intent = new Intent(WeekPlanEditActivity.this, WeekPlanActivity.class);
		WeekPlanEditActivity.this.startActivity(intent);
	}
	/**
	 * 监听取消按钮，如果按下，就返回上一层的activity显示周计划
	 * @param view
	 */
	public void cancel(View view){
		//不保存。则返回上一层显示weekplan
		Intent intent = new Intent(WeekPlanEditActivity.this, WeekPlanActivity.class);
		WeekPlanEditActivity.this.startActivity(intent);
	}

	public void delete(View view){
		
		
		
		
		//删除后。则返回上一层显示weekplan
		Intent intent = new Intent(WeekPlanEditActivity.this, WeekPlanActivity.class);
		WeekPlanEditActivity.this.startActivity(intent);
	}
}
