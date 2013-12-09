package com.example.voucher;
<<<<<<< HEAD
=======
 
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import com.exemple.model.Voucher;

=======
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Voucher> {
	private LayoutInflater mLayoutInflate = null;
	private ArrayList<Voucher> mArrayList;
<<<<<<< HEAD

	public CustomAdapter(Context context, int resource,
			ArrayList<Voucher> arrayList) {
		super(context, resource, arrayList);
		mLayoutInflate = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mArrayList = arrayList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = convertView;

		if (view == null) {
			view = mLayoutInflate.inflate(R.layout.custom_voucher, null);

			TextView tv1 = (TextView) view.findViewById(R.id.customvoucher);
			tv1.setText(mArrayList.get(position).getProduct_name());

		}
		return view;

	}

=======
	
	public CustomAdapter(Context context, int resource, ArrayList<Voucher> arrayList) {
		super(context, resource,arrayList);
		mLayoutInflate = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mArrayList = arrayList;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 View view =convertView;
		 Log.d("dohai","dohai1"); 
		 if (view==null) {
			 view = mLayoutInflate.inflate(R.layout.custom_voucher, null);
			
			 TextView tv1 = (TextView) view.findViewById(R.id.customvoucher);
			 tv1.setText(mArrayList.get(position).getProduct_name());
			 
		 }
		 return view;
		 
	}

 
 
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
}
