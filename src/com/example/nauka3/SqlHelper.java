package com.example.nauka3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqlHelper extends SQLiteOpenHelper{
	
	private static String nazwa_bazy = "lista_produktow";
	private static int database_version = 7;
	public SqlHelper(Context context) {
		super(context, nazwa_bazy, null, database_version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE products (id int(1) AUTOINCREMENT,name varchar(255),price varchar(255),count_products int(12));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion > oldVersion) {
			//db.execSQL("Alter table products ADd column price varchar(255);");
		 }
		if (newVersion > oldVersion) {
			db.execSQL("drop table products;");
			db.execSQL("CREATE TABLE products (id  INTEGER PRIMARY KEY,name varchar(255),price varchar(255),count_products int(12));");
		 }
		
		
	}
	
	public void addProduct(ProductEntity Product){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name",Product.getName());
		values.put("count_products", Product.getCount());
		values.put("price", Product.getPrice());
		db.insertOrThrow("products", null, values);
		
	}
	
	public void editProduct(ProductEntity Product){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name",Product.getName());
		values.put("count_products", Product.getCount());
		values.put("price", Product.getPrice());
		db.update("products", values, "id = "+Product.getId(), null);
		
	}
	
	public void deleteProduct(int id){
		SQLiteDatabase db = getWritableDatabase();
		db.delete("products",  "id = "+id, null);
		
	}
	
	public Cursor getProducts(){
		String[] columns = new String[]{"id","name","count_products","price"};
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query("products", columns, null,null,null,null,null);
		return cursor;
	}

	
	public ProductEntity getProduct(int produkt_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM products WHERE id = " + produkt_id;

        Log.d("query","query "+selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        ProductEntity pro = new ProductEntity();
        pro.setName((c.getString(c.getColumnIndex("name"))));
        pro.setCount((c.getString(c.getColumnIndex("count_products"))));
        pro.setPrice(c.getString(c.getColumnIndex("price")));

        return pro;
    }

}
