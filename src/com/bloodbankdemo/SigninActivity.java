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

public class SigninActivity extends Activity {

		// TODO Auto-generated constructor stub

	Button login;
	Button signin;
	EditText name,password;
	Validations validation;
	String getName,getPassword;
	String returnname,returnpassword;
	private ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);
	login = (Button)findViewById(R.id.login_login);
	signin = (Button)findViewById(R.id.signin_button);
	
	
	name = (EditText)findViewById(R.id.login_editname);
	password = (EditText)findViewById(R.id.login_editpadssword);
	progressDialog = new ProgressDialog(SigninActivity.this,
		    ProgressDialog.THEME_HOLO_LIGHT);
		  progressDialog.setMessage("Please wait for a moment...");
		  progressDialog.setCancelable(false);

	validation = new Validations();
	signin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	}) ;
	login.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			getName = name.getText().toString();
			getPassword = password.getText().toString();
			returnname = validation.userName(getName);
			returnpassword=validation.userName(getPassword);
			if(!returnname.equals("empty")&&!returnpassword.equals("empty")){
				progressDialog.show();
					String url = "login.php";
					RequestParams params = new RequestParams();
					params.put("user_name",name.getText().toString() );
					params.put("pwd", password.getText().toString());
					
					LoopJHttpClient.get(url, params, new JsonHttpResponseHandler() {
						@Override
						public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
							progressDialog.cancel();
							
							Intent intent = new Intent(SigninActivity.this,LoginActivity.class);
							startActivity(intent);
						}

						@Override
						public void onFailure(int statusCode, Header[] headers, String responseString,
								Throwable throwable) {
							progressDialog.cancel();
							
						}
					});

				

			}}

});
	}}