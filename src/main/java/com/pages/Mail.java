package com.pages;

public class Mail {
	private String subject;
	private String content;
	public String getcontent(){
		return content;
	}
	public String getSubject(){
		return subject;
	}
	public Mail(String subject,String content){
		this.subject = subject;
		this.content = content;
	}
}
