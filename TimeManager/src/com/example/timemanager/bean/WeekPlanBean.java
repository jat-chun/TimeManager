package com.example.timemanager.bean;

import android.text.format.Time;

public class WeekPlanBean {

	public WeekPlanBean(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	private String id;
	private String title;
	private String content;
	
//	private Time time;
//	
//	public Time getTime() {
//		return time;
//	}
//	public void setTime(Time time) {
//		this.time = time;
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
