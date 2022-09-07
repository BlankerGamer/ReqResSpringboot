package com.example.RequestResponse.model;

import java.util.Date;

public class ResponseModel {
	private Long id;
	private String responseData;
	private String createBy;
	private String createIp;
	private Date createDateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponseData() {
		return responseData;
	}
	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateIp() {
		return createIp;
	}
	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	
}
