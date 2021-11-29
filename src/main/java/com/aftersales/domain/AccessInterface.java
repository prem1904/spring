package com.aftersales.domain;

import java.io.Serializable;

public class AccessInterface implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String assetid;
	
	String customerid;
	
	

	public AccessInterface() {
	}

	public String getAssetid() {
		return assetid;
	}

	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public AccessInterface(String assetid, String customerid) {
		this.assetid = assetid;
		this.customerid = customerid;
	}

	
	
	
	
	

}
