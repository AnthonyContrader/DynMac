package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Sensor;

@Repository
@Transactional
public interface SensorRepository extends CrudRepository<Sensor, Long> {

}