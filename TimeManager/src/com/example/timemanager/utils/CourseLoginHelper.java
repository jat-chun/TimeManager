package com.example.timemanager.utils;

import org.apache.http.Header;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.protocol.HttpContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.timemanager.biz.Const;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

public class CourseLoginHelper {
	private SharedPreferences sp;
	private Context context;
	private AsyncHttpClient client;
	private PersistentCookieStore cookies;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			if(msg.arg1 == 1){
				Toast.makeText(context, "lianjiechenggong", 1).show();
			}
		};
	};
	public CourseLoginHelper(Context context) {
		this.context = context;
		client = new AsyncHttpClient();
		cookies = new PersistentCookieStore(context);
		sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
	}

	public void Login(String name,String pswd){
		String uriAPI1 = "http://jwc.wyu.edu.cn/student/";
		client.get(uriAPI1, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(int status, Header[] handlers, byte[] body) {
				HttpContext httpContext = client.getHttpContext();
				cookies = (PersistentCookieStore) httpContext.getAttribute(ClientContext.COOKIE_STORE);
			}

			@Override
			public void onFailure(int status, Header[] arg1, byte[] arg2, Throwable arg3) {
				// TODO Auto-generated method stub
				System.out.println(status);
			}
		});
		// TODO Auto-generated method stub
		String uriAPI = "http://jwc.wyu.edu.cn/student/";
		final RequestParams params = new RequestParams();
		//		ParameterValuePair pair = new ParameterValuePair(parameter, value)
		params.put("UserCode", name);
		params.put("UserPwd", pswd);
		params.put("Submit", "%CC%E1+%BD%BB");
		client.setConnectTimeout(5000);
		client.setCookieStore(cookies);
		client.get(uriAPI, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] handlers, byte[] responseBody) {
				// TODO Auto-generated method stub
				System.out.println(statusCode);
				if(statusCode == 200){
					Message message = new Message();
					message.arg1 = 1;
					message.obj = responseBody;
			     	System.out.println(cookies.getCookies());
					handler.sendMessage(message);
					String uriAPI2 = "http://jwc.wyu.edu.cn/student/logon.asp";
					client.setCookieStore(cookies);
					client.addHeader("Referer", "http://jwc.wyu.edu.cn/student/body.htm");
					client.post(uriAPI2,params, new TextHttpResponseHandler() {
						
						@Override
						public void onSuccess(int arg0, Header[] arg1, String arg2) {
							// TODO Auto-generated method stub
							String uriAPI3 = "http://jwc.wyu.edu.cn/student/f3.asp";
							client.get(uriAPI3, new TextHttpResponseHandler() {
								
								@Override
								public void onSuccess(int arg0, Header[] headers, String responseBody) {
									// TODO Auto-generated method stub
									Editor editor = sp.edit();
									editor.putString(Const.LOGIN_VALUES, responseBody);
									try {
//										String response = new String(responseBody.getBytes("gb2312"),"GBK");
										Document doc = Jsoup.parse(responseBody);
										String text = doc.body().text();
//										tv_url.setText(text);
//										wv_view.set
//										System.out.println(new String(arg2.getBytes("UTF-8"), "gb2312"));
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								
								@Override
								public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {
									// TODO Auto-generated method stub
									
								}
							});
						}
						
						@Override
						public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {
							// TODO Auto-generated method stub
							
						}
					});
				}
			}

			@Override
			public void onFailure(int statusCode, Header[] handlers, byte[] responseBody, Throwable error) {
				// TODO Auto-generated method stub
				error.printStackTrace();
				System.out.println(statusCode);
			}
		});

	}

	
}
