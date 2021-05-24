package com.ssafy.happyhouse.model.dto;

import java.sql.Date;

public class NoticeDto {

	int no;
	String title;
	String writer;
	Date date;
	String content;
	
	
	public NoticeDto() {
		super();
		
	}

	public NoticeDto(int no, String title, String writer, Date date, String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
}
