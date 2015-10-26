package com.bloodbankdemo;

import org.apache.http.Header;
import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SignupActivity extends Activity  {
	Button signin;
	Validations validation;
private EditText etFname;
private EditText etlname;
private EditText etUsername;
private EditText etPassword;
private Spinner etSex;
private EditText etDateofbirth;
private Spinner etBloodgroup;
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
		setContentView(R.layout.activity_signup);
		
		signin = (Button) findViewById(R.id.signin_signin);
		etFname = (EditText) findViewById(R.id.signup_fname);
		etlname = (EditText) findViewById(R.id.signup_lname);
		etUsername = (EditText) findViewById(R.id.signup_username);
		etPassword = (EditText) findViewById(R.id.signup_password);
		etSex = (Spinner) findViewById(R.id.spinner_sex);
		etDateofbirth = (EditText) findViewById(R.id.signup_dob);
		etBloodgroup = (Spinner) findViewById(R.id.spinner_blood_group);
		etAddress = (EditText) findViewById(R.id.signup_address);
		etCity= (EditText) findViewById(R.id.signup_city);
		etState = (EditText) findViewById(R.id.signup_state);
		etCountry = (EditText) findViewById(R.id.signup_country);
		etContact = (EditText) findViewById(R.id.signup_contacts);
		progressDialog = new ProgressDialog(SignupActivity.this,
			    ProgressDialog.THEME_HOLO_LIGHT);
			  progressDialog.setMessage("Please wait for a moment...");
			  progressDialog.setCancelable(false);
		validation = new Validations();

		signin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressDialog.show();
				String url = "blooddonor_singup.php";
				RequestParams params = new RequestParams();
				params.put("fname",etFname.getText().toString() );
					params.put("lname",etlname.getText().toString());
					params.put("username",etUsername.getText().toString() );
					params.put("password", etPassword.getText().toString());
					params.put("sex", etSex.getSelectedItem().toString());
					params.put("bloodgroup",etBloodgroup.getSelectedItem().toString());
					params.put("dob", etDateofbirth.getText().toString());
					params.put("address", etAddress.getText().toString());
					params.put("city",etCity.getText().toString());
					params.put("state",etState.getText().toString());
					params.put("country", etCountry.getText().toString());
					params.put("phno", etContact.getText().toString());

				LoopJHttpClient.post(url, params, new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
						
						progressDialog.cancel();
						Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
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
