package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.OperatorDTO;

import it.contrader.model.Operator;

@Component
public class OperatorConverter extends AbstractConverter<Operator, OperatorDTO> {
	@Autowired
	private DepartmentConverter departmentConverter;
	@Autowired
	private MachineConverter machineConverter;
	
	@Override
	public Operator toEntity(OperatorDTO operatorDTO) {
		Operator operator = null;
		operator = new Operator();
		operator.setId(operatorDTO.getId());
		if (operatorDTO.getName() != null) {
			operator.setName(operatorDTO.getName());
		}
		if (operatorDTO.getType() != null) {
			operator.setType(operatorDTO.getType());
		}
		if (operatorDTO.getDepartmentDTO() != null) {
			  operator.setDepartment(departmentConverter.toEntity(operatorDTO.getDepartmentDTO()));
		}
		if (operatorDTO.getMachineDTO() != null) {
			  operator.setMachine(machineConverter.toEntity(operatorDTO.getMachineDTO()));
		}
		return operator;
	}

	@Override
	public OperatorDTO toDTO(Operator operator) {
		OperatorDTO operatorDTO = null;
		operatorDTO = new OperatorDTO();
		operatorDTO.setId(operator.getId());
		if (operator.getName() != null) {
			operatorDTO.setName(operator.getName());
		}
		if (operator.getType() != null) {
			operatorDTO.setType(operator.getType());
		}
		if (operator.getDepartment() != null) {
			  operatorDTO.setDepartmentDTO(departmentConverter.toDTO(operator.getDepartment()));
		}
		if (operator.getMachine() != null) {
			  operatorDTO.setMachineDTO(machineConverter.toDTO(operator.getMachine()));
		}
		
		return operatorDTO;
	}

}