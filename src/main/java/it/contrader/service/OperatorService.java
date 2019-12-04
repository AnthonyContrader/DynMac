package it.contrader.service;

import java.util.List;

import it.contrader.converter.OperatorConverter;
import it.contrader.dao.OperatorDAO;
import it.contrader.dto.OperatorDTO;

public class OperatorService {
	
	private OperatorDAO operatorDAO;
	private OperatorConverter operatorConverter;
	
	//Istanzio DAO  e Converter specifici.
	public OperatorService(){
		this.operatorDAO = new OperatorDAO();
		this.operatorConverter = new OperatorConverter();
	}
	

	public List<OperatorDTO> getAll() {
		return operatorConverter.toDTOList(operatorDAO.getAll());
	}


	public OperatorDTO read(int id) {
		return operatorConverter.toDTO(operatorDAO.read(id));
	}


	public boolean insert(OperatorDTO dto) {
		return operatorDAO.insert(operatorConverter.toEntity(dto));
	}


	public boolean update(OperatorDTO dto) {
		return operatorDAO.update(operatorConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		return operatorDAO.delete(id);
	}
	


}
