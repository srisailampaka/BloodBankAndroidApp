package com.bloodbankdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;

public class BloodRequest extends Activity {
	Button submit;
	private EditText etnameOfPatient;
	private EditText etGroup;
	private EditText etQuantity;
	private EditText etHosipital;
	private EditText etAddress;
	private EditText etContactNo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bloodrequest);
		submit = (Button) findViewById(R.id.bloodreuest_submit);
		etnameOfPatient = (EditText) findViewById(R.id.et_nameofpatient);

		etQuantity = (EditText) findViewById(R.id.et_quantity);
		etHosipital = (EditText) findViewById(R.id.et_hospital);
		etAddress = (EditText) findViewById(R.id.et_address);
		etContactNo = (EditText) findViewById(R.id.et_contact_no);
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				/*
				 * Intent intent = new
				 * Intent(BloodRequest.this,HomeActivity.class);
				 * startActivity(intent);
				 */

			}
		});
	}

}
