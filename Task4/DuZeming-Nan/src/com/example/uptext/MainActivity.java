package com.example.uptext;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements android.view.View.OnClickListener{ 
	public static final int SHOW_RESPONSE=0;
//	private Button sendRequest;
	private TextView responseText;
	private List<My> myList = new ArrayList<My>();
	private Handler handler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case SHOW_RESPONSE:
				String response = (String)msg.obj;
				responseText.setText(response);
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
//		sendRequest=(Button)findViewById(R.id.list_view);
		ListView lv =  (ListView)findViewById(R.id.list_view);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
			}
		});
		
		
		
		
		
		responseText=(TextView)findViewById(R.id.response_text);
//		sendRequest.setOnClickListener(this);
		
		
		initMy();
		MyAdapter adapter = new MyAdapter(MainActivity.this,R.layout.my_item,myList);
		
		 ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> parent,View view, int position,long id){
        		
        		
        		switch (position){
        		case 1:
        			
        				sendRequestWithHttpClick();
        			
        			AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
       			    dialog.setTitle("������ʾ");
        			dialog.setMessage("֪��Android 4.8.2 �汾�������µ��ղ��ܣ��Ż�������������ٶȺ��ȶ��ԣ�������Ż��˻�����ƣ������Ļش�û������Ҳ���ٴδ򿪣���������֧���˸�������ͣ���Ա�ͽ������Live�ṩ�ݶȶ��ۣ��޸�����Ƶ���ŵ�������⣻�Ż���ͼƬ���ص��߼���");
                    dialog.setCancelable(false);
                    View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.little_item, null);
                    dialog.setView(v);
                    dialog.show();
                    break;
                    default:
                    	break;
        		}
        	
        	}
        });
	}
        private void sendRequestWithHttpClick() {
		new Thread(new Runnable(){
			@Override
			public void run(){
				HttpURLConnection connection = null;
				try{
					URL url=new URL("http://www.baidu.com");
					connection= (HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in= connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while((line=reader.readLine())!=null){
						response.append(line);
					}
					Message message = new Message();
					message.what=SHOW_RESPONSE;
					message.obj=response.toString();
					handler.sendMessage(message);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(connection!=null){
						connection.disconnect();
					}
				}
			}
		}).start();
		
	}
		private void initMy(){
         My a=new My("������"); 	
        myList.add(a);
        My b=new My("���������"); 	
        myList.add(b);
        My c=new My("�������"); 	
        myList.add(c);
       
	}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	
}
