package com.example.timemanager.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.timemanager.bean.DiaryBean;
import com.example.timemanager.db.TimeManagerSQLiteOpenHelper;

public class DiaryServer {

	private TimeManagerSQLiteOpenHelper helper;
	private SQLiteDatabase db;
	private DiaryBean bean;
	private List<DiaryBean> list;

	public DiaryServer(Context context) {
		helper = new TimeManagerSQLiteOpenHelper(context);
	}

	public long add(int id, String author, String time, String title,
			String content) {
		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("author", author);
		values.put("time", time);
		values.put("title", title);
		values.put("content", content);
		long flag = 0;
		try {
			db.beginTransaction();
			flag = db.insert("diary", null, values);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.endTransaction();
			db.close();
		}
		return flag;
	}

	public void update(int id, String author, String time, String title,
			String content) {
		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("author", author);
		values.put("time", time);
		values.put("title", title);
		values.put("content", content);
		try {
			db.beginTransaction();
			db.update("diary", values, "id = ?",
					new String[] { String.valueOf(id) });
			db.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			db.endTransaction();
			db.close();
		}
	}

	public int delete(int id) {
		db = helper.getWritableDatabase();
		int flag = 0;
		try {
			db.beginTransaction();
			flag = db.delete("diary", "id = ?",
					new String[] { String.valueOf(id) });
			db.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.endTransaction();
			db.close();
		}
		return flag;
	}

	public DiaryBean find(int id) {
		db = helper.getReadableDatabase();
		Cursor cursor = db.query("diary", null, "id = ?",
				new String[] { String.valueOf(id) }, null, null, null);
		if (cursor.moveToNext()) {
			String author = cursor.getString(cursor.getColumnIndex("author"));
			String time = cursor.getString(cursor.getColumnIndex("time"));
			String title = cursor.getString(cursor.getColumnIndex("title"));
			String content = cursor.getString(cursor.getColumnIndex("content"));
			bean = new DiaryBean(cursor.getInt(cursor.getColumnIndex("id")),
					author, time, title, content);
		}
		cursor.close();
		db.close();
		return bean;
	}

	public List<DiaryBean> findAll() {
		db = helper.getReadableDatabase();
		list = new ArrayList<DiaryBean>();
		Cursor cursor = db.query("diary", null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			int index = cursor.getInt(cursor.getColumnIndex("id"));
			String author = cursor.getString(cursor.getColumnIndex("author"));
			String time = cursor.getString(cursor.getColumnIndex("time"));
			String title = cursor.getString(cursor.getColumnIndex("title"));
			String content = cursor.getString(cursor.getColumnIndex("content"));
			bean = new DiaryBean(index, author, time, title, content);
			list.add(bean);
		}
		cursor.close();
		db.close();
		return list;
	}

}
