package com.example.timemanager.adapter;

import com.example.timemanager.R;
import com.example.timemanager.dao.MemorandumServer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MemorandumAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private MemorandumServer server;
	public MemorandumAdapter(Context context) { 
		// TODO Auto-generated constructor stub
		this.context = context;
		inflater = inflater.from(context);
		server = new MemorandumServer(context);
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
		View view = inflater.inflate(R.layout.memorandum_main_item, null);
		return view;
	}

}
