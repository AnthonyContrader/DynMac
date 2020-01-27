package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.StoreConverter;
import it.contrader.dao.StoreRepository;
import it.contrader.dto.StoreDTO;
import it.contrader.model.Store;

@Service
public class StoreService extends AbstractService<Store, StoreDTO> {

	@Autowired
	private StoreConverter converter;
	@Autowired
	private StoreRepository repository;
	
}
