package com.example.timemanager.adapter;

import com.example.timemanager.R;
import com.example.timemanager.activity.StartActivity;
import com.example.timemanager.activity.WeekPlanEditActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WeekPlanAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	public WeekPlanAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		inflater = inflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.week_plan_gv_item, null);
		
		TextView tv_week_plan_item_title = (TextView) view.findViewById(R.id.tv_week_plan_item_title);
		TextView tv_week_plan_item_content = (TextView) view.findViewById(R.id.tv_week_plan_item_content);
		
		view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, WeekPlanEditActivity.class);
				context.startActivity(intent);
			}
		});
		return null;
	}

}
