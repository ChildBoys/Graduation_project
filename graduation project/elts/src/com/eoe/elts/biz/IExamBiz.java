package com.eoe.elts.biz;

import java.util.ArrayList;

import com.eoe.elts.entity.ExamInfo;
import com.eoe.elts.entity.Question;
import com.eoe.elts.entity.User;

/**
 * 负责表现层与业务逻辑层之间方法调用的约定。
 * @author yw
 *
 */
public interface IExamBiz {
	/**
	 * 登陆验证
	 * @param uid：用户编号
	 * @param pwd：密码
	 */
	public void login(int uid,String pwd) throws Exception;
	
	/**
	 * 返回登陆成功者-当前考生
	 * @return
	 */
	public User getUser();
	/**
	 * 下载考题
	 */
	public void loadQuestions();
	/**
	 * 1.从数据访问层获取下载的考题并打乱。
	 * 2.返回考卷头对象
	 * @return
	 */
	public ExamInfo beginExam();
	
	/**
	 * 根据考题索引提供一道考题
	 * @param qid
	 * @return
	 */
	public Question getQuestion(int qid);
	/**
	 * 保存考生选择的答案
	 * @param qid:考题索引
	 * @param userAnswers：考生选择的答案
	 */
	public void saveUserAnswers(int qid,ArrayList<String> userAnswers);
	
	/**
	 * 判题打分
	 * @return
	 */
	public int over();
}
