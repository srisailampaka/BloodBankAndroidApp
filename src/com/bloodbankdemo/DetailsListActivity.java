package com.bloodbankdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DetailsListActivity  extends Activity{
	private Button updateButton;
	private Button donateBloodButton;
	private Button availabilityOfBloodButton;
	private Button requestForBloodButton;
	private Button contactUsButton;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_details_list);
	updateButton = (Button)findViewById(R.id.update_button);
	donateBloodButton = (Button)findViewById(R.id.donate_blood);
	availabilityOfBloodButton = (Button)findViewById(R.id.availability_blood);
	requestForBloodButton = (Button)findViewById(R.id.request_blood);
	contactUsButton = (Button)findViewById(R.id.contact_us);
     
	updateButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent= new Intent(DetailsListActivity.this,UpdateProfileActivity.class);
			startActivity(intent);
			
		}
	});
donateBloodButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent= new Intent(DetailsListActivity.this,DonateActivity.class);
			startActivity(intent);
			
		}
	});
availabilityOfBloodButton.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent= new Intent(DetailsListActivity.this,CheckForAvailabilityActivity.class);
		startActivity(intent);
		
	}
});
	
requestForBloodButton.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent= new Intent(DetailsListActivity.this,BloodRequest.class);
		startActivity(intent);
		
	}
});
contactUsButton.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent= new Intent(DetailsListActivity.this,ContactUsActivity.class);
		startActivity(intent);
		
	}
});
	}
	}

