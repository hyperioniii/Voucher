package com.example.voucher;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.config.ConfigurationWS;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddVoucher extends Activity {
	ProgressDialog progress ;
	private static final String url = "http://192.168.0.102/tmp_store_voucher_details/create_product.php";
	ConfigurationWS WSaddvoucher = new ConfigurationWS(AddVoucher.this);
	
	EditText product_name;
	EditText quantity;
	EditText status ;
	EditText barcode ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insert);
		ImageButton save = (ImageButton) findViewById(R.id.save);
	product_name = (EditText) findViewById(R.id.productname);
	quantity = (EditText) findViewById(R.id.quantity);
		status = (EditText) findViewById(R.id.status);
		barcode = (EditText) findViewById(R.id.barcode);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new addvoucher().execute();
			}
		});
	}
	class addvoucher extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try{
			JSONObject json = new JSONObject();
			String product_namej =product_name.getText().toString();
			String quantityj = quantity.getText().toString();
			String statusj = status.getText().toString();
			String barcodej = barcode.getText().toString();
		/*	Log.d("add", product_namej+quantityj+statusj);*/
			Log.d("add", "fdakf;ajk");
			json.put("product_name", product_namej);
			json.put("quantity", quantityj);
			json.put("status", statusj);
			json.put("barcode", barcodej);
		 
			
			 WSaddvoucher.connectWSPut_Get_Data(url, json, "voucher");
			}catch(Exception e){}
			 
			return null;
		}
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			progress.dismiss();
			Intent intent = new Intent(AddVoucher.this,MainActivity.class);
			startActivity(intent);
			  
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progress= new ProgressDialog(AddVoucher.this);
			progress.setMessage("Loading products. Please wait...");
			progress.setIndeterminate(false);
			progress.setCancelable(false);
			progress.show();
		}
		
	}
}
