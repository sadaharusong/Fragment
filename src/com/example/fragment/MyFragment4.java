package com.example.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragment4 extends Fragment{
	private String code = "Thank you,Activity!";
	public MyListener listener;
	public interface MyListener
	{
		public void thank(String code);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		listener = (MyListener) activity;
		super.onAttach(activity);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment2, container,false);
		TextView tv = (TextView)view.findViewById(R.id.text66);
		String text = getArguments().get("name")+"";
		tv.setText(text);
		Toast.makeText(getActivity(), "�ѳɹ����յ�" + text, Toast.LENGTH_SHORT).show();
		Toast.makeText(getActivity(), "��Activity����code" + text, Toast.LENGTH_SHORT).show();
		listener.thank(code);
		return view;
	}
	
}
