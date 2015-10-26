package com.bloodbankdemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BloodBankAdapter extends ArrayAdapter<Details> {
	private ArrayList<Details> detailsList;
	private Context mContext;

	public BloodBankAdapter(Context mContext, List<Details> detailList) {
		super(mContext, R.layout.item_blood);
		this.detailsList = (ArrayList<Details>) detailList;
		this.mContext = mContext;

	}

	@Override
	public int getCount() {
		return detailsList.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(R.layout.item_blood, null);
		Details details = detailsList.get(position);
		TextView name = (TextView) view.findViewById(R.id.name);
		TextView address = (TextView) view.findViewById(R.id.address);
		TextView phone = (TextView) view.findViewById(R.id.phone);

		name.setText(details.getName());
		address.setText(details.getAddress()+","+details.getZip());
		phone.setText(details.getPhone());

		return view;
	}

}
