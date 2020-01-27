package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DepartmentDTO;

import it.contrader.model.Department;

@Component
public class DepartmentConverter extends AbstractConverter<Department, DepartmentDTO> {

	@Override
	public Department toEntity(DepartmentDTO departmentDTO) {
		Department department = null;
		if (departmentDTO != null) {
			department = new Department(departmentDTO.getId(), departmentDTO.getName(), departmentDTO.getNumber_operators());
		}
		return department;
	}

	@Override
	public DepartmentDTO toDTO(Department department) {
		DepartmentDTO departmentDTO = null;
		if (department != null) {
			departmentDTO = new DepartmentDTO(department.getId(), department.getName(), department.getNumber_operators());

		}
		return departmentDTO;
	}
}