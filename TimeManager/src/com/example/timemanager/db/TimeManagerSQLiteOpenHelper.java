package com.example.timemanager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TimeManagerSQLiteOpenHelper extends SQLiteOpenHelper {
	

	public TimeManagerSQLiteOpenHelper(Context context) {
		//name表示数据库名字，factory表示游标,一般为null，version表示s数据库版本，使从1开始的
		super(context, "TimeManager.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//数据库第一次创建的时候调用的方法，在这里一般都是建表
		db.execSQL("CREATE TABLE calendar (id integer primary key autoincrement,title varchar(20),content varchar)");
		db.execSQL("CREATE TABLE week_plan (id integer primary key autoincrement,title varchar[60],content varchar[100])");
		db.execSQL("CREATE TABLE timemanager (id integer primary key autoincrement,name varchar[20],describe varchar[60])");
		db.execSQL("CREATE TABLE memorandum (id integer primary key autoincrement,title varchar[20],content varchar[100])");
		db.execSQL("CREATE TABLE diary (id integer primary key autoincrement,author varchar[20],time DateTime, title varchar[20],content varchar[100])");
		// db.execSQL("create table person id integer primary key autoincrement,name varchar(20),number varchar(20);");
		// db.execSQL("create table alarm ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
