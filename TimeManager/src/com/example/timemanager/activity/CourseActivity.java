package com.example.timemanager.activity;

import com.example.timemanager.biz.Const;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class CourseActivity extends Activity {
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		sp = getSharedPreferences("config", Context.MODE_PRIVATE);
		boolean login = sp.getBoolean(Const.ISLOGIN, false);
		if(login){
			
		}else{
			Intent intent = new Intent(CourseActivity.this, CourseLoginActivity.class);
			startActivity(intent);
		}
	}
}
