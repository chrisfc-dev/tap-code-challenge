package com.iav.tcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iav.tcc.entity.Environment;
import com.iav.tcc.repository.EnvironmentRepository;

@Service
public class EnvironmentService {
	
	@Autowired
	private EnvironmentRepository envRepository;
	
	public Environment addEnv(Environment env) {
		Environment envObj = null;
		boolean isEnvironmentFound = false;
		Iterable<Environment> envItr = envRepository.findAll();
		for(Environment obj:envItr) {
			if(env.getEnvironmentName().toUpperCase().equals(obj.getEnvironmentName().toUpperCase())) {
				envObj = obj;
				isEnvironmentFound = true;
				break;
			}
		}
		if(!isEnvironmentFound) {envObj = envRepository.save(env);}
		return envObj;
	}
	
	public int getEnvironmentIdByName(String name) {
		int id = -1;
		Iterable<Environment> envItr = envRepository.findAll();
		for(Environment obj:envItr) {
			if(obj.getEnvironmentName().toUpperCase().equals(name.toUpperCase())) {
				id = obj.getEnvironmentId();
				break;
			}
		}
		return id;
	}

}
