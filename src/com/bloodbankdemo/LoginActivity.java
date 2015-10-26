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
import android.widget.Toast;

public class LoginActivity extends Activity{

	Button login,signup;
	EditText name,password;
	Validations validation;
	String getName,getPassword;
	String returnname,returnpassword;
	private ProgressDialog progressDialog;
	private SharedPreferences sharedpreferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);
	sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
	login = (Button)findViewById(R.id.login_login);
	signup=(Button)findViewById(R.id.sinup);
	name = (EditText)findViewById(R.id.login_editname);
	password = (EditText)findViewById(R.id.login_editpadssword);
	progressDialog = new ProgressDialog(LoginActivity.this,
		    ProgressDialog.THEME_HOLO_LIGHT);
		  progressDialog.setMessage("Please wait for a moment...");
		  progressDialog.setCancelable(false);

	validation = new Validations();
	signup.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
			startActivity(intent);
			
		}
	});
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
							try {
								if(response.getInt("error")==1)
								{
									Toast.makeText(getApplicationContext(), response.getString("message"), Toast.LENGTH_LONG).show();
								}else{
								 SharedPreferences.Editor editor = sharedpreferences.edit();
						            
						            editor.putString("sno",response.optString("sno"));
						            editor.commit();
								
								Intent intent = new Intent(LoginActivity.this,DetailsListActivity .class);
								startActivity(intent);
								
							} }catch (Exception e) {
								// TODO: handle exception
							}
							
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
