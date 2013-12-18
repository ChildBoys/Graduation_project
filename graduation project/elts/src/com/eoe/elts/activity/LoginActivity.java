package com.eoe.elts.activity;

import com.eoe.elts.R;
import com.eoe.elts.R.layout;
import com.eoe.elts.R.menu;
import com.eoe.elts.biz.ExamBiz;
import com.eoe.elts.biz.IExamBiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {
	EditText metId,metPwd;
	IExamBiz examBiz;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		//通过查找xml文件中的id值在堆中创建ExitText对象
		metId=(EditText) findViewById(R.id.etId);
		metPwd=(EditText) findViewById(R.id.etPwd);
		//在工作线程中下载注册用户
				Thread t=new Thread(){
					public void run() {
						//创建业务逻辑对象
						examBiz=new ExamBiz();
					};
				};
				t.start();//启动线程
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//设置工作线程为子线程
	}
	//登录按钮的点击事件响应方法
	public void login(View v){
		//从metId中取出输入的编号
		String strid=metId.getText().toString();
		if(strid==null || strid.length()==0){
			metId.setError("编号不能为空");
			return ;//从当前行退出login方法
		}
		//将strid转换为int类型
		int uid=Integer.parseInt(strid);
		//取出用户输入的密码
		String pwd=metPwd.getText().toString();
		if(pwd==null || pwd.length()==0){
			metPwd.setError("密码不能为空");
			return ;
		}
		
		try {
			examBiz.login(uid, pwd);
		} catch (Exception e) {
			if(e.getMessage().equals("请先注册")){
				metId.setError("请先注册");
			}else if(e.getMessage().equals("密码错误")){
				metPwd.setError("密码错误");
			}
		}
	}
}
