package com.isuper.decision.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.isuper.decision.R;

public class BottomView extends LinearLayout{

	private Context context;
	private DButton decision;
	private RadioGroup bottomGroup;
	private RadioButton rb_me;
	private RadioButton rb_message;
	
	public BottomView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context);
	}
	public BottomView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	
	public BottomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
		
	}
	
	private synchronized void init(Context context){
		this.context = context;
		inflate( context,R.layout.view_bottom, this);
		decision = (DButton) findViewById(R.id.bottom_decision);
		bottomGroup = (RadioGroup) findViewById(R.id.bottom_group);
		decision.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.v("click", "dbotton click");
				
			}
		});
		bottomGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				decision.setNotSelect();
				
			}
		});
	}
	

}
