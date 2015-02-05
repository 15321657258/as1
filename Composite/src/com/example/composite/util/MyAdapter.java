package com.example.composite.util;

import java.util.List;

import com.example.composite.IDao.IDao;
import com.example.composite.activity.R;
import com.example.composite.vo.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
public class MyAdapter extends BaseAdapter {
	private List<User> list;
	private Context context;
	
	public MyAdapter(List<User> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}
	
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
			holder = new ViewHolder();
			holder.text_no = (TextView) convertView.findViewById(R.id.text_no);
			holder.text_name = (TextView) convertView.findViewById(R.id.text_name);
			holder.text_pwd = (TextView) convertView.findViewById(R.id.text_pwd);
			holder.button = (Button) convertView.findViewById(R.id.btn_del);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.text_no.setText(list.get(position).getId()+"");
		holder.text_name.setText(list.get(position).getName());
		holder.text_pwd.setText(list.get(position).getPwd());
		holder.button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new IDao(context).del(list.get(position).getId());
				list.remove(position);
				notifyDataSetChanged();
			}
		});
		return convertView;
	}
	class ViewHolder{
		TextView text_no,text_name,text_pwd;
		Button button;
	}

}
