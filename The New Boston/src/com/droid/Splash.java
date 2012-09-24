package com.droid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class Splash extends Activity {

	MediaPlayer song;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		song = MediaPlayer.create(Splash.this, R.raw.fallingapart);
		song.seekTo(7500);
		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("music", true);
		if (music)
			song.start();

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

					Intent begin = new Intent("android.intent.action.MENU");
					startActivity(begin);

				}
			}
		};

		timer.start();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		song.stop();
		finish();
	}

}
