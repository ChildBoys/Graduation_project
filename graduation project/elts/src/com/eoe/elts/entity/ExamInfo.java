package com.eoe.elts.entity;

import java.io.Serializable;

public class ExamInfo implements Serializable{
	private String subjectTitle;//考试科目
	private User user;//当前考生
	private int limitTime;//考试时限
	private int questionCount;//考题数量
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(int limitTime) {
		this.limitTime = limitTime;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	@Override
	public String toString() {
		
		return "考试科目:"+this.subjectTitle+
			   "考生编号:"+this.getUser().getId()+"\n"+
			   "考题数量:"+this.getQuestionCount()+
			   "考试时间:"+this.getLimitTime()+"分钟";
	}
}
