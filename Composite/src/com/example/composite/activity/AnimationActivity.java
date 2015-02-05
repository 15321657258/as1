package com.example.composite.activity;

import com.example.composite.IDao.IDao;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class AnimationActivity extends Activity {
	private ImageView imageView;
	private IDao dao; 
	private Context context;
	private RotateAnimation rotateAnimation;
	private AlphaAnimation alphaAnimation;
	private AnimationSet set;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		context = this;
		imageView = (ImageView) findViewById(R.id.imageView1);
		dao = new IDao(context);
		imageView.setImageBitmap(dao.getBitmap("ic_launcher.png"));
		rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
		rotateAnimation.setDuration(1000);
		rotateAnimation.setRepeatCount(10);
		rotateAnimation.setRepeatMode(Animation.REVERSE);
		rotateAnimation.start();
		imageView.setAnimation(rotateAnimation);
		rotateAnimation.setAnimationListener(listener);
		
	}
	AnimationListener listener1 = new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(context, MainActivity.class);
			startActivity(intent);
		}
	};
	AnimationListener listener = new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			alphaAnimation = new AlphaAnimation(1, 0);
			alphaAnimation.setDuration(2000);
			alphaAnimation.start();
			imageView.setAnimation(alphaAnimation);
			alphaAnimation.setAnimationListener(listener1);
		}
	};
}
