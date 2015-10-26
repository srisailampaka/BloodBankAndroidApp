package com.bloodbankdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BloodRequest extends Activity {
	Button submit;
	private EditText etnameOfPatient;
	private EditText etGroup;
	private EditText etQuantity;
	private EditText etHosipital;
	private EditText etAddress;
	private EditText etContactNo;
	private ProgressDialog progressDialog;

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
		progressDialog = new ProgressDialog(BloodRequest.this, ProgressDialog.THEME_HOLO_LIGHT);
		progressDialog.setMessage("Please wait for a moment...");
		progressDialog.setCancelable(false);

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				progressDialog.show();
				(new Handler()).postDelayed(new Runnable() {

					@Override
					public void run() {
						progressDialog.cancel();
						Toast.makeText(getApplicationContext(), "SuccessFully send request", Toast.LENGTH_LONG).show();
						etnameOfPatient.setText("");

						etQuantity.setText("");
						etHosipital.setText("");
						etAddress.setText("");
						etContactNo.setText("");

					}
				}, 3000);

			}
		});
	}

}
