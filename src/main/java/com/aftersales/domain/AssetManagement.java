package com.aftersales.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AssetManagement {
	@Id
	private String assetid;
	
	private String assetname;
	
	private String assetcode;
	
	private String customerid;
	
	private Double price;
	
	private LocalDate purchasedate;
	
	private String  category;
	
	private String manufacturer;
	
    private String quickreponse;
	


	public String getAssetid() {
		return assetid;
	}

	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}

	public String getAssetname() {
		return assetname;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	
	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(LocalDate purchasedate) {
		this.purchasedate = purchasedate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	
	public String getAssetcode() {
		return assetcode;
	}

	public void setAssetcode(String assetcode) {
		this.assetcode = assetcode;
	}

	public AssetManagement(String assetname,String assetcode, String customerid, Double price, LocalDate purchasedate, String category,
			String manufacturer) {
		this.assetname = assetname;
		this.assetcode=assetcode;
		this.customerid = customerid;
		this.price = price;
		this.purchasedate = purchasedate;
		this.category = category;
		this.manufacturer = manufacturer;
	}

	public String getQuickreponse() {
		return quickreponse;
	}

	public void setQuickreponse(String quickreponse) {
		this.quickreponse = quickreponse;
	}


	
}
