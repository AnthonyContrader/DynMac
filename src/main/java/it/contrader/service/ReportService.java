package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ReportConverter;
import it.contrader.dao.ReportRepository;
import it.contrader.dto.ReportDTO;
import it.contrader.model.Report;

@Service
public class ReportService extends AbstractService<Report, ReportDTO> {

	@Autowired
	private ReportConverter converter;
	@Autowired
	private ReportRepository repository;

}
