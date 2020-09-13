package com.dhafnas.featuremanage.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeatureRequestModel {

	private int id;
	private String title;
	private String description;
	private String client;
	private int priority;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date targetDate;
	private String productArea;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public String getProductArea() {
		return productArea;
	}
	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	
}