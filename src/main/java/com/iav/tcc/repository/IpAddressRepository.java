package com.iav.tcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iav.tcc.entity.IpAddress;

@Repository
public interface IpAddressRepository extends CrudRepository<IpAddress, Integer>{

}
