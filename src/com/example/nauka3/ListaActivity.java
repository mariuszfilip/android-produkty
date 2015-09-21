package com.example.nauka3;

import java.util.ArrayList;
import java.util.Arrays;

import android.R.array;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity<T> extends Activity {

	private TextView name;
	private TextView price;
	private TextView count_product;
	private Button button;
	private SqlHelper ZarzadcaBazy;
	
	private int id_prod;
	
	protected ListView listview;
	protected ArrayList<ElementList> list;
	protected ArrayAdapter<T> adapter;
	protected Object item;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		//SharedPreferences.Editor editor = sharedPref.edit();
		//editor.putString("color", "#FFFFFF");
		String content1 = sharedPref.getString("styl", "1"); 
		Log.d("content1 ","cont "+content1);
		Log.d("theme","theme name "+R.style.testowy);
		if(content1.equals("1")){
			setTheme(R.style.testowy);
		}else{
			setTheme(R.style.medium);
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista);
		listview = (ListView) findViewById(R.id.listview);
		
		

		ZarzadcaBazy = new SqlHelper(this);
		Cursor k = ZarzadcaBazy.getProducts();
		list = new ArrayList<ElementList>();
		while (k.moveToNext()) {
			Log.d("id wiersza","id "+k.getInt(0));
			//Log.d("id wiersza 2","id "+k.getString(0));
			list.add(new ElementList(k.getInt(0), k.getString(1)+" "+k.getString(2)+" "+k.getString(	3)));
		}
		final ArrayAdapter adapter = new ArrayAdapter(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);
		
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				 String value = list.get(position).getName();
				 Log.d("name","name"+value);
				 int id_item = list.get(position).getId();
				 Log.d("id item", "listy item "+id_item);
				createWindow(id_item);
				//Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
				
				
			}
		});
		
		

	}
	public void createWindow(int id){
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.activity_edycja);
		dialog.setTitle("Mariusz "+id);
		id_prod = id;
		
		

		//SqlHelper ZarzadcaBazy = new SqlHelper(this);
		ProductEntity Product = ZarzadcaBazy.getProduct(id);
		//ProductEntity Product = ZarzadcaBazy.getProduct(id);
		
		name = (TextView)dialog.findViewById(R.id.name_edit);
		price = (TextView)dialog.findViewById(R.id.price_edit);
		count_product = (TextView)dialog.findViewById(R.id.count_product_edit);
		

		button = (Button)dialog.findViewById(R.id.wyslij_edit);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ProductEntity product = new ProductEntity();
				product.setCount(count_product.getText().toString());
				product.setName(name.getText().toString());
				product.setPrice(price.getText().toString());
				product.setId(id_prod);
				ZarzadcaBazy.editProduct(product);
				reakcja();
				
			}
		});
		//Log.d("name2",Product.getName());
		
		//price.setText(Product.getPrice());
		//count_product.setText(Product.getCount());
		name.setText(Product.getName());
		price.setText(Product.getPrice());
		count_product.setText(Product.getCount());
		
		dialog.show();
		
		


		
	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.about_author) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void reakcja(){
		Intent  i = new Intent(this,ListaActivity.class);
		startActivity(i);
	}
}
