package com.example.kidszonea4arctic3.models;


public class Mail {
private String subject;
private String content;
private String to;


public Mail() {
	// TODO Auto-generated constructor stub
}


public Mail(String subject, String content, String to) {
	super();
	this.subject = subject;
	this.content = content;
	this.to = to;
}


public String getSubject() {
	return subject;
}


public void setSubject(String subject) {
	this.subject = subject;
}


public String getContent() {
	return content;
}


public void setContent(String content) {
	this.content = content;
}


public String getTo() {
	return to;
}


public void setTo(String to) {
	this.to = to;
}


@Override
public String toString() {
	return "Mail [subject=" + subject + ", content=" + content + ", to=" + to + "]";
}

}
