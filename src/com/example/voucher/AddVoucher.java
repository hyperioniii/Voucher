package com.example.voucher;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.config.ConfigurationWS;

import android.app.Activity;
import android.app.ProgressDialog;
<<<<<<< HEAD
import android.content.Context;
=======
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
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
<<<<<<< HEAD
	ProgressDialog progress;
	// private static final String url =
	// "http://117.6.131.222:8090/POS/WSERP/create_product.php";
	private static final String url = "http://117.6.131.222:8090/POS/WSERP/create_product.php";
	EditText product_name;
	EditText quantity;
	EditText status;
	EditText barcode;
	EditText create_time;
=======
	ProgressDialog progress ;
	private static final String url = "http://192.168.0.102/tmp_store_voucher_details/create_product.php";
	ConfigurationWS WSaddvoucher = new ConfigurationWS(AddVoucher.this);
	
	EditText product_name;
	EditText quantity;
	EditText status ;
	EditText barcode ;
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
<<<<<<< HEAD
		setContentView(R.layout.addvoucher);
		ImageButton save = (ImageButton) findViewById(R.id.addvouchersave);
		product_name = (EditText) findViewById(R.id.addVcEdtPrdname);
		quantity = (EditText) findViewById(R.id.addVcEdtQuan);
		status = (EditText) findViewById(R.id.addVcEdtStat);
		barcode = (EditText) findViewById(R.id.addVcEtcBar);
		create_time = (EditText) findViewById(R.id.addVcEdtCretime);
		save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new WSAddvoucher(AddVoucher.this).execute();
			}
		});
	}

	class WSAddvoucher extends AsyncTask<String, String, String> {
		private String TAG = "WSGetAllPhone";
		private ConfigurationWS mWS;
		private Context context;
		private ProgressDialog mProgress;
		
		public WSAddvoucher(Context mcontext) {
			super();
			this.context = mcontext;
			mWS = new ConfigurationWS(mcontext);
			mProgress = new ProgressDialog(mcontext);
		}
		
		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try {
				JSONObject json = new JSONObject();
				String Strproduct_name = product_name.getText().toString();
				String Strquantity = quantity.getText().toString();
				String Strstatus = status.getText().toString();
				String Strbarcode = barcode.getText().toString();
				String Strcreate_time = create_time.getText().toString();
				json.put("product_name", Strproduct_name);
				json.put("quantity", Strquantity);
				json.put("status", Strstatus);
				json.put("barcode", Strbarcode);
				json.put("create_time", Strcreate_time);
				mWS.connectWSPut_Get_Data(url, json, "voucher");
			} catch (Exception e) {
			}
			return null;
		}

		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			progress.dismiss();
			Intent intent = new Intent(AddVoucher.this, ListVoucher.class);
			startActivity(intent);
		}
=======
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

>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
<<<<<<< HEAD
			progress = new ProgressDialog(AddVoucher.this);
=======
			progress= new ProgressDialog(AddVoucher.this);
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
			progress.setMessage("Loading products. Please wait...");
			progress.setIndeterminate(false);
			progress.setCancelable(false);
			progress.show();
		}
<<<<<<< HEAD
=======
		
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
	}
}
