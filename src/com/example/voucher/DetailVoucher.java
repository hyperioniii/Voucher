package com.example.voucher;

import org.json.JSONObject;

import com.example.config.ConfigurationWS;
<<<<<<< HEAD
import com.exemple.model.Voucher;
=======
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93

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
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93

public class DetailVoucher extends Activity {
	ProgressDialog progress;
	Voucher voucher;
<<<<<<< HEAD
	TextView product_name;
	TextView quantity;
	TextView status;
	TextView barcode;
	TextView date;
	ConfigurationWS WSdetail = new ConfigurationWS(DetailVoucher.this);
	// private static final String url =
	// "http://117.6.131.222:8090/POS/WSERP/delete_product.php";
	private static final String url = "http://117.6.131.222:8090/POS/WSERP/delete_product.php";

=======
	ConfigurationWS WSdetail = new ConfigurationWS(DetailVoucher.this);
	private static final String url = "http://192.168.0.102/tmp_store_voucher_details/delete_product.php";
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		Bundle bundle = getIntent().getExtras();
		voucher = bundle.getParcelable("voucher");
<<<<<<< HEAD
		product_name = (TextView) findViewById(R.id.productnamedetail);
		quantity = (TextView) findViewById(R.id.quantitydetail);
		status = (TextView) findViewById(R.id.statusdetail);
		barcode = (TextView) findViewById(R.id.barcodedetail);
		date = (TextView) findViewById(R.id.date);
		product_name.setText(voucher.getProduct_name());
		quantity.setText(voucher.getQuantity());
		status.setText(voucher.getStatus());
		barcode.setText(voucher.getBarcode());
		Log.d("date", voucher.getCreate_time());
		date.setText(voucher.getCreate_time());
		ImageButton update = (ImageButton) findViewById(R.id.sua);
		ImageButton xoa = (ImageButton) findViewById(R.id.xoa);
		xoa.setOnClickListener(new OnClickListener() {

=======
		ImageButton xoa = (ImageButton) findViewById(R.id.xoa);
		xoa.setOnClickListener(new OnClickListener() {
			
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new delete().execute();
			}
		});
<<<<<<< HEAD
		update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(DetailVoucher.this,
						EditVoucher.class);
				Bundle bun = new Bundle();
				bun.putParcelable("detailvoucher", voucher);
				intent.putExtras(bun);
				startActivity(intent);
			}
		});
	}

	class delete extends AsyncTask<String, String, String> {
=======
		
	}
	class delete extends AsyncTask<String, String, String>{
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
<<<<<<< HEAD
			try {
				JSONObject json = new JSONObject();
				json.put("id", voucher.getId());
				WSdetail.connectWSPut_Get_Data(url, json, "voucher");
				Log.d("delet", "delte");
			} catch (Exception e) {
			}
=======
			try{
			JSONObject json = new JSONObject();
			json.put("id", voucher.getId());
			WSdetail.connectWSPut_Get_Data(url, json, "voucher");
			Log.d("delet", "delte");
			}catch(Exception e){}
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			progress.dismiss();
			super.onPostExecute(result);
<<<<<<< HEAD
			Intent intent = new Intent(DetailVoucher.this, ListVoucher.class);
			startActivity(intent);
			finish();
		}
=======
			Intent intent = new Intent(DetailVoucher.this,MainActivity.class);
			startActivity(intent);
		}

>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
<<<<<<< HEAD
			progress = new ProgressDialog(DetailVoucher.this);
=======
			progress= new ProgressDialog(DetailVoucher.this);
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
			progress.setMessage("Loading products. Please wait...");
			progress.setIndeterminate(false);
			progress.setCancelable(false);
			progress.show();
<<<<<<< HEAD
		}

=======
			
		}
		
>>>>>>> e58fe8ec26fb1aec883172426e84db0e7c674b93
	}
}
