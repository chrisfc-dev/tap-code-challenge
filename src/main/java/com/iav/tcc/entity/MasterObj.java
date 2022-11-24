package com.iav.tcc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class MasterObj {
	@Id
	@GeneratedValue(generator = "masterObjId")
	private int masterObjId;
	@Column
	private int clientId;
	@Column
	private int ipId;
	@Column
	private int envId;
	@Column
	private int appId;
	
	public MasterObj() {}
	
	public MasterObj(int clientId, int ipId, int envId, int appId) {
		super();
		this.clientId = clientId;
		this.ipId = ipId;
		this.envId = envId;
		this.appId = appId;
	}

	public int getMasterObjId() {
		return masterObjId;
	}

	public void setMasterObjId(int masterObjId) {
		this.masterObjId = masterObjId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getIpId() {
		return ipId;
	}

	public void setIpId(int ipId) {
		this.ipId = ipId;
	}

	public int getEnvId() {
		return envId;
	}

	public void setEnvId(int envId) {
		this.envId = envId;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	public boolean isEquals(MasterObj obj) {
		return this.clientId == obj.clientId && this.appId == obj.appId && this.envId == obj.envId && this.ipId == obj.ipId;
	}
	
}
