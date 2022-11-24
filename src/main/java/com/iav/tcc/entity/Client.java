package com.iav.tcc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(generator = "clientId")
	private int clientId;
	@Column
	private String name;
	
	public Client() {
		
	}
	
	public Client(String name) {
		this.name = name;
	}
	
	public int getId() {
		return clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
