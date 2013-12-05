package com.example.voucher;

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
import android.widget.EditText;
import android.widget.ImageButton;

public class DetailVoucher extends Activity {
	ProgressDialog progress;
	Voucher voucher;
	ConfigurationWS WSdetail = new ConfigurationWS(DetailVoucher.this);
	private static final String url = "http://192.168.0.102/tmp_store_voucher_details/delete_product.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		Bundle bundle = getIntent().getExtras();
		voucher = bundle.getParcelable("voucher");
		ImageButton xoa = (ImageButton) findViewById(R.id.xoa);
		xoa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new delete().execute();
			}
		});
		
	}
	class delete extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try{
			JSONObject json = new JSONObject();
			json.put("id", voucher.getId());
			WSdetail.connectWSPut_Get_Data(url, json, "voucher");
			Log.d("delet", "delte");
			}catch(Exception e){}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			progress.dismiss();
			super.onPostExecute(result);
			Intent intent = new Intent(DetailVoucher.this,MainActivity.class);
			startActivity(intent);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progress= new ProgressDialog(DetailVoucher.this);
			progress.setMessage("Loading products. Please wait...");
			progress.setIndeterminate(false);
			progress.setCancelable(false);
			progress.show();
			
		}
		
	}
}
