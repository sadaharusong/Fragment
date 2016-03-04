package com.example.fragment;

import com.example.fragment.MyFragment4.MyListener;
import com.example.fragment.R.id;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends Activity implements MyListener{
	private EditText editText;
	private Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity4);
		editText = (EditText)findViewById(R.id.editText);
		send = (Button)findViewById(R.id.send);
		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = editText.getText().toString();
				MyFragment4 fragment4 = new MyFragment4();
				Bundle bundle = new Bundle();
				bundle.putString("name", text);
				fragment4.setArguments(bundle);
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
				beginTransaction.add(R.id.layout, fragment4, "fragemt4");
				beginTransaction.commit();
				Toast.makeText(MainActivity4.this, "向fragment发送数据" + text, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity4, menu);
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

	@Override
	public void thank(String code) {
		// TODO Auto-generated method stub
		Toast.makeText(MainActivity4.this, "已成功接收到" + code + "，客气了！", Toast.LENGTH_SHORT).show();
	}
}
