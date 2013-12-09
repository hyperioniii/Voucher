package com.example.voucher;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.config.ConfigurationWS;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
	ProgressDialog progress;
	// private static final String url =
	// "http://117.6.131.222:8090/POS/WSERP/create_product.php";
	private static final String url = "http://117.6.131.222:8090/POS/WSERP/create_product.php";
	EditText product_name;
	EditText quantity;
	EditText status;
	EditText barcode;
	EditText create_time;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
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
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progress = new ProgressDialog(AddVoucher.this);
			progress.setMessage("Loading products. Please wait...");
			progress.setIndeterminate(false);
			progress.setCancelable(false);
			progress.show();
		}
	}
}
