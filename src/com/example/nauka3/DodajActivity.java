package com.example.nauka3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DodajActivity extends Activity {

	private TextView name;
	private TextView price;
	private TextView count_product;
	private SqlHelper ZarzadcaBazy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dodaj);
		
		ZarzadcaBazy = new SqlHelper(this);
		name = (TextView)findViewById(R.id.name);
		price = (TextView)findViewById(R.id.price);
		count_product = (TextView)findViewById(R.id.count_product);
		
		Button button = (Button)findViewById(R.id.wyslij);
		
	
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ProductEntity product = new ProductEntity();
				product.setCount(count_product.getText().toString());
				product.setName(name.getText().toString());
				product.setPrice(price.getText().toString());
				
				ZarzadcaBazy.addProduct(product);
				
				reakcja();
				
			}
		});
		
	
		
		
	}
	
	public void reakcja(){
		Intent  i = new Intent(this,ListaActivity.class);
		startActivity(i);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodaj, menu);
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
