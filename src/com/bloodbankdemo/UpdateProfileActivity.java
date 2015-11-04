package com.bloodbankdemo;

import org.apache.http.Header;
import org.json.JSONArray;
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
import android.widget.TextView;
import android.widget.Toast;

public class UpdateProfileActivity extends Activity {

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
	private Button deleteButton;
	private ProgressDialog progressDialog;
	private SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_updateprofile);
		sharedpreferences = getSharedPreferences("bloodPref", Context.MODE_PRIVATE);
		updateButton = (Button) findViewById(R.id.update_button);
		deleteButton = (Button) findViewById(R.id.delete);
		tvFname = (TextView) findViewById(R.id.fname_tv);
		tvlname = (TextView) findViewById(R.id.lname_tv);
		tvUsername = (TextView) findViewById(R.id.username_tv);
		etPassword = (EditText) findViewById(R.id.signup_password);
		tvSex = (TextView) findViewById(R.id.sex_text);
		tvDateofbirth = (TextView) findViewById(R.id.dob_tv);
		tvBloodgroup = (TextView) findViewById(R.id.blood_group_tv);
		etAddress = (EditText) findViewById(R.id.signup_address);
		etCity = (EditText) findViewById(R.id.signup_city);
		etState = (EditText) findViewById(R.id.signup_state);
		etCountry = (EditText) findViewById(R.id.signup_country);
		etContact = (EditText) findViewById(R.id.signup_contacts);
		progressDialog = new ProgressDialog(UpdateProfileActivity.this, ProgressDialog.THEME_HOLO_LIGHT);
		progressDialog.setMessage("Please wait for a moment...");
		progressDialog.setCancelable(false);
		validation = new Validations();
		User user = (new DatabaseHelper(getApplicationContext()))
				.getStudentLogin(sharedpreferences.getString("id", "0"));
		tvFname.setText(user.getFname());
		tvlname.setText(user.getLname());
		tvUsername.setText(user.getUsername());
		tvSex.setText(user.getSex());
		etContact.setText(user.getPhno());
		
		String[] list=getResources().getStringArray(R.array.blood_group);
		tvBloodgroup.setText(list[Integer.parseInt(user.getBloodGroup())]);
		etAddress.setText(user.getAddress());
		etCity.setText(user.getCity());
		etState.setText(user.getState());
		etPassword.setText(user.getPassword());
		etCountry.setText(user.getCountry());
		tvDateofbirth.setText(user.getDob());

		updateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				(new DatabaseHelper(getApplicationContext())).updateTheValues(sharedpreferences.getString("id", "0"),
						etAddress.getText().toString(), etContact.getText().toString(), etCity.getText().toString(),
						etState.getText().toString(), etCountry.getText().toString(), etPassword.getText().toString());

				Toast.makeText(getApplicationContext(), "Profile updated succesfully", Toast.LENGTH_LONG).show();

			}
		});
		deleteButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				(new DatabaseHelper(getApplicationContext())).deleteThevalue(sharedpreferences.getString("id", "0"));

				Toast.makeText(getApplicationContext(), "Profile Delete succesfully", Toast.LENGTH_LONG).show();

			}
		});
	}

}
