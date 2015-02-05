package com.example.composite.activity;

import java.util.List;

import com.example.composite.IDao.IDao;
import com.example.composite.util.MyAdapter;
import com.example.composite.vo.User;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class MainActivity extends Activity {
	private List<User> list;
	private MyAdapter adapter;
	private ListView listView;
	private Context context;
	private IDao dao;
	private SearchView searchView;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		dao = new IDao(context);
		searchView = (SearchView) findViewById(R.id.searchView1);
		searchView.setIconifiedByDefault(true);
		searchView.setSubmitButtonEnabled(true);
		searchView.setOnQueryTextListener(listener);
		listView = (ListView) findViewById(R.id.listView1);
		list = dao.getData();
		adapter = new MyAdapter(list, context);
		listView.setAdapter(adapter);
		
	}
	OnQueryTextListener listener = new OnQueryTextListener() {
		
		@Override
		public boolean onQueryTextSubmit(String query) {
			// TODO Auto-generated method stub
			return true;
		}
		
		@Override
		public boolean onQueryTextChange(String newText) {
			// TODO Auto-generated method stub
			list = dao.getData1(newText);
			adapter.setList(list);
			adapter.notifyDataSetChanged();
			return false;
		}
	};
	public void onClick(View v){
		Intent intent = new Intent(context, RegistActivity.class);
		startActivityForResult(intent, 1);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1&&resultCode==1){
			list = dao.getData();
			adapter.setList(list);
			adapter.notifyDataSetChanged();
		}
	}
	

}
