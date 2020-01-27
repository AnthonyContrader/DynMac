package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.OperatorConverter;
import it.contrader.dao.OperatorRepository;
import it.contrader.dto.OperatorDTO;
import it.contrader.model.Operator;

@Service
public class OperatorService extends AbstractService<Operator, OperatorDTO> {

	@Autowired
	private OperatorConverter converter;
	@Autowired
	private OperatorRepository repository;

}
