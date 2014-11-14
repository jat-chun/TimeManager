package com.example.timemanager.activity;

import com.example.timemanager.R;
import com.example.timemanager.adapter.MemorandumAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MemorandumActivity extends Activity{
	
	private ListView lv_memorandum_main;
	private MemorandumAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memorandum_main);
		
		lv_memorandum_main = (ListView) findViewById(R.id.lv_memorandum_main);
		adapter = new MemorandumAdapter(this);
	}
}
