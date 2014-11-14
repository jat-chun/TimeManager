package com.example.timemanager.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.timemanager.bean.WeekPlanBean;
import com.example.timemanager.db.TimeManagerSQLiteOpenHelper;

public interface BaseServer<T> {
	
	
	public long add(String id,String title,String content);
	
	public int update(String id,String title,String content);
	
	public int delete(String id);
	
	public T find(String id);
	
	public List<T> findAll();
}
