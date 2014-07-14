package com.isuper.decision.view;

import java.util.Timer;
import java.util.TimerTask;

import com.isuper.decision.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class MButton extends View{

	private Paint paint;
	private int background_a = R.drawable.bottom_decision_1;
	private int background_b = R.drawable.bottom_decision_2;
	
	protected float scaleProportion = 2;//°´Å¥Ëõ·Å±ÈÀý
	protected boolean isSelect = true;
	public boolean isA = true;
	
	int animationType = 0;
	
	public static final int SCALEUP =1;
	public static final int SCALEDOWN =2;
	public static final int ALPHAUP =3;
	public static final int ALPHADOWN =4;
	public static final int ROTATEUP =5;
	public static final int ROTATEDOWN =6;
	
	private float degrees =0;
	private float scale = 1;
	private float alpha = 1;
	
	
	
	Timer timer;
	TimerTask validateTask;
	
	
	
	
	public MButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
		
	}

	private void init() {
		paint = new Paint();
		timer = new Timer();
		
		validateTask = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				postInvalidate();
			}
		};
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		switch (animationType) {
		case SCALEUP:
			scale(canvas, 0.1f);
			break;
		case SCALEDOWN:
			scale(canvas, -0.001f);
			break;
		case ALPHAUP:
			alpha(canvas, 0.001f);
			break;
		case ALPHADOWN:
			alpha(canvas, -0.1f);
			
			break;
		case ROTATEUP:
			rotate(canvas, 1);
			break;
		case ROTATEDOWN:
			rotate(canvas,-1);
			
			break;
			

		}
		
	}
	
	
	private void reset(){
		degrees = 0;
		scale = 1;
		alpha = 1;
		
	}
	private void scale(Canvas canvas,float value){
		canvas.save();
		canvas.scale(scale+=value, scale+=value);
		super.draw(canvas);
		canvas.restore();
		if(scale>=scaleProportion||scale<=1/scaleProportion){
			timer.cancel();
			reset();
		}
	}
	private void rotate(Canvas canvas,float value){
		canvas.save();
		canvas.rotate(degrees+=value, getWidth()/2, getHeight()/2);
		super.draw(canvas);
		canvas.restore();
		if(degrees>=450||scale<=-450){
			timer.cancel();
			reset();
		}
	}
	private void alpha(Canvas canvas,float value){
		super.draw(canvas);
		setAlpha(alpha+=value);
		if(alpha>=1||alpha<=0.2){
			timer.cancel();
			reset();
		}
	}
	
	public void runAnimation(int animationType){
		this.animationType = animationType;
		timer.cancel();
		timer.schedule(validateTask, 0, 20);
		
	}
}
