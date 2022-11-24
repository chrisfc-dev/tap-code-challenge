package com.iav.tcc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Environment {
	
	@Id
	@GeneratedValue(generator = "environmentId")
	private int environmentId;
	@Column
	private String environmentName;
	
	public Environment() {}
	
	public Environment(String environmentName) {
		super();
		this.environmentName = environmentName;
	}
	public int getEnvironmentId() {
		return environmentId;
	}
	public void setEnvironmentId(int environmentId) {
		this.environmentId = environmentId;
	}
	public String getEnvironmentName() {
		return environmentName;
	}
	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
}
