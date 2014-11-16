package com.example.timemanager.bean;

public class DiaryBean {

	private int id;
	private String author;
	private String time;
	private String title;
	private String content;

	public DiaryBean() {
		// TODO Auto-generated constructor stub
	}

	public DiaryBean(int id, String author, String time, String title,
			String content) {
		super();
		this.id = id;
		this.author = author;
		this.time = time;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
