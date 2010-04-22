package com.ezcocoa.activityandintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityTest extends Activity {
	@Override
	protected void onCreate(Bundle saveInstanceState) {
		super.onCreate(saveInstanceState);
		setContentView(R.layout.activitytest);
		
		Button button1 = (Button)findViewById(R.id.Button01);
		Button button2 = (Button)findViewById(R.id.Button02);
		
		Intent intent = getIntent();
		String text1 = intent.getStringExtra("TEXT1");
		String text2 = intent.getStringExtra("TEXT2");
		
		button1.setText(text1);
		
		OnClickListener mClickListener1 = new OnClickListener() {
			public void onClick(View v) {
				Button button1 = (Button)findViewById(R.id.Button01);
				setResult(RESULT_OK, (new Intent()).setAction(button1.getText().toString()));
				finish();
			}
		};
		
		button1.setOnClickListener(mClickListener1);
		
		
		
		
		button2.setText(text2);
		
		OnClickListener mClickListener2 = new OnClickListener() {
			public void onClick(View v) {
				Button button2 = (Button)findViewById(R.id.Button02);
				setResult(RESULT_OK, (new Intent()).setAction(button2.getText().toString()));
				finish();
			}
		};
		
		button2.setOnClickListener(mClickListener2);
	}
}
