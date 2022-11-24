package com.iav.tcc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iav.tcc.entity.Client;
import com.iav.tcc.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public Client addClient(Client client) {
		Client clientObj = null;
		boolean isClientFound = false;
		Iterable<Client> clientItr = clientRepository.findAll();
		for(Client obj:clientItr) {
			if(client.getName().toUpperCase().equals(obj.getName().toUpperCase())) {
				clientObj = obj;
				isClientFound = true;
				break;
			}
		}
		if(!isClientFound) {clientObj = clientRepository.save(client);}
		return clientObj;
	}
	
	public int getClientIdByName(String name) {
		int id = -1;
		Iterable<Client> clientItr = clientRepository.findAll();
		for(Client obj:clientItr) {
			if(obj.getName().toUpperCase().equals(name.toUpperCase())) {
				id = obj.getId();
				break;
			}
		}
		return id;
	}
	
	public Client getClientByName(String name) {
		Client cli = null;
		Iterable<Client> clientItr = clientRepository.findAll();
		for(Client obj:clientItr) {
			if(obj.getName().toUpperCase().equals(name.toUpperCase())) {
				cli = obj;
				break;
			}
		}
		return cli;
	}
	

}
