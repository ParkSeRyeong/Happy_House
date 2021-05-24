package com.ssafy.happyhouse.model.dto;

import java.sql.Date;

public class BoardDto {

	int no;
	String title;
	String writer;
	Date regtime;
	String content;
	public BoardDto() {
		super();
		
	}
	public BoardDto(int no, String title, String writer, Date regtime, String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.regtime = regtime;
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
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	
	
	
}
