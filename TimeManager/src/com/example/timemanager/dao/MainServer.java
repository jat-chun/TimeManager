package com.example.timemanager.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.timemanager.bean.MainBean;
import com.example.timemanager.bean.WeekPlanBean;
import com.example.timemanager.db.TimeManagerSQLiteOpenHelper;

public class MainServer implements BaseServer<MainBean>{

	private TimeManagerSQLiteOpenHelper helper;
	private List<MainBean> list = new ArrayList<MainBean>();
	public MainServer(Context context) {
		// TODO Auto-generated constructor stub
		helper = new TimeManagerSQLiteOpenHelper(context);
		SQLiteDatabase db = helper.getWritableDatabase();
	}
	
	@Override
	public long add(String id, String title, String content) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(int id, String title, String content) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public WeekPlanBean find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<MainBean> findAll() {
		// TODO Auto-generated method stub
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query("timemanager", null, null, null, null, null, null);
		while(cursor.moveToNext()){
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String describe = cursor.getString(cursor.getColumnIndex("describe"));
			System.out.println(id+name+describe);
			MainBean bean = new MainBean(id, name, describe);
			list.add(bean);
		}
		return list;
	}

	

	

}
