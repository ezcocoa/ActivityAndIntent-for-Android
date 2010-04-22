package com.ezcocoa.activityandintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {
    /** Called when the activity is first created. */
    static final int GET_CODE = 1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText edit1 = (EditText)findViewById(R.id.editText1);
				EditText edit2 = (EditText)findViewById(R.id.editText2);
				
				Intent intent = new Intent(Main.this, ActivityTest.class);
				
				intent.putExtra("TEXT1", edit1.getText().toString());
				intent.putExtra("TEXT2", edit2.getText().toString());
				
				startActivityForResult(intent, GET_CODE);
			}
        });
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	TextView view = (TextView)findViewById(R.id.textView1);
    	if (requestCode == GET_CODE) {
    		if (resultCode == RESULT_OK) {
    			view.setText(data.getAction());
    		}
    	}
    }
}