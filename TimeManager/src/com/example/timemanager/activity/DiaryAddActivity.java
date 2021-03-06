package com.example.timemanager.activity;

import java.sql.Date;
import java.util.jar.Attributes.Name;

import com.example.timemanager.R;
import com.example.timemanager.dao.DiaryServer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts.Data;
import android.text.method.DateTimeKeyListener;
import android.view.View;
import android.widget.EditText;

public class DiaryAddActivity extends Activity {
	private EditText et_diary_add_title;
	private EditText et_diary_add_author;
	private EditText et_diary_add_content;
	private DiaryServer server;
	private long time;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary_add);

		et_diary_add_title = (EditText) findViewById(R.id.et_diary_add_title);
		et_diary_add_author = (EditText) findViewById(R.id.et_diary_add_author);
		et_diary_add_content = (EditText) findViewById(R.id.et_diary_add_content);
		
		server = new DiaryServer(this);
		time = System.currentTimeMillis();
		
	}
	
	public void add(View view){
		String title = et_diary_add_title.getText().toString();
		String author = et_diary_add_author.getText().toString();
		String content = et_diary_add_content.getText().toString();
//		Date time = new Date(theDate)
		String dateTime = time+"";
		server.add(author, dateTime, title, content);
	}
	
	
	public void cancel(View view){
		Intent intent = new Intent(DiaryAddActivity.this, DiaryMainActivity.class);
		startActivity(intent);
	}
}

