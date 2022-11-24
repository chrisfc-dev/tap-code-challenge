package com.iav.tcc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IpAddress {
	
	@Id
	@GeneratedValue(generator = "ipAddressId")
	private int ipAddressId;
	@Column
	private String ipAddress;
	
	public IpAddress() {}

	public IpAddress(String ipAddress) {
		super();
		this.ipAddress = ipAddress;
	}

	public int getIpAddressId() {
		return ipAddressId;
	}

	public void setIpAddressId(int ipAddressId) {
		this.ipAddressId = ipAddressId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	
}
