package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.MachineDTO;

import it.contrader.model.Machine;

@Component
public class MachineConverter extends AbstractConverter<Machine, MachineDTO> {

	@Autowired
	private DepartmentConverter departmentConverter;
	
	@Override
	public Machine toEntity(MachineDTO machineDTO) {
		Machine machine = null;
		machine = new Machine();
		  machine.setId(machineDTO.getId());
		  if (machineDTO.getName() != null) {
			  machine.setName(machineDTO.getName());
		  }
		  if (machineDTO.getNumber_sensor() != 0) {
			  machine.setNumber_sensor(machineDTO.getNumber_sensor());
		  }
		  if (machineDTO.getDepartmentDTO() != null) {
			  machine.setDepartment(departmentConverter.toEntity(machineDTO.getDepartmentDTO()));
		  }
		  
		return machine;
	}

	@Override
	public MachineDTO toDTO(Machine machine) {
		MachineDTO machineDTO = null;
		machineDTO = new MachineDTO();
		  machineDTO.setId(machine.getId());
		  if (machine.getName() != null) {
			  machineDTO.setName(machine.getName());
		  }
		  if (machine.getNumber_sensor() != 0) {
			  machineDTO.setNumber_sensor(machine.getNumber_sensor());
		  }
		  if (machine.getDepartment() != null) {
			  machineDTO.setDepartmentDTO(departmentConverter.toDTO(machine.getDepartment()));
		  }
		 
		return machineDTO;
	}

}