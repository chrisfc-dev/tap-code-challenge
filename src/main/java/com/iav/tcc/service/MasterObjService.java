package com.iav.tcc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iav.tcc.entity.MasterObj;
import com.iav.tcc.repository.MasterObjRepository;

@Service
public class MasterObjService {
	@Autowired
	private MasterObjRepository masterObjRepository;
	
	
	public MasterObj addClientIp(MasterObj master) throws Exception {
		Iterable<MasterObj> masterItr = masterObjRepository.findAll();
		for(MasterObj obj : masterItr) {
			if(obj.isEquals(master)) {
				throw new Exception("User already exist in the database");
			}
		}
		return masterObjRepository.save(master);
	}
	
	public List<MasterObj> getObjectByParam(int envId, int appId, int clientId){
		return masterObjRepository.getObjectByParam(envId, appId, clientId);
	}
	
	public List<Integer> getObjectByParam(List<MasterObj> masterObj){
		List<Integer> ipId = new ArrayList<>();
		for(MasterObj obj : masterObj) {
			if(!ipId.contains(obj.getIpId())) {
				ipId.add(obj.getIpId());
			}
		}
		return ipId;
	}
	
	public boolean isDataExist(int appId,int clientId, int environmentId, int clientIp) {
		MasterObj obj = masterObjRepository.getMasterObjBy(appId, clientId, environmentId, clientIp);
		return obj == null;
	}
	
	public boolean isDataExist(int appId, int envId, int clientId) {
		List<MasterObj> obj = getMasterObjBy(appId, envId, clientId);
		return obj.size() > 0;
	}
	
	public void deleteById(int id) {
		masterObjRepository.deleteById(id);
	}
	
	public MasterObj getMasterObjBy(int appId,int clientId, int environmentId, int clientIp) {
		return masterObjRepository.getMasterObjBy(appId, clientId, environmentId, clientIp);
	}
	
	public List<MasterObj> getMasterObjBy(int appId, int envId, int clientId){
		return masterObjRepository.getMasterObjBy(appId, envId, clientId);
	}
}
