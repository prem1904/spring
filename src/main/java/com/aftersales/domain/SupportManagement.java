package com.aftersales.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SupportManagement {
	@Id
	private String supportid;
	
	private Double supportcost;
	
	private String supportdesc;
	
	private String assetid;
	
	private String customerid;
	
	private String providerid;
	
	private LocalDate nextinspection;
	
	private List<Problem> problem;

	public String getSupportid() {
		return supportid;
	}

	public void setSupportid(String supportid) {
		this.supportid = supportid;
	}

	public Double getSupportcost() {
		return supportcost;
	}

	public void setSupportcost(Double supportcost) {
		this.supportcost = supportcost;
	}

	public String getSupportdesc() {
		return supportdesc;
	}

	public void setSupportdesc(String supportdesc) {
		this.supportdesc = supportdesc;
	}

	public String getAssetid() {
		return assetid;
	}

	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}

	public String getProviderid() {
		return providerid;
	}

	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}
	

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	

	public LocalDate getNextinspection() {
		return nextinspection;
	}

	public void setNextinspection(LocalDate nextinspection) {
		this.nextinspection = nextinspection;
	}

	public List<Problem> getProblem() {
		return problem;
	}

	public void setProblem(List<Problem> problem) {
		this.problem = problem;
	}

	public SupportManagement(Double supportcost, String supportdesc,String assetid,
			String customerid,String providerid, LocalDate nextinspection, List<Problem> problem) {
		this.supportcost = supportcost;
		this.supportdesc = supportdesc;
		this.assetid = assetid;
		this.customerid = customerid;
		this.providerid = providerid;
		this.nextinspection=nextinspection;
		this.problem=problem;
	}

	
	

}
