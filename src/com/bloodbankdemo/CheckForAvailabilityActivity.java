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
import android.widget.Spinner;
import android.widget.TextView;

public class CheckForAvailabilityActivity extends Activity{
	private Spinner spinnerSex;
	Button checkButton;
	private ProgressDialog progressDialog;
	private TextView tvCheck;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_availability);
	checkButton = (Button)findViewById(R.id.check_button);
	spinnerSex = (Spinner)findViewById(R.id.spinner_sex);
	tvCheck = (TextView)findViewById(R.id.check);
	progressDialog = new ProgressDialog(CheckForAvailabilityActivity.this,
		    ProgressDialog.THEME_HOLO_LIGHT);
		  progressDialog.setMessage("Please wait for a moment...");
		  progressDialog.setCancelable(false);

	
	checkButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			progressDialog.show();
			String url = "search.php";
			RequestParams params = new RequestParams();
			params.put("blud_group","1" );
			
			
			LoopJHttpClient.get(url, params, new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
					progressDialog.cancel();
					String resp=response.optString("count");
					tvCheck.setText(resp);
					
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
