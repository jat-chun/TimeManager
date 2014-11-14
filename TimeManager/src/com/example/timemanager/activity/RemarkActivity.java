package com.example.timemanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.timemanager.R;

public class RemarkActivity extends Activity {

	private TextView tv_date;
	private int year;
	private int month;
	private int day;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remark);
		tv_date = (TextView) findViewById(R.id.tv_date);
		init();
	}
	
	private void init() {
		Intent intent = getIntent();
		year = intent.getIntExtra("year", 0);
		month = intent.getIntExtra("month", 0);
		day = intent.getIntExtra("day", 0);
		tv_date.setText(year+"年"+month+"月"+day+"日");
	}
	
}
