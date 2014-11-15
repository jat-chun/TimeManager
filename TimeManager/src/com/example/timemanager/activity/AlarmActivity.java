package com.example.timemanager.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.timemanager.R;

public class AlarmActivity extends Activity{
	private Button setAnAlarm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarm_main);
		setAnAlarm = (Button) findViewById(R.id.btn_setAnAlarm);
		setAnAlarm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(AlarmActivity.this, DeskClockMainActivity.class);
				startActivity(intent);
			}
		});
	}
}
