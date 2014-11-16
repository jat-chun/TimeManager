package com.example.timemanager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.timemanager.R;
import com.example.timemanager.adapter.MainAdapter;
import com.example.timemanager.biz.Const;
import com.example.timemanager.utils.CourseLoginHelper;

public class MainActivity extends Activity{
	private MainAdapter adapter;
	private CourseLoginHelper loginHelper;
	private SharedPreferences sp;
	private Intent intent;
	private MainActivity TAG = MainActivity.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		sp = getSharedPreferences("config",Context.MODE_PRIVATE);
		ListView lv_main = (ListView) findViewById(R.id.lv_main);
		adapter = new MainAdapter(TAG);
		lv_main.setAdapter(adapter);
		lv_main.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					intent = new Intent(MainActivity.this, MemorandumActivity.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(MainActivity.this, AlarmActivity.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(Intent.ACTION_PICK).setDataAndType(null, CalendarActivity.MIME_TYPE);
					MainActivity.this.startActivity(intent);
					break;
				case 3:
					boolean isLogin = sp.getBoolean(Const.ISLOGIN, false);
					if(isLogin){
						loginHelper = new CourseLoginHelper(TAG);
						String name = sp.getString(Const.LOGIN_NAME, null);
						String pswd = sp.getString(Const.LOGIN_PSWD, null);
						loginHelper.Login(name, pswd);
					}else{
						intent = new Intent(MainActivity.this, CourseLoginActivity.class);
						startActivity(intent);
					}
					break;
				case 4:
					intent = new Intent(MainActivity.this, WeekPlanActivity.class);
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(MainActivity.this, DiaryActivity.class);
					startActivity(intent);
					break;
				case 6:
					
					break;
				default:
					break;
				}
				
			}
		});
	}


}
