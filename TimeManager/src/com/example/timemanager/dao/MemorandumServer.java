package com.example.timemanager.dao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.timemanager.bean.MemorandumBean;
import com.example.timemanager.bean.WeekPlanBean;
import com.example.timemanager.db.TimeManagerSQLiteOpenHelper;

public class MemorandumServer {
	private Context context;
	private TimeManagerSQLiteOpenHelper helper;
	private List<MemorandumBean> list = new ArrayList<MemorandumBean>();
	public MemorandumServer(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		helper = new TimeManagerSQLiteOpenHelper(context);
	}

	public long add(int id, Time time , String title, String content) {
		// TODO Auto-generated method stub
		long influence = 0;
		SQLiteDatabase db = helper.getWritableDatabase();
		try {
			db.beginTransaction();
			ContentValues values = new ContentValues();
			values.put("time", time.toString());
			values.put("title", title);
			values.put("content", content);
			influence = db.insert("memorandum",null, values);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.endTransaction();
			db.close();
		}
		return influence;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		int influence = 0;
		SQLiteDatabase db = helper.getWritableDatabase();
		try {
			db.beginTransaction();
			influence = db.delete("memorandum", "id = ?", new String[]{String.valueOf(id)});
			db.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.endTransaction();
			db.close();
		}
		return influence;
	}

	public List<MemorandumBean> findAll() {
		// TODO Auto-generated method stub
		SQLiteDatabase db = helper.getReadableDatabase();
		MemorandumBean bean;
		try {
			db.beginTransaction();
			Cursor cursor = db.query("memorandum", null, null, null, null, null, null);
			db.setTransactionSuccessful();
			while(cursor.moveToNext()){
				int id = cursor.getInt(cursor.getColumnIndex("id"));
				String time = cursor.getString(cursor.getColumnIndex("title"));
				String title = cursor.getString(cursor.getColumnIndex("title"));
				String content = cursor.getString(cursor.getColumnIndex("content"));
				Time time2 = Time.valueOf(time);
				bean = new MemorandumBean(id, time2, title, content);
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.endTransaction();
			db.close();
		}
		return list;
	}

	public MemorandumBean find(int id) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = helper.getReadableDatabase();
		MemorandumBean bean = null;
		String findId = String.valueOf(id);
		try {
			db.beginTransaction();
			Cursor cursor = db.query("week_plan", null, "id = ?", new String[]{findId}, null, null, null);
			db.setTransactionSuccessful();
			while(cursor.moveToNext()){
				int id1 = cursor.getInt(cursor.getColumnIndex("id"));
				String time = cursor.getString(cursor.getColumnIndex("time"));
				String title = cursor.getString(cursor.getColumnIndex("title"));
				String content = cursor.getString(cursor.getColumnIndex("content"));
				Time time2 = Time.valueOf(time);
				bean = new MemorandumBean(id, time2, title, content);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.endTransaction();
			db.close();
		}
		return bean;
	}

	public void update(int id,Time time, String title, String content) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = helper.getWritableDatabase();
		try {
			db.beginTransaction();
			db.execSQL("update table memorandum set time =  "+time+" title = "+title+"and content =  "+content+"where id="+id);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.endTransaction();
			db.close();
		}
	}

}
