package com.example.timemanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.timemanager.R;
import com.example.timemanager.bean.Cell;
import com.example.timemanager.utils.CalendarView;

public class CalendarActivity extends Activity  implements CalendarView.OnCellTouchListener{
	public static final String MIME_TYPE = "vnd.android.cursor.dir/vnd.timemanager.cal.date";
	public static final int REQCODE_REMARK = 30;
	private CalendarView mView = null;
	private Handler mHandler = new Handler();
	private  Button btCenter;
	private Rect ecBounds;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mView = (CalendarView)findViewById(R.id.calendar);
        mView.setOnCellTouchListener(this);
        
        if(getIntent().getAction().equals(Intent.ACTION_PICK))
        	findViewById(R.id.hint).setVisibility(View.INVISIBLE);
        if(getIntent().getAction().equals(Intent.ACTION_PICK))
        	findViewById(R.id.app).setVisibility(View.INVISIBLE);
        
        btCenter = (Button) findViewById(R.id.btCenter);
        btCenter.setText(mView.getYear() + "-" + (mView.getMonth() + 1));
        Button btLeft = (Button) findViewById(R.id.btnLeft);
        btLeft.setText("上月");
        Button btRight = (Button) findViewById(R.id.btRight);
        btRight.setText("下月");
        btLeft.setOnClickListener(new OnClickListener() { 
			public void onClick(View v) {
				mView.previousMonth(); 
				btCenter.setText(mView.getYear() + "-" + (mView.getMonth() + 1));
			}
		});
        btRight.setOnClickListener(new OnClickListener() { 
			public void onClick(View v) {
				mView.nextMonth(); 
				btCenter.setText(mView.getYear() + "-" + (mView.getMonth() + 1));
			}
		});
        
    }

	public void onTouch(Cell cell) {
		
		Intent intent = getIntent();
		String action = intent.getAction();
		if(cell.getmPaint().getColor() == Color.GRAY) {
			// 这是上月的
			mView.previousMonth(); 
			btCenter.setText(mView.getYear() + "-" + (mView.getMonth() + 1));
		} else if(cell.getmPaint().getColor() == Color.LTGRAY) {
			// 下月的
			mView.nextMonth(); 
			btCenter.setText(mView.getYear() + "-" + (mView.getMonth() + 1));
		} else {  //  本月的
			if(action.equals(Intent.ACTION_PICK) || action.equals(Intent.ACTION_GET_CONTENT)) {
				Intent ret = new Intent();
				ret.putExtra("year", mView.getYear());
				ret.putExtra("month", mView.getMonth());
				ret.putExtra("day", cell.getDayOfMonth());
				 
				// 在此让当前的View 重绘一次
				ecBounds = cell.getBound();
				mView.getDate();
				mView.getmDecoraClick().setBounds(ecBounds);
				mView.invalidate();
				
				//打开RemarkActivity
				Intent intRemark = new Intent(CalendarActivity.this, RemarkActivity.class);
				intRemark.putExtra("year", mView.getYear());
				intRemark.putExtra("month", mView.getMonth()+1);
				intRemark.putExtra("day", cell.getDayOfMonth());
				startActivityForResult(intRemark, REQCODE_REMARK);
				
			}
		}

		mHandler.post(new Runnable() {
			public void run() {
				btCenter.setText(mView.getYear() + "-" + (mView.getMonth() + 1));
				/*Toast.makeText(
						CalendarActivity.this, 
						DateUtils.getMonthString(mView.getMonth(), DateUtils.LENGTH_LONG) + " "+mView.getYear(), 
						Toast.LENGTH_SHORT).show();*/
			}
		});
	}

	//从RemarkActivity返回数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == REQCODE_REMARK) {
			if(resultCode == RESULT_OK) {
				//
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
 
}