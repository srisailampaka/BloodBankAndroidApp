package com.bloodbankdemo;

import org.apache.http.Header;
import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UpdateProfileActivity  extends Activity{

		// TODO Auto-generated constructor stub
			 private Button updateButton;
			Validations validation;
		private TextView tvFname;
		private TextView tvlname;
		private TextView tvUsername;
		private EditText etPassword;
		private TextView tvSex;
		private TextView tvDateofbirth;
		private TextView tvBloodgroup;
		private EditText etAddress;
		private EditText etCity;
		private EditText etState;
		private EditText etCountry;
		private EditText etContact;
		private ProgressDialog progressDialog;
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_updateprofile);
				updateButton = (Button) findViewById(R.id.update_button);
				tvFname = (TextView) findViewById(R.id.fname_tv);
				tvlname = (TextView) findViewById(R.id.lname_tv);
				tvUsername = (TextView) findViewById(R.id.username_tv);
				etPassword = (EditText) findViewById(R.id.signup_password);
				tvSex = (TextView) findViewById(R.id.sex_text);
				tvDateofbirth = (TextView) findViewById(R.id.dob_tv);
				tvBloodgroup = (TextView) findViewById(R.id.blood_group_tv);
				etAddress = (EditText) findViewById(R.id.signup_address);
				etCity= (EditText) findViewById(R.id.signup_city);
				etState = (EditText) findViewById(R.id.signup_state);
				etCountry = (EditText) findViewById(R.id.signup_country);
				etContact = (EditText) findViewById(R.id.signup_contacts);
				progressDialog = new ProgressDialog(UpdateProfileActivity.this,
					    ProgressDialog.THEME_HOLO_LIGHT);
					  progressDialog.setMessage("Please wait for a moment...");
					  progressDialog.setCancelable(false);
				validation = new Validations();

				updateButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						progressDialog.show();
						String url = "blooddonor_updateprofile.php";
						RequestParams params = new RequestParams();
						params.put("fname",tvFname.getText().toString() );
							params.put("lname",tvlname.getText().toString());
							params.put("username",tvUsername.getText().toString() );
							params.put("password", etPassword.getText().toString());
							params.put("sex", tvSex.getText().toString());
							params.put("bloodgroup",tvBloodgroup.getText().toString());
							params.put("dateofbirth", tvDateofbirth.getText().toString());
							params.put("address", etAddress.getText().toString());
							params.put("city",etCity.getText().toString());
							params.put("state",etState.getText().toString());
							params.put("country", etCountry.getText().toString());
							params.put("contact", etContact.getText().toString());

						LoopJHttpClient.post(url, params, new JsonHttpResponseHandler() {
							@Override
							public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
								
								progressDialog.cancel();
								Intent intent = new Intent(UpdateProfileActivity.this, LoginActivity.class);
								startActivity(intent);
							}

							@Override
							public void onFailure(int statusCode, Header[] headers, String responseString,
									Throwable throwable) {
								progressDialog.cancel();
							}
						});
						

					}
				});
			}

	}

