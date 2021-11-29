package com.aftersales.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Problem {
	
	@Id
	private String problemid;
	
	private String problemdesc;
	
	private String status;
	
	private String statusdate;

	public String getProblemid() {
		return problemid;
	}

	public void setProblemid(String problemid) {
		this.problemid = problemid;
	}

	public String getProblemdesc() {
		return problemdesc;
	}

	public void setProblemdesc(String problemdesc) {
		this.problemdesc = problemdesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(String statusdate) {
		this.statusdate = statusdate;
	}
	

	public Problem(String problemdesc, String status, String statusdate) {
		this.problemdesc = problemdesc;
		this.status = status;
		this.statusdate = statusdate;
	}
	
	
	
	
	
	
	
	

}
