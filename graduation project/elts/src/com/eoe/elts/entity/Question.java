package com.eoe.elts.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
	private ArrayList<String> answers;//标准答案
	private ArrayList<String> userAnswers;//考生选择的答案
	private int score;//分值
	private String title;//考试题目
	private String options;//待选答案
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	public ArrayList<String> getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(ArrayList<String> userAnswers) {
		this.userAnswers = userAnswers;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	@Override
	public String toString() {
		
		return this.title+"\n"+this.options;
	}
}
