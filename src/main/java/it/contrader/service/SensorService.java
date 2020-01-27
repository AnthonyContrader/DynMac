package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.SensorConverter;
import it.contrader.dao.SensorRepository;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

@Service
public class SensorService extends AbstractService<Sensor, SensorDTO> {

	@Autowired
	private SensorConverter converter;
	@Autowired
	private SensorRepository repository;

}
