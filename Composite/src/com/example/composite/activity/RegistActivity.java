package com.example.composite.activity;

import com.example.composite.IDao.IDao;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistActivity extends Activity {
	private Button button;
	private EditText edit_name,edit_pwd;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		context = this;
		button = (Button) findViewById(R.id.button1);
		edit_name = (EditText) findViewById(R.id.edit_name);
		edit_pwd = (EditText) findViewById(R.id.edit_pwd);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = edit_name.getText().toString();
				String pwd = edit_pwd.getText().toString();
				new IDao(context).add(name, pwd);
				setResult(1);
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_regist, menu);
		return true;
	}

}
