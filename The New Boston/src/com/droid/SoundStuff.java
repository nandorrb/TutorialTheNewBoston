package com.droid;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener {
	
	SoundPool sp;
	int expCounter = 0;
	MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View v = new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		setContentView(v);
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		expCounter = sp.load(this, R.raw.explosion, 1);
	
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (expCounter != 0)
		sp.play(expCounter, 1, 1, 0, 0, 1);
	}

	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		//mp.start();
		return false;

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mp.release();
	}
	
	
}
