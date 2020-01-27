package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.DepartmentConverter;
import it.contrader.dao.DepartmentRepository;
import it.contrader.dto.DepartmentDTO;
import it.contrader.model.Department;

@Service
public class DepartmentService extends AbstractService<Department, DepartmentDTO> {

	@Autowired
	private DepartmentConverter converter;
	@Autowired
	private DepartmentRepository repository;

}
