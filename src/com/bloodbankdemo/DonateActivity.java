package com.bloodbankdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DonateActivity extends Activity {
	private Button findDonorButton;
	private Button viewAllButton;
	

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate_blood);

		findDonorButton=(Button)findViewById(R.id.find_donor);
		viewAllButton=(Button)findViewById(R.id.view_donor);
		
		findDonorButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DonateActivity.this,FindAllBankActivity.class);
				startActivity(intent);
				
			}
		});
	
viewAllButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DonateActivity.this, AllBloodBankActivity.class);
				startActivity(intent);

			}
		});

	}
	

}
