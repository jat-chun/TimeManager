package com.example.timemanager.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.timemanager.R;
import com.example.timemanager.bean.MainBean;
import com.example.timemanager.dao.MainServer;

public class MainAdapter extends BaseAdapter implements ListAdapter {

	private MainServer server;
	private Context context;
	private LayoutInflater inflater;
	private ImageView iv_item_image;
	private TextView tv_item_name;
	private TextView tv_item_introduce;
	private List<MainBean> list = new ArrayList<MainBean>();
	private String[] nameArray = new String[7];
	private String[] describe = new String[7];
	public MainAdapter(Context context){
		this.context = context;
		inflater = LayoutInflater.from(context);
		server = new MainServer(context);
		
		DataInit();
	}
	
	private int[] imageArray = new int[]{
			R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo
	};
//	private String[] nameArray = new String[]{
//			"日历","课程表推送","闹钟","一周计划","关于我们"
//	};
//	private String[] describe = new String[]{
//			"日历","课程表推送","闹钟","一周计划","关于我们"
//	};
//	private String[] nameArray = new String[]{"�ֻ����","ͨѶ��ʿ","�������","�������",
//			"��������","�ֻ�ɱ��","ϵͳ�Ż�","�߼�����","��������"};
//	private int[] imageArray = new int[]{R.drawable.widget01,R.drawable.widget02,R.drawable.widget03
//			,R.drawable.widget04,R.drawable.widget05,R.drawable.widget06,
//			R.drawable.widget07,R.drawable.widget08,R.drawable.widget09};
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageArray.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	private void DataInit(){
		list = server.findAll();
		Iterator<MainBean> iterator =  list.iterator();
		int i = 0;
		while(iterator.hasNext()){
			MainBean bean = iterator.next();
			nameArray[i] = bean.getName();
			describe[i] = bean.getDescribe();
			System.out.println(nameArray[i]+describe[i]);
			i++;
		}
	}

	@Override
	public View getView(int position, View v, ViewGroup arg2) {
//		initLayout(v);
		//���봴��layout�����ռ���ӽ�ȥ,Ҳ�������ⴴ��layout�����ļ����ٰѿؼ����ý�ȥ
//		LinearLayout view = new LinearLayout(context);
//		view.setGravity(Gravity.CENTER);
//		view.setPadding(0, 10, 0, 10);
//		view.setOrientation(LinearLayout.VERTICAL);
//		
//		ImageView iv = new ImageView(context);
//		iv.setImageResource(imageArray[position]);
//		iv.setLayoutParams(new LinearLayout.LayoutParams(50, 50));
//		view.addView(iv);
//		
//		
//		TextView tv = new TextView(context);
//		tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//		tv.setText(nameArray[position]);
//		tv.setTextColor(0xffc0c0c0);
//		tv.setTextSize(16);
//		view.addView(tv);
		View view = inflater.inflate(R.layout.main_item, null);
		iv_item_image = (ImageView) view.findViewById(R.id.iv_item_image);
		tv_item_name = (TextView) view.findViewById(R.id.tv_item_name);
		tv_item_introduce = (TextView) view.findViewById(R.id.tv_item_introduce);
		iv_item_image.setImageResource(imageArray[position]);
		tv_item_name.setText(nameArray[position]);
		tv_item_introduce.setText(describe[position]);
		return view;
		
//		View view = inflater.inflate(R.layout.main_item, null);
//		ImageView iv_main = (ImageView) view.findViewById(R.id.iv_main);
//		TextView tv_main = (TextView) view.findViewById(R.id.tv_main);
//		iv_main.setImageResource(imageArray[position]);
//		
//		if(position == 0){
//			String name = sp.getString("name", nameArray[position]);
//			if("".equals(name)){
//				name = nameArray[position];
//			}
//			tv_main.setText(name);
//		}else{
//			tv_main.setText(nameArray[position]);
//		}
		
//		return view;
	}

}
