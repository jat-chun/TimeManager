package com.example.timemanager.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timemanager.R;
import com.example.timemanager.utils.ViewHelper;

public class StartActivity extends Activity {

	private StartActivity TAG = StartActivity.this;
	private TextView tv_start_version;
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.start_activity);

		AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1.0f);
		alphaAnimation.setDuration(2000);
		Toast.makeText(this, "make", 0).show();

		RelativeLayout layout = (RelativeLayout) findViewById(R.id.start_time);
		layout.setAnimation(alphaAnimation);

		
		tv_start_version = (TextView) findViewById(R.id.tv_start_version);
		tv_start_version.setText("版本："+ ViewHelper.getVersion(this));

		sp = getSharedPreferences("config", Context.MODE_PRIVATE);
		if(sp.getBoolean("version", false)){
			
		}else{
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						//如果在ui线程，会造成ui阻塞
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					StartActivity.this.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Intent intent = new Intent(TAG, MainActivity.class);
							TAG.startActivity(intent);
							TAG.finish();
						}
					});
				}
			}).start();
		}
	}
}
