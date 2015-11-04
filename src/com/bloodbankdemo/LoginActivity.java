package com.bloodbankdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	Button login, signup;
	EditText name, password;
	Validations validation;
	String getName, getPassword;
	String returnname, returnpassword;
	private ProgressDialog progressDialog;
	private SharedPreferences sharedpreferences;
	SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		editor = getSharedPreferences("bloodPref", MODE_PRIVATE).edit();
		login = (Button) findViewById(R.id.login_login);
		signup = (Button) findViewById(R.id.sinup);
		name = (EditText) findViewById(R.id.login_editname);
		password = (EditText) findViewById(R.id.login_editpadssword);

		validation = new Validations();
		signup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
				startActivity(intent);

			}
		});
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {

					User student = (new DatabaseHelper(getApplicationContext()))
							.getStudentLogin(name.getText().toString(), password.getText().toString());
					if (student != null) {
						editor.putString("id", student.getSno());
						editor.commit();

						name.setText("");
						password.setText("");
						Intent intent = new Intent(LoginActivity.this, DetailsListActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(getApplicationContext(), "plese check the login Details", Toast.LENGTH_LONG)
								.show();
					}
				} catch (CursorIndexOutOfBoundsException e) {
					Toast.makeText(getApplicationContext(), "plese check the login Details", Toast.LENGTH_LONG).show();
				}

			}
		});

	}
}
