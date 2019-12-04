package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DepartmentDTO;
import it.contrader.model.Department;

public class DepartmentConverter {
	
	public DepartmentDTO toDTO(Department department) {
		DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(), department.getName(), department.getNumber_operators());
		return departmentDTO;
	}

	
	public Department toEntity(DepartmentDTO departmentDTO) {
		Department department = new Department(departmentDTO.getId(), departmentDTO.getName(), departmentDTO.getNumber_operators());
		return department;
	}
	
	
	public List<DepartmentDTO> toDTOList(List<Department> departmentList) {

		List<DepartmentDTO> departmentDTOList = new ArrayList<DepartmentDTO>();
		
		for(Department department : departmentList) {

			departmentDTOList.add(toDTO(department));
		}
		return departmentDTOList;
	}

}
