package com.example.voucher;

import android.os.Parcel;
import android.os.Parcelable;

public class Voucher implements Parcelable {
	String id;
	String product_name;
	String quantity;
	String status;
	String barcode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Voucher(String id, String product_name, String quantity,
			String status, String barcode) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.status = status;
		this.barcode = barcode;
	}
	
	public Voucher(Parcel a){
		id = a.readString();
		product_name= a.readString();
		quantity= a.readString();
		status= a.readString();
		barcode= a.readString();
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel a, int arg1) {
		// TODO Auto-generated method stub
		a.writeString(id);
		a.writeString(product_name);
		a.writeString(quantity);
		a.writeString(status);
		a.writeString(barcode);
	}
	
	public static final Parcelable.Creator<Voucher> CREATOR = new Creator<Voucher>() {
		
		@Override
		public Voucher[] newArray(int arg0) {
			// TODO Auto-generated method stub
			return new Voucher[arg0];
		}
		
		@Override
		public Voucher createFromParcel(Parcel arg0) {
			// TODO Auto-generated method stub
			return new Voucher(arg0);
		}
	};

}
