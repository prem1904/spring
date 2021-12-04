package com.aftersales.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Delivery{
	@Id
	private String deliveryid;
	
	private  String issuedate;
	
	private Customer customer;
	
	private ItemCost itemCost;
	
	
	private Item item[];

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(String deliveryid) {
		this.deliveryid = deliveryid;
	}

	public Item[] getItem() {
		return item;
	}

	public void setItem(Item[] item) {
		this.item = item;
	}

	public ItemCost getItemCost() {
		return itemCost;
	}

	public void setItemCost(ItemCost itemCost) {
		this.itemCost = itemCost;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	
	

}
