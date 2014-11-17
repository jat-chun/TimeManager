package com.example.timemanager.bean;

import android.text.format.Time;

public class WeekPlanBean {

	public WeekPlanBean(int id, String content) {
		super();
		this.id = id;
//		this.title = title;
		this.content = content;
	}
	public WeekPlanBean() {
		// TODO Auto-generated constructor stub
	}
	private int id;
//	private String title;
	private String content;
	
//	private Time time;
//	
//	public Time getTime() {
//		return time;
//	}
//	public void setTime(Time time) {
//		this.time = time;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
