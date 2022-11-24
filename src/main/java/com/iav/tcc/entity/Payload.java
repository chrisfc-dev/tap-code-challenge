package com.iav.tcc.entity;


public class Payload {
	private String name;
	private String ipAddress;
	private String environment;
	private String appName;
	
	public Payload(String name, String ipAddress, String environment, String appName) {
		super();
		this.name = name;
		this.ipAddress = ipAddress;
		this.environment = environment;
		this.appName = appName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
}
