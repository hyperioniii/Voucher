package com.example.voucher;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.config.ConfigurationWS;


 
 

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ArrayList<Voucher> myArrayList = new ArrayList<Voucher>();
	ListView myListView; 
	CustomAdapter myCustomAdapter ;
	ConfigurationWS WSgetall = new ConfigurationWS(this);
	ProgressDialog progress;
	Bundle bundlerefrest;
	private static final String url = "http://192.168.0.102/tmp_store_voucher_details/get_all_products.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bundlerefrest= savedInstanceState;
		setContentView(R.layout.invoice);
		final ListView myListView = (ListView) findViewById(R.id.listvoucher);
		myCustomAdapter = new CustomAdapter(getApplicationContext(), 1, myArrayList);
    	myListView.setAdapter(myCustomAdapter);
		ImageButton myimageButton = (ImageButton) findViewById(R.id.add);
		ImageButton refreshButton = (ImageButton) findViewById(R.id.refress);
		new Getall().execute();
		
		
		refreshButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		myimageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,AddVoucher.class);
				startActivity(intent);
			}
		});
		
		
		myListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Voucher voucher = (Voucher)myListView.getItemAtPosition(arg2);
				Intent intent = new Intent(MainActivity.this, DetailVoucher.class);
				Bundle bundle = new Bundle();
				bundle.putParcelable("voucher", voucher);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
	
	class Getall extends AsyncTask<String, String , String>{
		 
		@Override
		protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
			JSONObject json = new JSONObject();
			JSONArray jsonarray = new JSONArray();
			try{
				jsonarray= WSgetall.connectWSPut_Get_Data(url, json, "voucher");
				for(int i =0 ;i<jsonarray.length();i++){
					json = jsonarray.getJSONObject(i);
					String id = json.getString("id");
					String product_name = json.getString("product_name");
					String quantity = json.getString("quantity");
					String status = json.getString("status");
					String barcode = json.getString("barcode");
					Voucher voucher = new Voucher(id, product_name, quantity, status, barcode);
					myArrayList.add(voucher);
				}
				Log.d("fda", myArrayList.get(1).getProduct_name());
			}catch(Exception e){}
			return null;
			
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			progress.dismiss();
			
			 myCustomAdapter.notifyDataSetChanged();
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progress= new ProgressDialog(MainActivity.this);
			progress.setMessage("Loading products. Please wait...");
			progress.setIndeterminate(false);
			progress.setCancelable(false);
			progress.show();
		}
		
	} 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
