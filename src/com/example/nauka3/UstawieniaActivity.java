package com.example.nauka3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract.Document;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class UstawieniaActivity extends PreferenceActivity  {
	
	private Spinner rozmiarSelect;
	
	private TextView kolorCzcionka;
	
	private Button zapisz;
	
	private String[] option ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 addPreferencesFromResource(R.xml.preference);
		 
		 
		//setContentView(R.layout.activity_ustawienia);
		
	//	option= new String[] {"Select Font Size","8","10","12","14","16","18","20",
      //          "22","24","26","28","30","32","34","36","38","40","50"};
		
	//	rozmiarSelect = (Spinner)findViewById(R.id.rozmiarCzcionka);
	//	ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,option);
	//	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	//	rozmiarSelect.setAdapter(adapter);
	
//		kolorCzcionka = (TextView)findViewById(R.id.kolorCzcionka);
		
	//	rozmiarSelect.setOnItemSelectedListener(this);
		
	
		
		
	}
	
	   public void onItemSelected(AdapterView<?> parent, View view, 
	            int pos, long id) {
	        // An item was selected. You can retrieve the selected item using
	        // parent.getItemAtPosition(pos)
		   Log.d("rozmiar","rozmiart"+parent.getItemAtPosition(pos).toString());
		   
		  
		   
		   SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		   SharedPreferences.Editor editor = sharedPref.edit();
		   editor.putString("color", "#FFFFFF");
		   String content1 = sharedPref.getString("color", "none");
		   Log.d("cont ","cont "+content1);
		    editor.commit();
	    }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ustawienia, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
