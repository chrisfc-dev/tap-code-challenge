package com.iav.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iav.tcc.entity.MasterObj;

@Repository
public interface MasterObjRepository extends CrudRepository<MasterObj, Integer>{
	
	@Query("FROM MasterObj WHERE (envId = ?1 or -1 = ?1) AND (appId = ?2 or -1 = ?2) AND (clientId = ?3 or -1 = ?3)")
	List<MasterObj> getObjectByParam(int envId, int appId, int clientId);
	
	@Query("FROM MasterObj WHERE (appId = ?1) AND (clientId = ?2) AND (envId = ?3) AND (ipId = ?4)")
	MasterObj getMasterObjBy( int appId, int clientId,int envId, int ipId);
	
	@Query("FROM MasterObj WHERE (appId = ?1) AND (envId = ?2) AND (clientId = ?3)")
	List<MasterObj> getMasterObjBy(int appId, int envId, int clientId);
	
}
