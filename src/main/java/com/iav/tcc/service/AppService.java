package com.iav.tcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iav.tcc.entity.App;
import com.iav.tcc.repository.AppRepository;

@Service
public class AppService {
	
	@Autowired
	private AppRepository appRepository;
	
	public App addApp(App app) {
		App appObj = null;
		boolean isAppFound = false;
		Iterable<App> appItr = appRepository.findAll();
		for(App obj:appItr) {
			if(app.getAppName().toUpperCase().equals(obj.getAppName().toUpperCase())) {
				appObj = obj;
				isAppFound = true;
				break;
			}
		}
		if(!isAppFound) {appObj = appRepository.save(app);}
		return appObj;
	}
	
	public int getIdByName(String name) {
		int id = -1;
		Iterable<App> appItr = appRepository.findAll();
		for(App obj:appItr) {
			if(name.toUpperCase().equals(obj.getAppName().toUpperCase())) {
				return obj.getAppNameId();
			}
		}
		return id;
	}
}
