package com.iav.tcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iav.tcc.entity.App;

@Repository
public interface AppRepository extends CrudRepository<App, Integer> {

}
