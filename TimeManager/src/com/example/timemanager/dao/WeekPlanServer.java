package com.example.timemanager.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.timemanager.bean.WeekPlanBean;
import com.example.timemanager.db.TimeManagerSQLiteOpenHelper;

public class WeekPlanServer implements BaseServer<WeekPlanBean>{

	private TimeManagerSQLiteOpenHelper helper;
	private SQLiteDatabase db;
	private WeekPlanBean bean;
	private List<WeekPlanBean> list;

	public WeekPlanServer(Context context) {
		// TODO Auto-generated constructor stub
		helper = new TimeManagerSQLiteOpenHelper(context);
	}

	@Override
	public long add(String id, String title, String content) {

		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("title", title);
		values.put("content", content);
		long id1 = 0;
		try {
			db.beginTransaction();
			id1 = db.insert("week_plan", null, values);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.endTransaction();
			db.close();
		}

		return id1;
	}

	@Override
	public int update(String id, String title, String content) {
		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("title", title);
		values.put("content", content);
		int influense = 0;
		try {
			db.beginTransaction();
			influense = db.update("week_plan", values, "id = ?", new String[]{id});
			//		long id1 = db.insert("week_plan", null, values);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.endTransaction();
			db.close();
		}
		return influense;
	}

	@Override
	public int delete(String id) {

		db = helper.getWritableDatabase();
		int influense = 0;
		try {
			db.beginTransaction();
			influense = db.delete("week_plan",  "id = ?", new String[]{id});
			//		long id1 = db.insert("week_plan", null, values);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.endTransaction();
			db.close();
		}
		return influense;
	}

	@Override
	public WeekPlanBean find(String id) {
		db = helper.getReadableDatabase();
		Cursor cursor = db.query("week_plan", null, "id = ?", new String[]{id} , null, null, null);
		//		db.execSQL("select * from table week_plan where id = "+id);
		//		db.rawQuery("select * from table week_plan where id = ?", new String[]{});
		if(cursor.moveToNext()){
			String id1 = cursor.getString(cursor.getColumnIndex("id"));
			String title = cursor.getString(cursor.getColumnIndex("title"));
			String content = cursor.getString(cursor.getColumnIndex("content"));
			String time = cursor.getString(cursor.getColumnIndex("time"));
			bean = new WeekPlanBean(id1, title, content);
			cursor.close();
			db.close();
		}
		return bean;
	}

	@Override
	public List<WeekPlanBean> findAll() {
		db = helper.getReadableDatabase();
		list = new ArrayList<WeekPlanBean>();
		Cursor cursor = db.query("week_plan", null, null, null , null, null, null);
		//		db.execSQL("select * from table week_plan where id = "+id);
		//		db.rawQuery("select * from table week_plan where id = ?", new String[]{});
		while(cursor.moveToNext()){
			String id1 = cursor.getString(cursor.getColumnIndex("id"));
			String title = cursor.getString(cursor.getColumnIndex("title"));
			String content = cursor.getString(cursor.getColumnIndex("content"));
			String time = cursor.getString(cursor.getColumnIndex("time"));
			bean = new WeekPlanBean(id1, title, content);
			list.add(bean);
		}
		cursor.close();
		db.close();
		return list;
	}


}
