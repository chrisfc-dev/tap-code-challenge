package com.iav.tcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iav.tcc.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
	
}
