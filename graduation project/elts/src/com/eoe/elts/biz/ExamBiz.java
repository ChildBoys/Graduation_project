package com.eoe.elts.biz;

import java.io.Serializable;
import java.util.ArrayList;

import com.eoe.elts.dao.ExamDao;
import com.eoe.elts.dao.IExamDao;
import com.eoe.elts.entity.ExamInfo;
import com.eoe.elts.entity.Question;
import com.eoe.elts.entity.User;

public class ExamBiz implements IExamBiz,Serializable {
	ArrayList<Question> questions;//所有考题
	User loginUser;//当前登录的考生
	IExamDao examDao;//数据访问层的对象
	ExamInfo examInfo;
	//业务逻辑的构造器
	public ExamBiz() {
		//创建数据访问层的对象
		examDao=new ExamDao();
	}
	@Override
	public void login(int uid, String pwd) throws Exception {
		User user=examDao.findUser(uid);
		if(user==null){
			throw new Exception("请先注册");
		}
		if(!user.getPassword().equals(pwd)){
			throw new Exception("密码错误");
		}
		loginUser=user;
	}

	@Override
	public void loadQuestions() {
		// TODO Auto-generated method stub

	}

	@Override
	public ExamInfo beginExam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question getQuestion(int qid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUserAnswers(int qid, ArrayList<String> userAnswers) {
		// TODO Auto-generated method stub

	}

	@Override
	public int over() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return loginUser;
	}

}
