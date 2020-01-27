package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Report;

@Repository
@Transactional
public interface ReportRepository extends CrudRepository<Report, Long> {

}