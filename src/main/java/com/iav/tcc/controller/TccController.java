package com.iav.tcc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iav.tcc.entity.App;
import com.iav.tcc.entity.Client;
import com.iav.tcc.entity.Environment;
import com.iav.tcc.entity.MasterObj;
import com.iav.tcc.entity.MessageHandler;
import com.iav.tcc.entity.IpAddress;
import com.iav.tcc.entity.Payload;
import com.iav.tcc.service.MasterObjService;
import com.iav.tcc.service.AppService;
import com.iav.tcc.service.ClientService;
import com.iav.tcc.service.EnvironmentService;
import com.iav.tcc.service.IpAddressService;

@RestController
@RequestMapping("/api/v1")
public class TccController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private IpAddressService ipAddressService;
	@Autowired
	private MasterObjService masterObjService;
	@Autowired
	private AppService appService;
	@Autowired
	private EnvironmentService envService;

	@RequestMapping(value = "/clients", method = RequestMethod.POST, 
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<MessageHandler> addClient(@RequestBody Payload payload) {
		try {
			Client client = clientService.addClient(new Client(payload.getName()));
			IpAddress ip = ipAddressService.add(new IpAddress(payload.getIpAddress()));
			App app = appService.addApp(new App(payload.getAppName()));
			Environment env = envService.addEnv(new Environment(payload.getEnvironment()));
			masterObjService.addClientIp(
					new MasterObj(client.getId(), ip.getIpAddressId(), env.getEnvironmentId(), app.getAppNameId()));
			return new ResponseEntity<> (new MessageHandler("Successfully added to dbs"), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<> (new MessageHandler(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/ips", method = RequestMethod.GET, 
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<String>> getIp(
			@RequestParam(required = false, defaultValue = "-1") String environment, 
			@RequestParam(required = false, defaultValue = "-1") String app,
			@RequestParam(required = false, defaultValue = "-1") String client) 
	{
		int clientId = clientService.getClientIdByName(client);
		int envId = envService.getEnvironmentIdByName(environment);
		int appId = appService.getIdByName(app);
		if (envId == -1 && appId == -1 && clientId == -1) {
			return new ResponseEntity<> (ipAddressService.getAllIp(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (ipAddressService.getAllIpByIntegers(masterObjService.getObjectByParam(masterObjService.getObjectByParam(envId, appId, clientId))), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/{apps}/{environments}/{client}/{ip}", method = RequestMethod.DELETE,
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<MessageHandler> deleteIp(@PathVariable String apps, @PathVariable String environments, @PathVariable String client, @PathVariable String ip){
		int clientIp = ipAddressService.getIdByIp(ip);
		int envId = envService.getEnvironmentIdByName(environments);
		int appId = appService.getIdByName(apps);
		int clientId = clientService.getClientIdByName(client);
		if ((envId == -1 || appId == -1 || clientIp == -1 || clientId == -1) || masterObjService.isDataExist(appId, clientId, envId, clientIp)) {
			return new ResponseEntity<> (new MessageHandler("Invalid path"), HttpStatus.NOT_FOUND);
		}
		try {
			MasterObj obj = masterObjService.getMasterObjBy(appId, clientId, envId, clientIp);
			masterObjService.deleteById(obj.getMasterObjId());
			return new ResponseEntity<> (new MessageHandler("Successfully Deleted"), HttpStatus.ACCEPTED); 
		}
		catch (Exception e){
			return new ResponseEntity<> (new MessageHandler(e.getMessage()), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/{apps}/{environment}", method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<MessageHandler> testUser(@PathVariable String apps, @PathVariable String environment, @RequestParam(required = true) String name){
		Client client = clientService.getClientByName(name);
		if(client == null) {
			return new ResponseEntity<> (new MessageHandler("User does not exist"), HttpStatus.NOT_FOUND);
		}
		try {
			int appId = appService.getIdByName(apps);
			int envId = envService.getEnvironmentIdByName(environment);
			int clientId = client.getId();
			boolean isDataExist = masterObjService.isDataExist(appId, envId, clientId);
			if ((envId == -1 || appId == -1) || !isDataExist) {
				return new ResponseEntity<> (new MessageHandler("ACCESS DENIED"), HttpStatus.UNAUTHORIZED);
			}
			return new ResponseEntity<> (new MessageHandler("ACCESS GRANTED"), HttpStatus.ACCEPTED); 
		}
		catch (Exception e){
			return new ResponseEntity<> (new MessageHandler(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
}
