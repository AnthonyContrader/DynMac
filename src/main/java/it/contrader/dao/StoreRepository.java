package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Store;;

@Repository
@Transactional
public interface StoreRepository extends CrudRepository<Store, Long> {

	
	
}