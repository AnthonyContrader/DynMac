package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Department;

@Repository
@Transactional
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}