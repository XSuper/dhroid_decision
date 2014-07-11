package com.isuper.decision.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.isuper.decision.R;

public class BottomView extends LinearLayout{

	private Context context;
	private ImageView decision;
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
		decision = (ImageView) findViewById(R.id.bottom_decision);
		decision.setTag(1);
		bottomGroup = (RadioGroup) findViewById(R.id.bottom_group);
		setDecisionButtonClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	/**
	 * 
	 * @param listener
	 */
	public void setDecisionButtonClickListener(final OnClickListener listener){
		// TODO Auto-generated method stub
		decision.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(final View view) {
				Animation animation = new RotateAnimation(0, 450, view.getWidth()/2, view.getHeight()/2);
				Animation animation2 = new  AlphaAnimation(1, 0.1f);
				animation2.setDuration(500);
				animation.setDuration(500);
				AnimationSet animationSet = new AnimationSet(true);
				animationSet.addAnimation(animation);
				animationSet.addAnimation(animation2);
				// TODO Auto-generated method stub
				view.startAnimation(animationSet);
				animationSet.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation arg0) {
						// TODO Auto-generated method stub
						if(((Integer)view.getTag())==1){
							view.setBackgroundResource(R.drawable.bottom_decision_2);
							view.setTag(2);
						}else{
							view.setBackgroundResource(R.drawable.bottom_decision_1);
							view.setTag(1);
						}
						Animation animation = new RotateAnimation(450, 0, view.getWidth()/2, view.getHeight()/2);
						Animation animation2 = new  AlphaAnimation(0.1f, 1);
						animation2.setDuration(500);
						animation.setDuration(500);
						AnimationSet animationSet2 = new AnimationSet(true);
						animationSet2.addAnimation(animation);
						animationSet2.addAnimation(animation2);
						view.startAnimation(animationSet2);
					}
				});
				listener.onClick(view);
			}
		});
	}
	

}
