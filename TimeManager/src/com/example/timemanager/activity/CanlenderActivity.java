package com.example.timemanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CanlenderActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		startActivityForResult(new Intent(Intent.ACTION_PICK).setDataAndType(null, CalendarActivity.MIME_TYPE), 100);
	}
}
