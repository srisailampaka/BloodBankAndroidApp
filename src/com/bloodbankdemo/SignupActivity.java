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
import android.widget.Toast;

public class SignupActivity extends Activity {
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
		etCity = (EditText) findViewById(R.id.signup_city);
		etState = (EditText) findViewById(R.id.signup_state);
		etCountry = (EditText) findViewById(R.id.signup_country);
		etContact = (EditText) findViewById(R.id.signup_contacts);
		validation = new Validations();

		signin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				User user = new User();
				user.setFname(etFname.getText().toString());
				user.setLname(etlname.getText().toString());
				user.setUsername(etUsername.getText().toString());
				user.setPassword(etPassword.getText().toString());
				user.setSex(etSex.getSelectedItem().toString());
			
				user.setBloodGroup(etBloodgroup.getSelectedItemPosition()+"");
				user.setDob(etDateofbirth.getText().toString());
				user.setAddress(etAddress.getText().toString());
				user.setCity(etCity.getText().toString());
				user.setState(etState.getText().toString());
				user.setCountry(etCountry.getText().toString());
				user.setPhno(etContact.getText().toString());

				(new DatabaseHelper(getApplicationContext())).createStudentegistraton(user);
				Toast.makeText(getApplicationContext(), "Profile created succesfully", Toast.LENGTH_LONG).show();

			}
		});
	}

}
