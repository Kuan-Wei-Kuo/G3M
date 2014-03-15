package com.example.navigationdrawer;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_english_list extends ListFragment
{
	private static final List<Item> items = new ArrayList<Item>();
	
	private static class Item
	{
		public final String line1;
		public final String line2;
		public final String line3;
		
		public Item(String line1, String line2,String line3)
		{
			this.line1 = line1;
			this.line2 = line2;
			this.line3 = line3;
		}
	}
	
	public static class ViewHolder 
	{
		public final TextView text1;
		public final TextView text2;
		public final TextView text3;
		
		
		public ViewHolder(TextView text1, TextView text2,TextView text3)
		{
			this.text1 = text1;
			this.text2 = text2;
			this.text3 = text3;
		}
	}
	
	private class ItemAdapter extends ArrayAdapter<Item>
	{
		public ItemAdapter(Context context)
		{
			super(context, android.R.layout.simple_list_item_2, items);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View view = convertView;
			ViewHolder holder = null;
			if(view == null)
			{
				view = LayoutInflater.from(getContext()).inflate(R.layout.english_custom_list, parent, false);
				TextView text1 = (TextView)view.findViewById(R.id.ItemTitle);
				TextView text2 = (TextView)view.findViewById(R.id.EnText);
				TextView text3 = (TextView)view.findViewById(R.id.ChText);
				view.setTag(new ViewHolder(text1, text2,text3));
				
			}
			if(holder == null && view != null)
			{
				Object tag = view.getTag();
				if(tag instanceof ViewHolder)
				{
					holder = (ViewHolder)tag;
				}
			}
			Item item = getItem(position);

			if(item != null && holder != null)
			{
				holder.text1.setText(item.line1);
				holder.text2.setText(item.line2);
				holder.text3.setText(item.line3);
			}
			return view;
		}
	}
	
	static
	{
		//在這裡新增單字
		//line1 單字+解釋
		//line2 英文句
		//line3中文句
		
		items.add(new Item("appointment  n.約會；約定", "If you phoned my secretary she'd give you an appointment.","你給我秘書打個電話, 她就會給你約定個時間。"));
		items.add(new Item("calendar  n.日曆,曆法", "He put the desk calendar on the shelf.","他把檯曆放在書架上。"));
		items.add(new Item("recruit  n.新兵,新分子,新會員 vt.使恢復,補充,徵募 vi.徵募新兵,復原", "What is the postage on this parcel?","寄這個包裹要多少錢?"));
		items.add(new Item("calculator  n.電腦,計算器", "This pocket calculator needs two batteries.","這個袖珍計算器需用兩節乾電池。"));
		items.add(new Item("secretary  n.秘書,書記,部長,大臣", "She sued for divorce on the grounds of her husband's alleged misconduct with his secretary.","她以其夫與秘書有染為由提起離婚訴訟。"));
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.listview, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		ListAdapter adapter = new ItemAdapter(getActivity());
		setListAdapter(adapter);
		
	}
	
	public void onListItemClick (ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);
		
		 Intent intent = new Intent(); 
  		 intent.setClass(getActivity(),english_detal.class);
  		 Bundle bundle = new Bundle();
         bundle.putInt("SelectTab",getArguments().getInt("position"));  //把當前點擊的節目代號傳過去
         bundle.putInt("Selectid",position);   //把節目名稱傳過去
         intent.putExtras(bundle);
  		 startActivity(intent);
		//Toast.makeText(getActivity(),"點選位置"+ position+"\n id:"+id+"\n View:"+v+"\n 當前頁面:"+getArguments().getInt("position"),Toast.LENGTH_SHORT).show();
			
	}
}

