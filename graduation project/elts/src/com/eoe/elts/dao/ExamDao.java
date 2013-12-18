package com.eoe.elts.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.eoe.elts.biz.IExamBiz;
import com.eoe.elts.entity.ExamInfo;
import com.eoe.elts.entity.Question;
import com.eoe.elts.entity.User;

public class ExamDao implements IExamDao, Serializable {
	ArrayList<Question> questions;
	ArrayList<User> users;
	public ExamDao() {
		questions=new ArrayList<Question>();
		users=new ArrayList<User>();
		loadUsers();//�ӷ��������ע���û��ļ�-users.xml
	}
	//�ӷ��������ע���û��ļ�-users.xml
	private void loadUsers() {
		//����1������ָ������users.xml�ļ���URL����
		try {
			URL url=new URL(IExamDao.url+IExamDao.USER_FILE);
			//����2������URLConnection����
			URLConnection connection=url.openConnection();
			//����3����ȡ������
			InputStream in=connection.getInputStream();
			byte[] buffer=new byte[1024];
			//����4�����������ж�ȡ���ݣ�byte[]����
			int len=in.read(buffer);
			String content=new String(buffer, "utf-8");
			JSONArray jsons=new JSONArray(content);
			for(int i=0;i<jsons.length();i++){
				User user=new User();
				JSONObject json=jsons.getJSONObject(i);
				user.setId(json.getInt("id"));
				user.setName(json.getString("name"));
				user.setPassword(json.getString("password"));
				user.setPhone(json.getString("phone"));
				user.setEmail(json.getString("email"));
				users.add(user);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public ArrayList<Question> getQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamInfo getExamInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUser(int uid) {
		for(User user:users){
			if(user.getId()==uid){
				return user;
			}
		}
		return null;
	}

	@Override
	public void loadQuestions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadExamInfo() {
		// TODO Auto-generated method stub
		
	}



}
