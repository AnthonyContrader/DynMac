package it.contrader.service;

import java.util.List;

import it.contrader.converter.MachineConverter;
import it.contrader.dao.MachineDAO;
import it.contrader.dto.MachineDTO;

public class MachineService {

	private MachineDAO machineDAO;
	private MachineConverter machineConverter;
	
	//Istanzio DAO  e Converter specifici.
	public MachineService(){
		this.machineDAO = new MachineDAO();
		this.machineConverter = new MachineConverter();
	}
	
	public List<MachineDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return machineConverter.toDTOList(machineDAO.getAll());
	}


	public MachineDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return machineConverter.toDTO(machineDAO.read(id));
	}


	public boolean insert(MachineDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return machineDAO.insert(machineConverter.toEntity(dto));
	}


	public boolean update(MachineDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return machineDAO.update(machineConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return machineDAO.delete(id);
	}
			
	
}
