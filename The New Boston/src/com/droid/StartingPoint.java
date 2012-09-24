package com.droid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoint extends Activity {
    /** Called when the activity is first created. */ 
	
	TextView display;
	Button add;
	Button sub;
	static int counter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      counter=0;
      init();
      
      
    }  
    
    
    private void init() {
		// TODO Auto-generated method stub
    	 display = (TextView)findViewById(R.id.tvNumber);
      	add = (Button)findViewById(R.id.bAddOne);
      	sub = (Button)findViewById(R.id.bSubOne);
      	
      	add.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter++;
				display.setText("Your total is " + counter);
			}
		});
sub.setOnClickListener(new View.OnClickListener() {
			
		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter--;
				display.setText("Your total is " + counter);
			}
		});
      	
	}


	
	
}