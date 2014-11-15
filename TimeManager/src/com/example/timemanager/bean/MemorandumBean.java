package com.example.timemanager.bean;

import java.sql.Time;


public class MemorandumBean {
	private int id;
	private Time time;
	private String Title;
	private String content;
	
	public MemorandumBean(int id, Time time, String title, String content) {
		super();
		this.id = id;
		this.time = time;
		Title = title;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
