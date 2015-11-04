package com.bloodbankdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CheckForAvailabilityActivity extends Activity {
	private Spinner spinnerSex;
	Button checkButton;
	private TextView tvCheck;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_availability);
		checkButton = (Button) findViewById(R.id.check_button);
		spinnerSex = (Spinner) findViewById(R.id.spinner_sex);
		tvCheck = (TextView) findViewById(R.id.check);

		checkButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			int count=	(new DatabaseHelper(getApplicationContext())).checkAvailibilityOfBlood(spinnerSex.getSelectedItemPosition()+"");

				tvCheck.setText("Availability of blood group persons : " + count);

			}
		});
	}

}
