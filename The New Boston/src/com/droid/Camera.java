package com.droid;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {

	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	Bitmap bmp;
	final private int cameraData=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		InputStream is=getResources().openRawResource(R.drawable.tux);
		bmp=BitmapFactory.decodeStream(is);
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		ib = (ImageButton)findViewById(R.id.ibTakePic);
		b = (Button)findViewById(R.id.bSetWall);
		iv = (ImageView)findViewById(R.id.ivReturnedPic);
		ib.setOnClickListener(this);
		b.setOnClickListener(this);
	}

	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.ibTakePic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i,cameraData);
			break;
		case R.id.bSetWall:
			
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extras=data.getExtras();
			bmp = (Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);
		}
		
		
	}

	
}
