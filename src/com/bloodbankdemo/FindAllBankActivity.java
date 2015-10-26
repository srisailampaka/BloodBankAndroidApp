package com.bloodbankdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class FindAllBankActivity extends Activity {
	private ListView listview;
	ArrayList<Details> detailList = new ArrayList<Details>();
	ArrayList<Details> upDatedetailList = new ArrayList<Details>();
	private EditText editText;
	private Button check;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find_one_all_activity);
		editText = (EditText) findViewById(R.id.editText1);
		check = (Button) findViewById(R.id.button1);
		check.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String zip = editText.getText().toString();
				searchTheBloodDonor(zip);
			}
		});
		listview = (ListView) findViewById(R.id.listView1);

		Details details1 = new Details();
		details1.setName("Panama City - ML King Donor Center");
		details1.setAddress("2696 MLK Jr. Blvd. Hwy 77N Panama City, FL");
		details1.setZip(32405);
		details1.setPhone("(850) 785-9398");
		detailList.add(details1);

		Details details2 = new Details();
		details2.setName("Rockledge Donor Center");
		details2.setAddress("956 S US 1 Rockledge, FL");
		details2.setZip(32955);
		details2.setPhone("(321) 632-2052");
		detailList.add(details2);

		Details details3 = new Details();
		details3.setName("Titusville Donor Center");
		details3.setAddress("3880 South Washington AveSuite 210 and 212 Titusville, FL");
		details3.setZip(32780);
		details3.setPhone("(321) 267-6712");
		detailList.add(details3);

		Details details4 = new Details();
		details4.setName("Melbourne Donor Center");
		details4.setAddress("789 South Babcock St Suite 127 Melbourne, FL");
		details4.setZip(32901);
		details4.setPhone("(321) 768-8585");
		detailList.add(details4);

		Details details5 = new Details();
		details5.setName("Ft. Lauderdale - Commercial Donor Center");
		details5.setAddress("871 E. Commercial Blvd Oakland Park, FL");
		details5.setZip(33334);
		details5.setPhone("(954) 233-0657");
		detailList.add(details5);

		Details details6 = new Details();
		details6.setName("Coral Springs Donor Center");
		details6.setAddress("1855 University Dr Suite 1827 Coral Springs, FL ");
		details6.setZip(33071);
		details6.setPhone("(954) 282-5195");
		detailList.add(details6);

		

	}

	protected void searchTheBloodDonor(String zip) {
		upDatedetailList.clear();

		for (int i = 0; i < detailList.size(); i++) {
			if (detailList.get(i).getZip() == Integer.parseInt(zip)) {
				upDatedetailList.add(detailList.get(i));
			}
			BloodBankAdapter adapter = new BloodBankAdapter(getApplicationContext(), upDatedetailList);
			listview.setAdapter(adapter);
		}
	}

}
