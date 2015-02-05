package com.example.composite.IDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.composite.vo.User;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class IDao {
	private Context context;
	private MyHelper helper;
	private SQLiteDatabase database;
	public IDao(Context context) {
		super();
		this.context = context;
		helper = new MyHelper(context, "ni.db", null, 1);
	}
	public Bitmap getBitmap(String name){
		Bitmap bitmap = null;
		InputStream in = null;
		AssetManager am = context.getAssets();
		try {
			in = am.open(name);
			bitmap = BitmapFactory.decodeStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bitmap;
	}
	public void del(int id){
		database = helper.getWritableDatabase();
		database.delete("user", "id=?", new String[]{id+""});
		database.close();
	}
	public void add(String name,String pwd){
		database = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("pwd", pwd);
		database.insert("user", null, values);
		database.close();
	}
	public List<User> getData(){
		List<User> list = new ArrayList<User>();
		database = helper.getReadableDatabase();
		Cursor cursor = database.query("user", null, null, null, null, null, null);
		while(cursor.moveToNext()){
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
			list.add(new User(id, name, pwd));
		}
		cursor.close();
		database.close();
		return list;
	}
	public List<User> getData1(String name){
		List<User> list = new ArrayList<User>();
		database = helper.getReadableDatabase();
		Cursor cursor = database.query("user", null, "name like ?", new String[]{"%"+name+"%"}, null, null, null);
		while(cursor.moveToNext()){
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String name1 = cursor.getString(cursor.getColumnIndex("name"));
			String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
			list.add(new User(id, name1, pwd));
		}
		cursor.close();
		database.close();
		return list;
	}
	
}
