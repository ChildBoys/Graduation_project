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
		//ͨ������xml�ļ��е�idֵ�ڶ��д���ExitText����
		metId=(EditText) findViewById(R.id.etId);
		metPwd=(EditText) findViewById(R.id.etPwd);
		//�ڹ����߳�������ע���û�
				Thread t=new Thread(){
					public void run() {
						//����ҵ���߼�����
						examBiz=new ExamBiz();
					};
				};
				t.start();//�����߳�
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//���ù����߳�Ϊ���߳�
	}
	//��¼��ť�ĵ���¼���Ӧ����
	public void login(View v){
		//��metId��ȡ������ı��
		String strid=metId.getText().toString();
		if(strid==null || strid.length()==0){
			metId.setError("��Ų���Ϊ��");
			return ;//�ӵ�ǰ���˳�login����
		}
		//��stridת��Ϊint����
		int uid=Integer.parseInt(strid);
		//ȡ���û����������
		String pwd=metPwd.getText().toString();
		if(pwd==null || pwd.length()==0){
			metPwd.setError("���벻��Ϊ��");
			return ;
		}
		
		try {
			examBiz.login(uid, pwd);
		} catch (Exception e) {
			if(e.getMessage().equals("����ע��")){
				metId.setError("����ע��");
			}else if(e.getMessage().equals("�������")){
				metPwd.setError("�������");
			}
		}
	}
}
