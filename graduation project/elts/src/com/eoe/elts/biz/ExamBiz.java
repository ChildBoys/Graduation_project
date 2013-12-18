package com.eoe.elts.biz;

import java.io.Serializable;
import java.util.ArrayList;

import com.eoe.elts.dao.ExamDao;
import com.eoe.elts.dao.IExamDao;
import com.eoe.elts.entity.ExamInfo;
import com.eoe.elts.entity.Question;
import com.eoe.elts.entity.User;

public class ExamBiz implements IExamBiz,Serializable {
	ArrayList<Question> questions;//���п���
	User loginUser;//��ǰ��¼�Ŀ���
	IExamDao examDao;//���ݷ��ʲ�Ķ���
	ExamInfo examInfo;
	//ҵ���߼��Ĺ�����
	public ExamBiz() {
		//�������ݷ��ʲ�Ķ���
		examDao=new ExamDao();
	}
	@Override
	public void login(int uid, String pwd) throws Exception {
		User user=examDao.findUser(uid);
		if(user==null){
			throw new Exception("����ע��");
		}
		if(!user.getPassword().equals(pwd)){
			throw new Exception("�������");
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
