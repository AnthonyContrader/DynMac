package it.contrader.service;

import java.util.List;

import it.contrader.converter.DepartmentConverter;
import it.contrader.dao.DepartmentDAO;
import it.contrader.dto.DepartmentDTO;
import it.contrader.dto.MachineDTO;

public class DepartmentService implements Service<DepartmentDTO> {
	
	private DepartmentDAO departmentDAO;
	private DepartmentConverter departmentConverter;
	
	//Istanzio DAO  e Converter specifici.
	public DepartmentService(){
		this.departmentDAO = new DepartmentDAO();
		this.departmentConverter = new DepartmentConverter();
	}
	

	public List<DepartmentDTO> getAll() {
		return departmentConverter.toDTOList(departmentDAO.getAll());
	}


	public DepartmentDTO read(int id) {
		return departmentConverter.toDTO(departmentDAO.read(id));
	}


	public boolean insert(DepartmentDTO dto) {
		return departmentDAO.insert(departmentConverter.toEntity(dto));
	}


	public boolean update(DepartmentDTO dto) {
		return departmentDAO.update(departmentConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		return departmentDAO.delete(id);
	}
	

}
