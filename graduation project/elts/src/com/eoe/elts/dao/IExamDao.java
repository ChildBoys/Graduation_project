package com.eoe.elts.dao;

import java.util.ArrayList;

import com.eoe.elts.entity.ExamInfo;
import com.eoe.elts.entity.Question;
import com.eoe.elts.entity.User;

/**
 * 负责数据访问层与业务逻辑层的方法调用约定
 * @author yw
 */
public interface IExamDao {
	//服务端的网址
	public static String url="http://10.0.2.2/";
	public static String USER_FILE="users.xml";
	public static String QUESTION_FILE="questions.xml";
	public static String EXAMINFO_FILE="exam_info.xml";
	/**
	 * 返回所有考题
	 * @return
	 */
	public ArrayList<Question> getQuestions();
	
	/**
	 * 返回考卷头对象
	 * @return
	 */
	public ExamInfo getExamInfo();
	
	/**
	 * 根据uid返回注册用户
	 * @param uid：指定的用户id
	 * @return 若没有uid指定的用户，则返回null
	 */
	public User findUser(int uid);
	
	/**
	 * 下载考题
	 */
	public void loadQuestions();
	
	/**
	 * 下载考卷头信息
	 */
	public void loadExamInfo();
}
