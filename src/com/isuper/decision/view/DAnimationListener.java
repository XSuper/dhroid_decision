package com.isuper.decision.view;

import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Animation.AnimationListener;

public class DAnimationListener implements AnimationListener{
	
	public static final int TAG_SCALEUP = 1;
	public static final int TAG_SCALEDOWN = 2;
	public static final int TAG_ALPHAUP = 3;
	public static final int TAG_ALPHADOWN = 4;
	public static final int TAG_ROTATEUP = 5;
	public static final int TAG_ROTATEDOWN = 6;
	
	private DButton button;
	private int tag;
	
	public DAnimationListener(DButton button){
		this.button = button;
	}

	public DAnimationListener setTag(int tag){
		this.tag = tag;
		return this;
	}
	
	@Override
	public void onAnimationEnd(Animation arg0) {
		// TODO Auto-generated method stub
		switch (tag) {
		case TAG_SCALEUP:
			button.isSelect = true;
			button.params = button.getLayoutParams();
			button.params.height = button.width;
			button.params.width = button.height;
			button.setLayoutParams(button.params);
			break;
		case TAG_SCALEDOWN:
			button.isSelect = false;
			button.params = button.getLayoutParams();
			button.params.height = (int) (button.width/button.scaleProportion);
			button.params.width = (int) (button.height/button.scaleProportion);
			button.setLayoutParams(button.params);
			break;
		case TAG_ALPHAUP:
			
			break;
		case TAG_ALPHADOWN:
			button.setBackgroundResource(button.isA?button.background_b:button.background_a);
			button.isA = !button.isA;
			AnimationSet animation2 = new AnimationSet(true);
			animation2.addAnimation(button.rotate_up);
			animation2.addAnimation(button.alpha_up);
			button.startAnimation(animation2 );
			break;
		case TAG_ROTATEUP:
			
			break;
		case TAG_ROTATEDOWN:
			
			break;
		}
		
	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation arg0) {
		// TODO Auto-generated method stub
	}

}
