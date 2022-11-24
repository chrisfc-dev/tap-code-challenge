package com.iav.tcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iav.tcc.entity.Environment;

@Repository
public interface EnvironmentRepository extends CrudRepository<Environment, Integer>{

}
