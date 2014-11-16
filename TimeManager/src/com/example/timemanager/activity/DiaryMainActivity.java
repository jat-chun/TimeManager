package com.example.timemanager.activity;

import com.example.timemanager.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class DiaryMainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary_main);
		setRequestedOrientation(Window.FEATURE_NO_TITLE);
	}
	
	public void add(View view){
		Intent intent = new Intent(DiaryMainActivity.this, DiaryAddActivity.class);
		startActivity(intent);
	}
}
