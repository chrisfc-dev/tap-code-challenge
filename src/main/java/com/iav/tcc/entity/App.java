package com.iav.tcc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class App {
	
	@Id
	@GeneratedValue(generator = "appNameId")
	private int appNameId;
	@Column
	private String appName;
	
	public App() {}
	
	public App(String appName) {
		super();
		this.appName = appName;
	}
	public int getAppNameId() {
		return appNameId;
	}
	public void setAppNameId(int appNameId) {
		this.appNameId = appNameId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
}
