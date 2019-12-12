package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.MachineDTO;
import it.contrader.model.Machine;

public class MachineConverter {

	public MachineDTO toDTO(Machine machine) {
		MachineDTO machineDTO = new MachineDTO(machine.getId(), machine.getName(), machine.getNumber_sensors());
		return machineDTO;
	}
	
	public Machine toEntity(MachineDTO machineDTO) {
		Machine machine= new Machine(machineDTO.getId(), machineDTO.getName(), machineDTO.getNumber_sensors());
		return machine;
	}	

	public List<MachineDTO> toDTOList(List<Machine> machineList) {
		//Crea una lista vuota.
		List<MachineDTO> machineDTOList = new ArrayList<MachineDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Machine machine : machineList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			machineDTOList.add(toDTO(machine));
		}
		return machineDTOList;
	}

}
	

