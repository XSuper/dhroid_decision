package com.isuper.decision.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

import com.isuper.decision.R;

public class DButton extends Button {
	
	
	
	public static final int STATE_NO = 0;
	public static final int STATE_SCALEUP = 1;
	public static final int STATE_SCALEDOWN = -1;
	
	//按钮的背景
	protected int background_a = R.drawable.bottom_decision_1;
	protected int background_b = R.drawable.bottom_decision_2;
	
	protected float scaleProportion = 1.6f;//按钮缩放比例
	protected float scale = 1;//按钮缩放比例
	protected boolean isSelect = true;
	public boolean isA = true;
	protected int state = STATE_NO; 
	
	protected ScaleAnimation scale_up;
	protected ScaleAnimation scale_down;
	protected AlphaAnimation alpha_up;
	protected AlphaAnimation alpha_down;
	protected RotateAnimation rotate_up;
	protected RotateAnimation rotate_down;
	
	
	protected boolean isload = false;
	protected int width,height;
	protected long durationMillis = 1000;//动画延时
	protected LayoutParams params;

	public DButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	public DButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}
	
	/**
	 * 初始化
	 */
	private void init(){
		setBackgroundResource(background_a);
		isSelect = true;
		isA = true;
		
		//initAnimation();
		
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.save();
		
		switch (state) {
		case STATE_NO:
			
			break;
		case STATE_SCALEUP:
			canvas.scale(scale+=0.01, scale+=0.01,width/2,height);
			break;
		case STATE_SCALEDOWN:
			canvas.scale(scale-=0.01, scale-=0.01,width/2,height);
			break;
		}
		if(scale>=1||scale<=1/scaleProportion){
			scale = 1;
			state = STATE_NO;
		}else{
			invalidate();
		}
		super.draw(canvas);
		canvas.restore();
		
		
		
		if(!isload){
			width = getWidth();
			height = getHeight();
			initAnimation();
			isload = true;
		}
		
	}

	private void initAnimation(){
		scale_up = new ScaleAnimation(1, 1*scaleProportion, 1, 1*scaleProportion,width/2,height/2); 

		scale_up.setDuration(durationMillis );
		scale_up.setAnimationListener(new DAnimationListener(this).setTag(DAnimationListener.TAG_SCALEUP));
		
		scale_down = new ScaleAnimation(1, 1/scaleProportion, 1, 1/scaleProportion,width/2,height/2);
		scale_down.setDuration(durationMillis);
		scale_down.setAnimationListener(new DAnimationListener(this).setTag(DAnimationListener.TAG_SCALEDOWN));
		
		alpha_up = new AlphaAnimation(0.2f, 1);
		alpha_up.setDuration(durationMillis/2);
		alpha_up.setAnimationListener(new DAnimationListener(this).setTag(DAnimationListener.TAG_ALPHAUP));
		
		alpha_down = new AlphaAnimation(1, 0.2f);
		alpha_down.setDuration(durationMillis/2);
		alpha_down.setAnimationListener(new DAnimationListener(this).setTag(DAnimationListener.TAG_ALPHADOWN));
		
		rotate_up = new RotateAnimation(0, 360, width/2, height/2);
		rotate_up.setDuration(durationMillis);
		rotate_up.setAnimationListener(new DAnimationListener(this).setTag(DAnimationListener.TAG_ROTATEUP));
		
		rotate_down = new RotateAnimation(360, 0, width/2, height/2);
		rotate_down.setDuration(durationMillis);
		rotate_down.setAnimationListener(new DAnimationListener(this).setTag(DAnimationListener.TAG_ROTATEDOWN));
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:
			aniamation();
			break;
		}
		return super.onTouchEvent(event);
	}
	
	
	private  void aniamation() {
		// TODO Auto-generated method stub
		if(isSelect){
			AnimationSet animation = new AnimationSet(true);
			animation.addAnimation(rotate_down);
			animation.addAnimation(alpha_down);
			startAnimation(animation);
		}else{
			state = STATE_SCALEUP;
			isSelect = true;
			scale = 1/scaleProportion;
			invalidate();
			
		}
		
	}
	
	
	public void setNotSelect(){
		state = STATE_SCALEDOWN;
		isSelect = false;
		scale = 1;
		invalidate();
		
		
	}
	
}
