package com.example.nauka3;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button  przycisk1;
	Button  przycisk2;
	Button  przycisk3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		przycisk1 = (Button)findViewById(R.id.button1);
	        
	    przycisk1.setOnClickListener(new OnClickListener() {
	        	 
	            public void onClick(View v) {
	            	reakcja();
	            }
	     });
	    
		przycisk2 = (Button)findViewById(R.id.button2);
        
	    przycisk2.setOnClickListener(new OnClickListener() {
	        	 
	            public void onClick(View v) {
	            	reakcja2();
	            }
	     });
	    
		przycisk3 = (Button)findViewById(R.id.button3);
        
	    przycisk3.setOnClickListener(new OnClickListener() {
	        	 
	            public void onClick(View v) {
	            	reakcja3();
	            }
	     });
	}
	
	public void reakcja(){
		Intent  i = new Intent(this,ListaActivity.class);
		startActivity(i);
	}
	
	public void reakcja2(){
		Intent  i = new Intent(this,DodajActivity.class);
		startActivity(i);
	}
	
	public void reakcja3(){
		Intent  i = new Intent(this,UstawieniaActivity.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		 MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.menu.main, menu);
		    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Log.d("o Autorze", null, null);
			return true;
		}else if(id == R.id.about_author){
			Log.d("o Autorze", null, null);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
