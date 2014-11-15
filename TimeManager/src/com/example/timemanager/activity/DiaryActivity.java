package com.example.timemanager.activity;

import com.example.timemanager.R;
import com.example.timemanager.biz.Const;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class DiaryActivity extends Activity {
	private DiaryActivity TAG = DiaryActivity.this;
	private EditText et_diary_login_name;
	private EditText et_diary_login_pswd;
	private CheckBox cb_diary_login_rem;
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary_login);

		et_diary_login_name = (EditText) findViewById(R.id.et_diary_login_name);
		et_diary_login_pswd = (EditText) findViewById(R.id.et_diary_login_pswd);
		cb_diary_login_rem = (CheckBox) findViewById(R.id.cb_diary_login_rem);
		sp = getSharedPreferences("config", Context.MODE_PRIVATE);
		String name = sp.getString(Const.DIARY_LOGIN_NAME, null);
		String pswd = sp.getString(Const.DIARY_LOGIN_PSWD, null);

		if(!name.equals(null)&&!pswd.equals(null)){
			Intent intent = new Intent(TAG, DiaryMainActivity.class);
			startActivity(intent);
		}
	}


	public void sure(View view){
		String name = et_diary_login_name.getText().toString().trim();
		String pswd = et_diary_login_pswd.getText().toString();
		Editor editor = sp.edit();

		if(cb_diary_login_rem.isChecked()){
			editor.putString(Const.DIARY_LOGIN_NAME, name);
			editor.putString(Const.DIARY_LOGIN_PSWD, pswd);
		}else{
			editor.putString(Const.DIARY_LOGIN_NAME, null);
			editor.putString(Const.DIARY_LOGIN_PSWD, null);
		}

		Intent intent = new Intent(TAG, DiaryMainActivity.class);
		startActivity(intent);
	}

	public void cancel(View view){
		Intent intent = new Intent(TAG, MainActivity.class);
		startActivity(intent);
	}
}
