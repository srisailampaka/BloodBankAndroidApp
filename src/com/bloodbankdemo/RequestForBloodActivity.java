package com.bloodbankdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RequestForBloodActivity extends Activity{
          
	Button contact,admin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_contactforblood);
	 contact = (Button)findViewById(R.id.contactforblood_contact);
	 admin = (Button)findViewById(R.id.contactforblood_admin);
	 
	contact.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent request = new Intent(RequestForBloodActivity.this,BloodRequest.class);
			startActivity(request);
		}
	});
	admin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent request = new Intent(RequestForBloodActivity.this,BloodRequest.class);
			startActivity(request);
			
		}
	});
	
	
	
	}
}
