package com.example.timemanager.activity;

import com.example.timemanager.R;
import com.example.timemanager.biz.Const;
import com.example.timemanager.utils.LoginHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CourseLoginActivity extends Activity{
	private LoginHelper loginHelper;
	private SharedPreferences sp;
	private EditText et_login_name;
	private EditText et_login_pswd;
	private CheckBox cb_login_remember;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		et_login_name = (EditText) findViewById(R.id.et_login_name);
		et_login_pswd = (EditText) findViewById(R.id.et_login_pswd);
		cb_login_remember = (CheckBox) findViewById(R.id.cb_login_remember);

		sp = getSharedPreferences("config", Context.MODE_PRIVATE);
	}

	public void loginCourse(View view){
		boolean isRemember = cb_login_remember.isChecked();

		String name = et_login_name.getText().toString().trim();
		String pswd = et_login_pswd.getText().toString().trim();

		if(isRemember){
			Editor editor = sp.edit();
			editor.putString(Const.LOGIN_NAME, name);
			editor.putString(Const.LOGIN_PSWD, pswd);
			editor.putBoolean(Const.ISLOGIN, true);
			editor.commit();
		}

		loginHelper = new LoginHelper(CourseLoginActivity.this);
		loginHelper.Login(name, pswd);
	}

	public void cancelCourse(View v){
		Intent intent = new Intent(CourseLoginActivity.this, MainActivity.class);
		startActivity(intent);
		CourseLoginActivity.this.finish();
	}

}
